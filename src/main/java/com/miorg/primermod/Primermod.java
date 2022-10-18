package com.miorg.primermod;

import com.miorg.primermod.events.MisHechizos;
import com.miorg.primermod.events.MobsAttrsEvents;
import com.miorg.primermod.events.MobsRendererEvents;
import com.miorg.primermod.init.InitBlocks;
import com.miorg.primermod.init.InitColocarFeature;
import com.miorg.primermod.init.InitConfigureFeature;
import com.miorg.primermod.init.InitItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.miorg.primermod.init.InitMods.MOBS;
import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod(Primermod.MODID)
public class Primermod {
    public static final String MODID = "primermod";

    public Primermod(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        InitItems.ITEMS.register(bus); // Registramos los nuevos items
        InitBlocks.BLOCKS.register(bus); // Registramos los nuevos bloques

        EVENT_BUS.register(new MisHechizos());
        EVENT_BUS.register(new MobsAttrsEvents());
        EVENT_BUS.register(new MobsRendererEvents());
        MOBS.register(bus);

        InitConfigureFeature.CONFIGURED_FEATURES.register(bus);
        InitColocarFeature.PLACED_FEATURE.register(bus);
     }
}
