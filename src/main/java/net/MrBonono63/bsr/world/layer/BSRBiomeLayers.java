package net.MrBonono63.bsr.world.layer;

import net.minecraft.world.biome.layer.AddRiversLayer;
import net.minecraft.world.biome.layer.NoiseToRiverLayer;
import net.minecraft.world.biome.layer.ScaleLayer;
import net.minecraft.world.biome.layer.SimpleLandNoiseLayer;
import net.minecraft.world.biome.layer.SmoothenShorelineLayer;
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

        biomes = SmoothenShorelineLayer.INSTANCE.create(contextProvider.apply(101L), biomes);

        // River
        LayerFactory<R> rivers = SimpleLandNoiseLayer.INSTANCE.create(contextProvider.apply(200L), biomeInit);

        rivers = ScaleLayer.NORMAL.create(contextProvider.apply(1000L), rivers);
        rivers = ScaleLayer.NORMAL.create(contextProvider.apply(1001L), rivers);
        for (int i = 0; i < biomeSize - 1; ++i) {
            rivers = ScaleLayer.NORMAL.create(contextProvider.apply(1000L + (long) i), rivers);
        }

        // Noise to river
        rivers = NoiseToRiverLayer.INSTANCE.create(contextProvider.apply(201L), rivers);
        rivers = ScaleLayer.NORMAL.create(contextProvider.apply(1001L), rivers);

        // Mix rivers with biomes
        biomes = AddRiversLayer.INSTANCE.create(contextProvider.apply(102L), biomes, rivers);

        return biomes;
    }

    public static BiomeLayerSampler build(long seed) {
        return new BiomeLayerSampler(create((salt) -> new CachingLayerContext(25, seed, salt)));
    }
}
