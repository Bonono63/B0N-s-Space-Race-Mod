package net.MrBonono63.bsr;

import net.MrBonono63.bsr.registry.BSRBlocks;
import net.MrBonono63.bsr.registry.BSRFluids;
import net.MrBonono63.bsr.registry.BSRItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSR implements ModInitializer {

    public static final String MOD_ID = "bsr";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.ITEM_FRAME));

    public static FabricDimensionType SPACE_001;

    public static BlockPortal PORTAL_BLOCK;

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static ChunkGeneratorType<ChunkGeneratorConfig, VoidChunkGenerator> VOID_CHUNK_GENERATOR;

    @Override
    public void onInitialize() {
        initWorlds();
        initBlocks();
        BSRBlocks.init();
        BSRItems.init();
        BSRFluids.init();

        BSR.VOID_CHUNK_GENERATOR = FabricChunkGeneratorType.register(new Identifier("simplevoidworld", "simplevoidworld"), VoidChunkGenerator::new, ChunkGeneratorConfig::new, false);
    }

    public static void initWorlds() {
        SPACE_001 = FabricDimensionType.builder()
                .factory(Space_001Dim::new)
                .skyLight(true)
                .defaultPlacer(Space_001PlacementHandler.ENTERING)
                .buildAndRegister(new Identifier(MOD_ID, "space_001"));
    }

    public void initBlocks() {
        PORTAL_BLOCK = new BlockPortal();
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "block_portal"), PORTAL_BLOCK);

        BlockItem blockItem = new BlockItem(PORTAL_BLOCK, new Item.Settings().group(GROUP));
        blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "block_portal"), blockItem);
    }

    public static BlockState randomTerracotta() {
        Random random = new Random();

        List<BlockState> terracottaBlocks = new ArrayList<>();
        Registry.BLOCK.forEach(block -> {
            if (Registry.BLOCK.getId(block).getPath().endsWith("_terracotta") && !Registry.BLOCK.getId(block).getPath().endsWith("_glazed_terracotta")) {
                terracottaBlocks.add(block.getDefaultState());
            }
        });

        return terracottaBlocks.get(random.nextInt(terracottaBlocks.size()));
    }
}