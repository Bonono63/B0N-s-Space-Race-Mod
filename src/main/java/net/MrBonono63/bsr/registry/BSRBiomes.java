package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.world.biome.BSRBaseBiome;
import net.MrBonono63.bsr.world.biome.BSRDomumBiome;
import net.MrBonono63.bsr.world.biome.BSRIgnisBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.MrBonono63.bsr.BSR;

public class BSRBiomes {

    public static final BSRBaseBiome DOMUM_BIOME = register("domum_biome", new BSRDomumBiome(0.75f,0.8f));
    public static final BSRBaseBiome IGNIS_BIOME = register("ignis_biome", new BSRIgnisBiome(0.75f,0.8f));

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
