package com.miorg.primermod.item;

import com.miorg.primermod.block.MyBlocks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Optional;


public class MyItems {

    public static final Item MITHRIL_INGOT = registerItem("mithril_ingot", new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
    public static final Item MITHRIL_BLOCK = registerBlock(MyBlocks.MITHRIL_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);



    private static <T> Optional<T> ifPart2(T p_151097_) {
        return Optional.empty();
    }

    private static Item registerBlock(Block p_42806_) {
        return registerBlock(new BlockItem(p_42806_, new Item.Properties()));
    }

    private static Item registerBlock(Block p_42808_, CreativeModeTab p_42809_) {
        return registerBlock(new BlockItem(p_42808_, (new Item.Properties()).tab(p_42809_)));
    }

    private static Item registerBlock(Block p_151094_, Optional<CreativeModeTab> p_151095_) {
        return p_151095_.map((p_151102_) -> {
            return registerBlock(p_151094_, p_151102_);
        }).orElseGet(() -> {
            return registerBlock(p_151094_);
        });
    }

    private static Item registerBlock(Block p_151090_, CreativeModeTab p_151091_, Block... p_151092_) {
        BlockItem blockitem = new BlockItem(p_151090_, (new Item.Properties()).tab(p_151091_)) {
            @Override
            public void registerBlocks(java.util.Map<Block, Item> map, Item self) {
                super.registerBlocks(map, self);
                for (Block b : p_151092_) {
                    map.put(b, self);
                }
            }

            @Override
            public void removeFromBlockToItemMap(java.util.Map<Block, Item> map, Item self) {
                super.removeFromBlockToItemMap(map, self);
                for (Block b : p_151092_) {
                    map.remove(b);
                }
            }
        };

        return registerBlock(blockitem);
    }

    private static Item registerBlock(BlockItem p_42804_) {
        return registerBlock(p_42804_.getBlock(), p_42804_);
    }

    protected static Item registerBlock(Block p_42811_, Item p_42812_) {
        return registerItem(Registry.BLOCK.getKey(p_42811_), p_42812_);
    }

    private static Item registerItem(String p_42814_, Item p_42815_) {
        return registerItem(new ResourceLocation(p_42814_), p_42815_);
    }

    private static Item registerItem(ResourceLocation p_42817_, Item p_42818_) {
        if (p_42818_ instanceof BlockItem) {
            ((BlockItem)p_42818_).registerBlocks(Item.BY_BLOCK, p_42818_);
        }

        return Registry.register(Registry.ITEM, p_42817_, p_42818_);
    }
}
