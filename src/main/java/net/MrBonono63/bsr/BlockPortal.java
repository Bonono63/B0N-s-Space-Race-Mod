package net.MrBonono63.bsr;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class BlockPortal extends Block {

    public BlockPortal() {
        super(Settings.of(Material.AIR));
    }

    @Override
    public ActionResult onUse(BlockState stateBlock, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!world.isClient) {
            if (playerEntity.dimension == BSR.OVERWORLD_ORBIT) {
                FabricDimensions.teleport(playerEntity, DimensionType.OVERWORLD, OverworldObitPlacementHandler.LEAVING);
            } else {
                playerEntity.changeDimension(BSR.OVERWORLD_ORBIT);
            }
        }
        return ActionResult.SUCCESS;
    }
}
