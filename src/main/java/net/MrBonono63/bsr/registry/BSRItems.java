package net.MrBonono63.bsr.registry;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.MrBonono63.bsr.BSR;

public class BSRItems {

    private BSRItems() {
        //NO-OP
    }

    public static void init() {

    }

    static Item.Settings newSettings() {
        return new Item.Settings().group(BSR.GROUP);
    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, BSR.id(name), item);
    }
}
