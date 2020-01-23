package net.MrBonono63.bsr.world.dimension;

import com.github.draylar.worldtraveler.api.dimension.utils.FogColorCalculator;
import net.minecraft.util.math.Vec3d;

public class BSRFogColorCalculator implements FogColorCalculator {
    @Override
    public Vec3d calculate(float v, float v1) {
        return new Vec3d(255,255,255);
    }
}
