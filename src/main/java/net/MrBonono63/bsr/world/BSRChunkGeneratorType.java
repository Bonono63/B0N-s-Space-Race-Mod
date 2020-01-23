package net.MrBonono63.bsr.world;

import net.MrBonono63.bsr.BSR;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

import java.util.function.Supplier;

public class BSRChunkGeneratorType extends ChunkGeneratorType<BSRChunkGeneratorConfig, BSRChunkGenerator> {

    public static final BSRChunkGeneratorType INSTANCE = Registry.register(Registry.CHUNK_GENERATOR_TYPE, BSR.id("spooky"), new BSRChunkGeneratorType(false, () -> new BSRChunkGeneratorConfig()));

    public BSRChunkGeneratorType(boolean buffetScreen, Supplier<BSRChunkGeneratorConfig> configSupplier) {
        super(null, buffetScreen, configSupplier);
    }

    public static void init() {
        // NO-OP
    }

    @Override
    public BSRChunkGenerator create(World world, BiomeSource biomeSource, BSRChunkGeneratorConfig config) {
        return new BSRChunkGenerator(world, biomeSource, config);
    }
}