package com.miorg.primermod.item;

import com.miorg.primermod.utils.Summon;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MonsterEgg extends EggItem {
    public MonsterEgg(Properties p_41126_) {
        super(p_41126_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interact) {
        var result = super.use(level, player, interact);
        Summon.summonEntity("primermod:monster", player);
        return result;
    }
}
