package net.MrBonono63.bsr.world.layer;

import net.MrBonono63.bsr.world.BSRBiomeGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.type.IdentitySamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum AddBiomesLayer implements IdentitySamplingLayer {
    INSTANCE;

    @Override
    public int sample(LayerRandomnessSource rand, int groupId) {
        BSRBiomeGroup group = BSRBiomeGroup.getById(groupId);

        return Registry.BIOME.getRawId(group.pickBiome(rand));
    }
}
