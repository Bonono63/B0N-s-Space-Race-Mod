package net.MrBonono63.bsr.registry;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.MrBonono63.bsr.BSR;

import java.util.function.Function;

public class BSRBlocks {

    //public static final Block DECEASED_DIRT = register("deceased_dirt", new Block(FabricBlockSettings.copy(Blocks.DIRT).materialColor(MaterialColor.PURPLE).build()));

    public static final Block ASTEROID_IRON = register("asteroid_iron", new Block(FabricBlockSettings.copy(Blocks.IRON_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_DIAMOND = register("asteroid_diamond", new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_GOLD = register("asteroid_gold", new Block(FabricBlockSettings.copy(Blocks.GOLD_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block FERRITE_ROCK = register("ferrite_rock", new Block(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));
    public static final Block SILICATE_ROCK = register("silicate_rock", new Block(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));
    public static final Block CARBONATE_ROCK = register("carbonate_rock", new Block(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));

    private BSRBlocks() {
        // NO-OP?
    }

    public static void init() {
    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
        return register(name, block, new BlockItem(block, settings));
    }

    static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings().group(BSR.GROUP));
    }

    static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
        return register(name, block, itemFactory.apply(block));
    }

    static <T extends Block> T register(String name, T block, BlockItem item) {
        T b = Registry.register(Registry.BLOCK, BSR.id(name), block);
        if (item != null) {
            BSRItems.register(name, item);
        }
        return b;
    }
}
