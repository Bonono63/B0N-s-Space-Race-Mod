package net.MrBonono63.bsr;

import net.MrBonono63.bsr.client.FluidResourceLoader;
import net.MrBonono63.bsr.registry.BSRBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.resource.ResourceType;

public class BSRClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), BSRBlocks.REINFORCED_GLASS, BSRBlocks.OXYGEN_BLOCK);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BSRBlocks.REINFORCED_GLASS, BSRBlocks.REINFORCED_SCAFFOLD);

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new FluidResourceLoader());
    }
}
