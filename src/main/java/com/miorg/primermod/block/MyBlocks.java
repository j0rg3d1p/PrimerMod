
package com.miorg.primermod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.ToIntFunction;


public class MyBlocks {
    public static final Block MITHRIL_BLOCK = register("mithril_block", new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(10.0F, 10.0F).sound(SoundType.METAL)));
    public static final Block SPEEDY_BLOCK = register("speedy_block", new Block(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_GRAY).sound(SoundType.GLASS)));

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return (boolean)false;
    }

    private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return (boolean)true;
    }




    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }


    private static Block register(String p_50796_, Block p_50797_) {
        return Registry.register(Registry.BLOCK, p_50796_, p_50797_);
    }

    public static void rebuildCache() {
        Block.BLOCK_STATE_REGISTRY.forEach(BlockBehaviour.BlockStateBase::initCache);
    }
   
}