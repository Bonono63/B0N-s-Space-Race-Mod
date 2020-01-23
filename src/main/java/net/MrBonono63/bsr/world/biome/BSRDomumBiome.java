package net.MrBonono63.bsr.world.biome;

import net.MrBonono63.bsr.world.feature.BSRBiomeFeatures;

public class BSRDomumBiome extends BSRBaseBiome{
    public BSRDomumBiome(float depth, float scale) {
        super(new Settings()
                .precipitation(Precipitation.RAIN)
                .category(Category.NONE)
                .depth(depth)
                .scale(scale)
                .temperature(0.6f)
                .downfall(0.8f)
                .waterColor(0x205bc9)
                .waterFogColor(0x0d2b91)
                .surfaceBuilder(null)
                .parent(null)
                .configureSurfaceBuilder(null,null));

        GRASS_COLOR = 0x54bf79;
        FOLIAGE_COLOR = 0x54bf79;

        BSRBiomeFeatures.addAsteroids(this);
    }
}
