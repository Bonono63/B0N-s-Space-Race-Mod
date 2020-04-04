package net.MrBonono63.bsr.registry;

import net.MrBonono63.bsr.BSR;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class OverworldOrbitDimension extends Dimension {

    public OverworldOrbitDimension(World world, DimensionType type) {
        super(world, type, 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return BSR.OVERWORLD_CHUNK_GENERATOR.create(world,
                BiomeSourceType.FIXED.applyConfig(BiomeSourceType.FIXED.getConfig(world.getLevelProperties())),
                BSR.OVERWORLD_CHUNK_GENERATOR.createSettings());
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean checkMobSpawnValidity) {
        return null;
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int x, int z, boolean checkMobSpawnValidity) {
        return null;
    }

    @Override
    public float getSkyAngle(long timeOfDay, float tickDelta) {
        return 0;
    }

    @Override
    public boolean hasVisibleSky() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float skyAngle, float tickDelta) {
        return new Vec3d(0,0,0);
    }

    @Override
    public boolean canPlayersSleep() {
        return true;
    }

    @Override
    public boolean isFogThick(int x, int z) {
        return false;
    }

    @Override
    public DimensionType getType() {
        return BSRDimensions.OVERWORLD_ORBIT;
    }

    @Override
    public BlockPos getForcedSpawnPoint() {
        return new BlockPos(0,100,0);
    }

    @Override
    public boolean hasGround() {
        return false;
    }

    @Override
    public boolean isNether() {
        return false;
    }
}
