package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.BSR;
import net.MrBonono63.bsr.fluid.OxygenFluid;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

public class BSRFluids {

    public static final BaseFluid OXYGEN = register("oxygen", new OxygenFluid.Still());
    public static final BaseFluid FLOWING_OXYGEN = register("oxygen_flowing", new OxygenFluid.Flowing());

    private BSRFluids() {
    }

    public static void init() {
        //NO-OP
    }

    static <T extends Fluid> T register(String name, T fluid) {
        T b = Registry.register(Registry.FLUID, BSR.id(name), fluid);
        return b;
    }
}
