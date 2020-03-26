package net.MrBonono63.bsr;

import net.MrBonono63.bsr.registry.BSRBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BSRClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BSRBlocks.REINFORCED_SCAFFOLDING, RenderLayer.getTranslucent());
    }
}
