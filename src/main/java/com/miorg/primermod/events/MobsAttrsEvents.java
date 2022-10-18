package com.miorg.primermod.events;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.entities.MonsterEntity;
import com.miorg.primermod.init.InitMods;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Primermod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobsAttrsEvents {

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(InitMods.MONSTER.get(), MonsterEntity.getMonsterEntityAttrs().build());
    }
}
