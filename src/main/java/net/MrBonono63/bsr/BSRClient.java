package net.MrBonono63.bsr;

import net.MrBonono63.bsr.registry.BSRBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BSRClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), BSRBlocks.REINFORCED_GLASS /*BSRBlocks.REINFORCED_SCAFFOLDING*/);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BSRBlocks.REINFORCED_GLASS /*BSRBlocks.REINFORCED_SCAFFOLDING*/);
    }
}
