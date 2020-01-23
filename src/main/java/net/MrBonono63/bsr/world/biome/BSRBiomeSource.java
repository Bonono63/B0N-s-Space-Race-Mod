package net.MrBonono63.bsr.world.biome;

import com.google.common.collect.ImmutableSet;
import net.MrBonono63.bsr.registry.BSRBiomes;
import net.MrBonono63.bsr.world.layer.BSRBiomeLayers;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

public class BSRBiomeSource extends BiomeSource {
    public final BiomeLayerSampler biomeSampler;

    public BSRBiomeSource(long seed) {
        super(ImmutableSet.of(
                BSRBiomes.DOMUM_BIOME,
                BSRBiomes.IGNIS_BIOME
        ));
        biomeSampler = BSRBiomeLayers.build(seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) { // these represent sub chunk values, not xyz
        return biomeSampler.sample(biomeX, biomeZ);
    }
}
