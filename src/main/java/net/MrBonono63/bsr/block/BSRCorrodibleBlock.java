package net.MrBonono63.bsr.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.StateManager.Builder;

public class BSRCorrodibleBlock extends Block {
    private static final IntProperty CORRODED = null;

    public BSRCorrodibleBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.stateManager.getDefaultState().with(CORRODED, 0));
    }

    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(CORRODED);
    }
}
