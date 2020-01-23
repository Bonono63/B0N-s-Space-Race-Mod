package net.MrBonono63.bsr.world.biome;

import com.google.common.collect.Lists;
import net.MrBonono63.bsr.api.BSRBiomeInfo;
import net.MrBonono63.bsr.world.feature.BSRBiomeFeatures;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

import java.util.List;

public abstract class BSRBaseBiome extends Biome implements BSRBiomeInfo {
    public static final List<Biome> BIOMES = Lists.newArrayList();
    protected int GRASS_COLOR = 0xffffff;
    protected int FOLIAGE_COLOR = 0xffffff;

    protected BSRBaseBiome(Settings settings) {
        super(settings.parent(null));

        BIOMES.add(this);
    }

    @Override
    public int getSkyColor() {
        return 0x360063;
    }

    @Override
    public Vec3d getFogColor() {
        return new Vec3d(104F / 255F, 84F / 255F, 117F / 255F);
    }

    @Override
    public float getFogIntensity() {
        return 192;
    }

    @Override
    public boolean shouldFogRender() {
        return true;
    }

    @Override
    public int getGrassColorAt(double x, double z) {
        return GRASS_COLOR;
    }

    @Override
    public int getFoliageColor() {
        return FOLIAGE_COLOR;
    }
}
