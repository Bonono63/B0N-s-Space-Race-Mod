package net.MrBonono63.bsr;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.client.MinecraftClient;

public class Space_001Dim extends Dimension {

    final int cycleStart = 12567;
    final float cycleStartDayFraction = cycleStart / 24000f;
    final int cycleEnd = 22900;
    final float cycleEndDayFraction = cycleEnd / 24000f;
    final float cycleLength = cycleEnd - cycleStart;

    protected float repeatThisVee(long ticks) {
        return Math.abs(ticks / 24000f - cycleStartDayFraction) + cycleStartDayFraction;
    }

    protected float zigzagDayFunction(long ticks) {
        return repeatThisVee((long) ((ticks - cycleLength - cycleStart) % (2 * cycleLength)));
    }

    protected float waveDayFunction(long ticks) {
        return (
                (float) Math.sin(
                        ((double) (
                                (2 * ticks - cycleStart - cycleEnd) / (2 * cycleLength)
                        )) * Math.PI
                )
        ) / ((2f * 24000f) / cycleLength) + (cycleStart + cycleEnd) / (2f * 24000f);
    }

    public Space_001Dim(World world, DimensionType type) {
        super(world, type, 0.0F);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return BSR.VOID_CHUNK_GENERATOR.create(world,
                BiomeSourceType.FIXED.applyConfig(BiomeSourceType.FIXED.getConfig(world.getLevelProperties())
                        .setBiome(Biomes.PLAINS)),
                BSR.VOID_CHUNK_GENERATOR.createSettings());
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean b) {
        return null;
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int i, int i1, boolean b) {
        return null;
    }

    @Override
    public float getSkyAngle(long l, float v) {
        long ticks = 0;
        return (2f * zigzagDayFunction(ticks) + waveDayFunction(ticks)) / 3f;
    }

    @Override
    public boolean hasVisibleSky() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float v, float v1){
        double totalR = 0;
        double totalG = 0;
        double totalB = 0;
        int count = 0;
        int radius = 8;
        PlayerEntity player = MinecraftClient.getInstance().player;

        for (int x = 0; x < radius; x++) {
            for (int z = 0; z < radius; z++) {
                BlockPos pos = player.getBlockPos().add(x - (radius / 2), 0, z - (radius / 2));

                count++;
            }
        }
        return new Vec3d(Math.sqrt(totalR / count), Math.sqrt(totalG / count), Math.sqrt(totalB / count));
    }

    @Override
    public boolean canPlayersSleep() { return true; }

    @Override
    public boolean isFogThick(int x, int z) { return true; }

    @Override
    public DimensionType getType() { return BSR.SPACE_001; }

    @Override
    public BlockPos getForcedSpawnPoint() {
        return new BlockPos(0, 100, 0);
    }
}