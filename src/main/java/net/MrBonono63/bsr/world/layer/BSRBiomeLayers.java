package net.MrBonono63.bsr.world.layer;

import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.util.CachingLayerContext;
import net.minecraft.world.biome.layer.util.LayerFactory;
import net.minecraft.world.biome.layer.util.LayerSampleContext;
import net.minecraft.world.biome.layer.util.LayerSampler;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import java.util.function.LongFunction;

public class BSRBiomeLayers {
    private static final int biomeSize = 4; // 3 should be the *minimum* value for this

    private static <R extends LayerSampler, T extends LayerSampleContext<R>> LayerFactory<R> create(LongFunction<T> contextProvider) {
        // Biome Groups
        LayerFactory<R> biomeInit = SetBiomeGroupsLayer.INSTANCE.create(contextProvider.apply(1L));
        biomeInit = ScaleLayer.NORMAL.create(contextProvider.apply(100L), biomeInit);

        // Biomes
        biomeInit = AddBiomesLayer.INSTANCE.create(contextProvider.apply(20L), biomeInit);
        LayerFactory<R> biomes = ScaleLayer.NORMAL.create(contextProvider.apply(1000L), biomeInit);

        for (int i = 0; i < biomeSize; ++i) {
            biomes = ScaleLayer.NORMAL.create(contextProvider.apply(1000L + (long) i), biomes);
        }

        return biomes;
    }

    public static BiomeLayerSampler build(long seed) {
        return new BiomeLayerSampler(create((salt) -> new CachingLayerContext(25, seed, salt)));
    }
}
