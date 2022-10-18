package com.miorg.primermod.init;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.entities.MonsterEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitMods {

    public static final DeferredRegister<EntityType<?>> MOBS = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Primermod.MODID);

    public static final RegistryObject<EntityType<MonsterEntity>> MONSTER = MOBS.register("monster", () -> EntityType.Builder.of(MonsterEntity::new, MobCategory.CREATURE).build(Primermod.MODID + ":monster"));
   // public static final RegistryObject<EntityType<PruebaEntity>> PRUEBA = MOBS.register("prueba", () -> EntityType.Builder.of(PruebaEntity::new, MobCategory.CREATURE).build(Primermod.MODID + ":prueba"));
}
