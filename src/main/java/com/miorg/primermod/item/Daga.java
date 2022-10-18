package com.miorg.primermod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;


public class Daga extends SwordItem {
    public Daga(){

        super(Tiers.NETHERITE, 7,5.5f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }


    public boolean hitEntity(LivingEntity target){
        target.setSecondsOnFire(10);
        return true;
    }
}
