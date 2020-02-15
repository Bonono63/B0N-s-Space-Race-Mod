package net.MrBonono63.bsr;

import net.MrBonono63.bsr.registry.BSRBlocks;
import net.MrBonono63.bsr.registry.BSRFluids;
import net.MrBonono63.bsr.registry.BSRItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.BlockState;
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

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.BLAZE_ROD));

    public static FabricDimensionType OVERWORLD_ORBIT;

    public static BlockPortal PORTAL_BLOCK;

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    public static ChunkGeneratorType<ChunkGeneratorConfig, OverworldChunkGenerator> OVERWORLD_ORBIT_CHUNK_GENERATOR;

    @Override
    public void onInitialize() {
        initWorlds();
        initBlocks();
        BSRBlocks.init();
        BSRItems.init();
        BSRFluids.init();

        BSR.OVERWORLD_ORBIT_CHUNK_GENERATOR = FabricChunkGeneratorType.register(new Identifier("bsr", "overworldorbit"), OverworldChunkGenerator::new, ChunkGeneratorConfig::new, false);
    }

    public static void initWorlds() {
        OVERWORLD_ORBIT = FabricDimensionType.builder()
                .factory(OverworldOrbitDim::new)
                .skyLight(true)
                .defaultPlacer(OverworldObitPlacementHandler.ENTERING)
                .buildAndRegister(new Identifier(MOD_ID, "overworld_orbit"));
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