package net.MrBonono63.bsr.world.dimension;

import com.github.draylar.worldtraveler.api.dimension.utils.BackgroundColorCalculator;

public class BSRBackgroundColorCalculator implements BackgroundColorCalculator {

    private static final float[]COLOR = { 255, 255, 255, 10};

    @Override
    public float[] calculate(float x, float y) {
        return COLOR;
    }
}
