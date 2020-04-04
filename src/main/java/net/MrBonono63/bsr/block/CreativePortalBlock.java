package net.MrBonono63.bsr.block;

import net.MrBonono63.bsr.registry.BSRDimensions;
import net.MrBonono63.bsr.world.dimension.SpawnPlacementHandler;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class CreativePortalBlock extends Block {

    public CreativePortalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState stateBlock, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!world.isClient) {
            if (playerEntity.dimension == BSRDimensions.OVERWORLD_ORBIT) {
                FabricDimensions.teleport(playerEntity, DimensionType.OVERWORLD, SpawnPlacementHandler.LEAVING);
            } else {
                playerEntity.changeDimension(BSRDimensions.OVERWORLD_ORBIT);
            }
        }
        return ActionResult.SUCCESS;
    }
}
