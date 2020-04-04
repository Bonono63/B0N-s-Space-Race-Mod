package net.MrBonono63.bsr.world.dimension;

import net.MrBonono63.bsr.registry.BSRBlocks;
import net.fabricmc.fabric.api.dimension.v1.EntityPlacer;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpawnPlacementHandler {

    public static final EntityPlacer ENTERING = (teleported, destination, portalDir, horizontalOffset, verticalOffset) ->{
        BlockPos pos = enterOverworldOrbit(teleported, (ServerWorld) teleported.getEntityWorld(), destination);
        return new BlockPattern.TeleportTarget(new Vec3d(pos), Vec3d.ZERO, 0);
    };

    public static final EntityPlacer LEAVING = (teleported, destination, portalDir, horizontalOffset, verticalOffset) -> {
        BlockPos pos = leaveOverworldOrbit(teleported, (ServerWorld) teleported.getEntityWorld(), destination);
        return new BlockPattern.TeleportTarget(new Vec3d(pos), Vec3d.ZERO, 0);
    };

    private static BlockPos enterOverworldOrbit(Entity entity, ServerWorld previousWorld, ServerWorld newWorld) {
        BlockPos spawnPos = new BlockPos(0,100,0);
        spawnPlatform(newWorld, spawnPos.down());
        entity.refreshPositionAndAngles(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), 0 , 0 );

        return spawnPos;
    }

    private static BlockPos leaveOverworldOrbit(Entity entity, ServerWorld previousWorld, ServerWorld newWorld) {

        return new BlockPos(0, 100,0);
    }

    private static void spawnPlatform(World world, BlockPos pos) {
        if(world.getBlockState(pos).getBlock() != BSRBlocks.PORTAL_BLOCK) {
            BlockState platformBlock = randomTerracotta();
            for (int x = -3; x < 4; x++) {
                for (int z = -3; z < 4; z++) {
                    if(world.isAir(pos.add(x, 0, z))) {
                        world.setBlockState(pos.add(x,0,z), platformBlock);
                    }
                }
            }
            world.setBlockState(pos, BSRBlocks.PORTAL_BLOCK.getDefaultState());
            for (Direction facing : Direction.values()) {
                if (facing.getAxis().isHorizontal()) {
                    world.setBlockState(pos.up().offset(facing), Blocks.TORCH.getDefaultState());
                }
            }
        }
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
