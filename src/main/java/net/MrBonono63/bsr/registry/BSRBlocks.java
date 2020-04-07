package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.block.*;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.MrBonono63.bsr.BSR;

import java.util.function.Function;

public class BSRBlocks {
    /*
    * MISC
    * */
    public static final Block PORTAL_BLOCK = register("portal_block", new CreativePortalBlock(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));

    /*
    * ASTEROID Materials
    * */

    //C-type Asteroid blocks
    public static final Block CARBONATE_ROCK = register("carbonate_rock", new Block(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_IRON_ORE = register("asteroid_iron_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_GOLD_RE = register("asteroid_gold_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.GOLD_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_DIAMOND_ORE = register("asteroid_diamond_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_LEAD_ORE = register("asteroid_lead_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.GOLD_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_TITANIUM_ORE = register("asteroid_titanium_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.GOLD_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_IRIDIUM_ORE = register("asteroid_iridium_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE).materialColor(MaterialColor.GRAY).build()));

    //S-type Asteroid blocks
    public static final Block SILICATE_ROCK = register("silicate_rock", new Block(FabricBlockSettings.copy(Blocks.STONE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_REDSTONE_ORE = register("asteroid_redstone_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.REDSTONE_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_ALUMINUM_ORE = register("asteroid_aluminum_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.COAL_BLOCK).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_OSMIUM_ORE = register("asteroid_osmium_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE).materialColor(MaterialColor.GRAY).build()));
    public static final Block ASTEROID_ZINC_ORE = register("asteroid_zinc_ore", new AsteroidOreBlock(FabricBlockSettings.copy(Blocks.IRON_ORE).materialColor(MaterialColor.GRAY).build()));

    /*
    * Fluid Blocks
    * */
    public static final Block OXYGEN_BLOCK = register("oxygen", new OxygenBlock(BSRFluids.OXYGEN, FabricBlockSettings.copy(Blocks.WATER).build()));

    /*
    * DECORATION Blocks
    * TODO add connected textures
    * */

    public static final Block REINFORCED_SHUTTLE_HULL = register("reinforced_shuttle_hull", new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).resistance(800f).hardness(0.6f).build()));
    public static final Block REINFORCED_SHUTTLE_HULL_STAIRS = register("reinforced_shuttle_hull_stairs", new BSRStairsBlock(BSRBlocks.REINFORCED_SHUTTLE_HULL.getDefaultState(), FabricBlockSettings.copy(REINFORCED_SHUTTLE_HULL).resistance(800f).hardness(0.6f).build()));
    public static final Block REINFORCED_SHUTTLE_HULL_SLAB = register("reinforced_shuttle_hull_slab", new BSRSlabBlock(FabricBlockSettings.copy(REINFORCED_SHUTTLE_HULL).resistance(800f).hardness(0.6f).build()));
    public static final Block REINFORCED_GLASS = register("reinforced_glass", new GlassBlock(FabricBlockSettings.copy(REINFORCED_SHUTTLE_HULL).hardness(0.6f).resistance(800f).nonOpaque().build()));
    public static final Block REINFORCED_GLASS_PANE = register("reinforced_glass_pane", new BSRPaneBlock(FabricBlockSettings.copy(REINFORCED_GLASS).build()));

    /*
    * Shuttle Components
    * */
    public static final Block CONTROL_CENTER = register("control_center", new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).build()));
    public static final Block DROID_MAKER = register("droid_maker", new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).build()));
    public static final Block SPACE_TOILET = register("space_toilet", new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).build()));

    private BSRBlocks() {
        // NO-OP?
    }

    public static final Block REINFORCED_SCAFFOLD = new ReinforcedScaffold(FabricBlockSettings.of(Material.METAL).build());

    public static void init() {
        Registry.register(Registry.BLOCK, BSR.id("reinforced_scaffolding"), REINFORCED_SCAFFOLD);
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
