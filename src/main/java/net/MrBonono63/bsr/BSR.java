package net.MrBonono63.bsr;

import net.MrBonono63.bsr.registry.BSRBiomes;
import net.MrBonono63.bsr.registry.BSRBlocks;
import net.MrBonono63.bsr.registry.BSRDimensions;
import net.MrBonono63.bsr.registry.BSRItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BSR implements ModInitializer {

    public static String MOD_ID = "bsr";
    public static final Logger LOGGER = LogManager.getLogger("B0N's Space Race");
    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("bsr_items"), () -> new ItemStack(Items.ITEM_FRAME));

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {

        //init registry classes
        BSRItems.init();
        BSRBlocks.init();
        BSRConfig.sync();
        BSRDimensions.init();
        BSRBiomes.init();

        //print
        System.out.println("Shits registered");
    }
}