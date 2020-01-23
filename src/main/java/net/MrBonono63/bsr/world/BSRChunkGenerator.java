package net.MrBonono63.bsr.world;

import net.minecraft.world.ChunkRegion;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class BSRChunkGenerator extends ChunkGenerator<BSRChunkGeneratorConfig> {
    public BSRChunkGenerator(IWorld world, BiomeSource biomeSource, BSRChunkGeneratorConfig config) {
        super(world, biomeSource, config);
    }

    @Override
    public void buildSurface(ChunkRegion chunkRegion, Chunk chunk) {

    }

    @Override
    public int getSpawnHeight() {
        return 0;
    }

    @Override
    public void populateNoise(IWorld world, Chunk chunk) {

    }

    @Override
    public int getHeightOnGround(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }
}
