package com.miorg.primermod.events;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.client.models.MonsterModel;
import com.miorg.primermod.client.renderer.MonsterRenderer;
import com.miorg.primermod.init.InitMods;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Primermod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MobsRendererEvents {

    @SubscribeEvent
    public static void entityRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(InitMods.MONSTER.get(), MonsterRenderer::new);
        //event.registerEntityRenderer(InitMods.PRUEBA.get(), PruebaRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(MonsterModel.LAYER_LOCATION, MonsterModel::createBodyLayer);
    }
}
