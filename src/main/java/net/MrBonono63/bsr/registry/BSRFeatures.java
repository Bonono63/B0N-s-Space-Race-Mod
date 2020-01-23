package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.world.feature.AsteroidFeature;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import net.MrBonono63.bsr.BSR;

public class BSRFeatures {
    public static final TernarySurfaceConfig SPACE01 = new TernarySurfaceConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());

    public static final Feature<DefaultFeatureConfig> ASTEROID = register("asteroid", new AsteroidFeature());

    public static <C extends FeatureConfig, F extends Feature<C>> F register(String name, F feature) {
        return Registry.register(Registry.FEATURE, BSR.id(name), feature);
    }

    public static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String name, F surfaceBuilder) {
        return Registry.register(Registry.SURFACE_BUILDER, BSR.id(name), surfaceBuilder);
    }
}
