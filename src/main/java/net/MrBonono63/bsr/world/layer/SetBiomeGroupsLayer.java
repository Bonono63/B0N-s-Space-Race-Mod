package net.MrBonono63.bsr.world.layer;

import net.MrBonono63.bsr.world.BSRBiomeGroup;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum SetBiomeGroupsLayer implements InitLayer {
    INSTANCE;

    @Override
    public int sample(LayerRandomnessSource rand, int x, int z) {
        // 0, 0 tile is always DEFAULT (0)
        return (x == 0 && z == 0) ? 0 : BSRBiomeGroup.pickRandomBiomeGroup();
    }
}
