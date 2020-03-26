package net.MrBonono63.bsr;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import net.MrBonono63.bsr.block.Reinforced_Scaffolding;
import net.MrBonono63.bsr.registry.BSRBiomes;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSR implements ModInitializer {

    public static final String MOD_ID = "bsr";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.BLAZE_ROD));


    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        BSRBlocks.init();
        BSRItems.init();
        BSRFluids.init();
        BSRBiomes.init();
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