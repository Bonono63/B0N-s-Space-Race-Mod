package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.item.BSRReinforcedScaffoldItem;
import net.MrBonono63.bsr.item.JetpackItem;
import net.MrBonono63.bsr.item.armor.CustomArmorMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.MrBonono63.bsr.BSR;

public class BSRItems {
    /*
    * Crafting Items
    * */
    public static final Item IRON_PIPE = register("iron_pipe", new Item(newSettings()));
    public static final Item BASIC_CIRCUIT = register("basic_pcb", new Item(newSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ADVANCED_CIRCUIT = register("advanced_pcb", new Item(newSettings().rarity(Rarity.RARE)));
    public static final Item COOLING_SYSTEM = register("cooling_system", new Item(newSettings().rarity(Rarity.UNCOMMON)));
    public static final Item HEATING_SYSTEM = register("heating_system", new Item(newSettings().rarity(Rarity.UNCOMMON)));
    public static final Item OXYGEN_SYSTEM = register("oxygen_system", new Item(newSettings().rarity(Rarity.UNCOMMON)));
    public static final Item BASIC_BATTERY = register("basic_battery", new Item(newSettings().rarity(Rarity.COMMON)));
    public static final Item TIN_CELL_CASING = register("tin_cell_casing", new Item(newSettings()));
    public static final Item ELECTRICAL_SYSTEM = register("electrical_system", new Item(newSettings().rarity(Rarity.UNCOMMON)));
    public static final Item HOLOGRAPHIC_PROJECTOR = register("holographic_projector", new Item(newSettings().rarity(Rarity.UNCOMMON)));

    //JETPACKS
    public static final Item BASIC_JETPACK = register("basic_jetpack", new JetpackItem(newSettings().rarity(Rarity.RARE)));

    //ARMOR ITEMS
    public static final Item BASIC_ASTRONAUT_HELMET = register("basic_astronaut_helmet", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.HEAD, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_CHESTPLATE = register("basic_astronaut_chestplate", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.CHEST, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_LEGGINGS = register("basic_astronaut_leggings", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.LEGS, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));
    public static final Item BASIC_ASTRONAUT_BOOTS = register("basic_astronaut_boots", new ArmorItem(CustomArmorMaterials.BASIC_ASTRONAUT, EquipmentSlot.FEET, (newSettings().group(BSR.GROUP).rarity(Rarity.RARE).maxCount(1))));

    /*
    * Bucket Items
    * */
    public static final Item OXYGEN_CANISTER = register("oxygen_canister", new BucketItem(BSRFluids.OXYGEN, newSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    private BSRItems() {
        //NO-OP
    }

    public static void init() {
        Registry.register(Registry.ITEM, BSR.id("reinforced_scaffold"), new BSRReinforcedScaffoldItem(BSRBlocks.REINFORCED_SCAFFOLD, newSettings().group(BSR.GROUP)));
    }

    static Item.Settings newSettings() {
        return new Item.Settings().group(BSR.GROUP);
    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, BSR.id(name), item);
    }
}
