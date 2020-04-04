package net.MrBonono63.bsr;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import net.MrBonono63.bsr.registry.*;
import net.MrBonono63.bsr.world.dimension.FabricChunkGeneratorType;
import net.MrBonono63.bsr.world.dimension.OverworldOrbitChunkGenerator;
import net.MrBonono63.bsr.world.dimension.SpawnPlacementHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensionType;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSR implements ModInitializer {

    public static final String MOD_ID = "bsr";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.BLAZE_ROD));

    public static ChunkGeneratorType<ChunkGeneratorConfig, OverworldOrbitChunkGenerator> OVERWORLD_CHUNK_GENERATOR;

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        BSRBiomes.init();
        BSRDimensions.init();
        BSRBlocks.init();
        BSRItems.init();
        BSRFluids.init();

        BSR.OVERWORLD_CHUNK_GENERATOR = FabricChunkGeneratorType.register(new Identifier("bsr", "overworld_orbit"), OverworldOrbitChunkGenerator::new, ChunkGeneratorConfig::new, false);
    }
}