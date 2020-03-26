package net.MrBonono63.bsr.item;

/*import dev.emi.trinkets.api.ITrinket;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;*/
import net.MrBonono63.bsr.BSR;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class JetpackItem extends Item {


    public JetpackItem(Settings settings) {
        super(new Settings().group(BSR.GROUP).maxCount(1));
        //DispenserBlock.registerBehavior(this, TRINKET_DISPENSER_BEHAVIOR);
    }

    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        //Overriding the use method to equip the trinket when it's used
        return ITrinket.equipTrinket(player, hand);
    }*/

    /*@Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.CHEST) && slot.equals(Slots.BACKPACK);
    }*/
}
