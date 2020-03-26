package net.MrBonono63.bsr;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BSRClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(BSR.REINFORCED_SCAFFOLDING, RenderLayer.getTranslucent());
    }
}
