package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.BSR;
import net.MrBonono63.bsr.world.dimension.SpawnPlacementHandler;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;

public class BSRDimensions {

    public static FabricDimensionType OVERWORLD_ORBIT;

    private BSRDimensions() {
    }

    public static void init() {
        OVERWORLD_ORBIT = FabricDimensionType.builder()
                .factory(OverworldOrbitDimension::new)
                .skyLight(true)
                .defaultPlacer(SpawnPlacementHandler.ENTERING)
                .buildAndRegister(BSR.id("overworld_orbit"));
    }
}
