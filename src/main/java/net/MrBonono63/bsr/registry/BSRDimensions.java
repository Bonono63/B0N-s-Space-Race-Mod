package net.MrBonono63.bsr.registry;

import com.github.draylar.worldtraveler.api.dimension.DimensionBuilder;
import net.MrBonono63.bsr.BSRConfig;
import net.MrBonono63.bsr.world.BSRChunkGeneratorConfig;
import net.MrBonono63.bsr.world.biome.BSRBiomeSource;
import net.MrBonono63.bsr.world.BSRChunkGeneratorType;
import net.MrBonono63.bsr.world.dimension.BSRBackgroundColorCalculator;
import net.MrBonono63.bsr.world.dimension.BSRFogColorCalculator;
import net.MrBonono63.bsr.world.dimension.BSRSkyAngleCalculator;
import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.MrBonono63.bsr.BSR;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;

public class BSRDimensions {
    public static EntityPlacer FIND_SURFACE = (entity, world, dim, offsetX, offsetZ) -> new BlockPattern.TeleportTarget(new Vec3d(entity.getBlockPos().getX(), world.getChunk(entity.getBlockPos().getX() >> 4, entity.getBlockPos().getZ() >> 4).sampleHeightmap(Heightmap.Type.MOTION_BLOCKING, entity.getBlockPos().getX() & 15, entity.getBlockPos().getZ() & 15) + 1, entity.getBlockPos().getZ()), entity.getVelocity(), (int)entity.yaw);

    public static final FabricDimensionType SPACE01 = FabricDimensionType.builder()
            .skyLight(true)
            .factory((world, type) -> new DimensionBuilder()
                    .hasThickFog(false)
                    .fogColor(new BSRFogColorCalculator())
                    .backgroundColor(new BSRBackgroundColorCalculator())
                    .visibleSky(true)
                    .skyAngle(new BSRSkyAngleCalculator())
                    .setChunkGenerator(BSRChunkGeneratorType.INSTANCE.create(world, new BSRBiomeSource(world.getSeed()), new BSRChunkGeneratorConfig()))
                    .setLightLevelsToBrightness(getLightLevels())
                    .doesWaterVaporize(BSRConfig.BSRDimensions.waterVaporizes)
                    .build(world, type))
            .defaultPlacer(FIND_SURFACE)
            .buildAndRegister(BSR.id("space01"));

    private BSRDimensions() {
        //NO-OP
    }

    public static void init(){
        //NO-OP
    }

    public static float[] getLightLevels() {
        float[] lightLevels = new float[16];

        for (int i = 0; i <= 15; ++i) {
            float lightLevel = 1.0F - (float) i / 15.0F;
            lightLevels[i] = ((1.0F - lightLevel) / (lightLevel * 3.0F + 1.0F) * 1.0F + 0.0F);
        }

        return lightLevels;
    }
}
