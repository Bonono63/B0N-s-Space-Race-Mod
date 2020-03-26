package net.MrBonono63.bsr.biomes;

import net.minecraft.world.biome.Biome;

public class Asteroid001 extends Biome {

    public Asteroid001 () {
        super(new Settings().configureSurfaceBuilder(null, null).precipitation(Precipitation.NONE).category(Category.PLAINS).depth(0.24F).scale(0.5F).temperature(0.0F).downfall(0.0F).parent((String)null));
    }

}
