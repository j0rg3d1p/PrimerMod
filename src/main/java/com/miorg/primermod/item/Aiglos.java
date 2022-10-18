package com.miorg.primermod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class Aiglos extends MyTrident {
    public Aiglos(){

        super(new Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant().durability(10000));
    }
}
