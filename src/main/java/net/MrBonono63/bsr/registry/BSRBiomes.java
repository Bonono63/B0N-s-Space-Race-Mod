package net.MrBonono63.bsr.registry;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.MrBonono63.bsr.BSR;

public class BSRBiomes {


    private BSRBiomes() {
        // NO-OP
    }

    public static void init() {
        // Make default river the hallowed river in each biome
        //HallowedBaseBiome.BIOMES.forEach(biome -> OverworldBiomes.setRiverBiome(biome, HALLOWED_RIVER));
    }

    private static <T extends Biome> T register(String name, T biome) {
        return Registry.register(Registry.BIOME, BSR.id(name), biome);
    }
}
