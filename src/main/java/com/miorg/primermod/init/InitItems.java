package com.miorg.primermod.init;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.armor.MyArmorMaterials;
import com.miorg.primermod.item.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    // Registramos lo que acabamos de crear

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Primermod.MODID);

    public static final RegistryObject<Item> MONSTEREGG = ITEMS.register("monster_egg", () -> new MonsterEgg(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));

    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Item> VARA = ITEMS.register("vara", () -> new Vara(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VARA_HIELO = ITEMS.register("vara_hielo", () -> new Vara(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VARA_LAVA = ITEMS.register("vara_lava", () -> new Vara(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VARA_MOV = ITEMS.register("vara_mov", () -> new Vara(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VARA_FUERZA = ITEMS.register("vara_fuerza", () -> new SwordItem(Tiers.WOOD, 4, 12.5f, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> VARA_MARINA = ITEMS.register("vara_marina", () -> new Vara(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    // ARMAS

    public static final RegistryObject<Item> DAGA = ITEMS.register("daga", () -> new Daga());

    public static final RegistryObject<Item> LEMBAS = ITEMS.register("lembas", () -> new EnchantedGoldenAppleItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(20).saturationMod(5.5f).fast().build())));

    public static final RegistryObject<Item> ARCO = ITEMS.register("arco", () -> new MyBowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(1000)));

    public static final RegistryObject<Item> AIGLOS = ITEMS.register("aiglos", () -> new Aiglos());



    // ARMADURA

    public static final RegistryObject<Item> MITHRIL_CHEST = ITEMS.register("mithril", () -> new ArmorItem(MyArmorMaterials.MITHRIL,EquipmentSlot.CHEST,new Item.Properties().durability(1000).fireResistant().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> MITHRIL_BOOTS = ITEMS.register("mercurial", () -> new ArmorItem(MyArmorMaterials.MITHRIL, EquipmentSlot.FEET,new Item.Properties().fireResistant().durability(100).tab(CreativeModeTab.TAB_COMBAT)));

    // POR CREAR: ESCUDO


}
