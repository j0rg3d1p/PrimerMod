package com.miorg.primermod.init;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.block.MyBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class InitBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Primermod.MODID);

    public static final RegistryObject<Block> MITHRIL_BLOCK = register("mithril_block", () -> new Block(BlockBehaviour.Properties.of((Material.STONE)).friction(0.2f).strength(4f).requiresCorrectToolForDrops()), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    public static final RegistryObject<Block> SPEEDY_BLOCK = register("speedy_block", () -> new Block(BlockBehaviour.Properties.of((Material.GLASS)).friction(0.15f)), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    // CREAR BLOQUE DE HIPER VELOCIDAD (friction)
    public static <T extends Block>RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        InitItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));

        return block;
    }
}
