package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.item.JetpackItem;
import net.MrBonono63.bsr.item.armor.CustomArmorMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.MrBonono63.bsr.BSR;

public class BSRItems {
    //JETPACKS
    public static final Item BASIC_JETPACK = register("basic_jetpack", new JetpackItem(newSettings().rarity(Rarity.RARE)));

    //ARMOR ITEMS
    public static final Item BASIC_ASTRONAUT_HELMET = register("basic_astronaut_helmet", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.HEAD, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_CHESTPLATE = register("basic_astronaut_chestplate", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.CHEST, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_LEGGINGS = register("basic_astronaut_leggings", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.LEGS, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_BOOTS = register("basic_astronaut_boots", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.FEET, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));

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
