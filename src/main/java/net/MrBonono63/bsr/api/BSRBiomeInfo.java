package net.MrBonono63.bsr.api;

import net.minecraft.util.math.Vec3d;

public interface BSRBiomeInfo {
    Vec3d getFogColor();

    float getFogIntensity();

    boolean shouldFogRender();
}
