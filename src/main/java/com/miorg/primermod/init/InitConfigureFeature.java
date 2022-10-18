package com.miorg.primermod.init;

import com.google.common.base.Suppliers;
import com.miorg.primermod.Primermod;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.Registry;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class InitConfigureFeature {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Primermod.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> EXAMPLE_OVERWORLD_REPLACE =
            Suppliers.memoize(() -> List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, InitBlocks.MITHRIL_BLOCK.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, InitBlocks.MITHRIL_BLOCK.get().defaultBlockState()),
                    OreConfiguration.target(new BlockMatchTest(Blocks.DIAMOND_BLOCK), InitBlocks.MITHRIL_BLOCK.get().defaultBlockState())

            ));

    public static final RegistryObject<ConfiguredFeature<?,?>> MITHRIL_BLOCK = CONFIGURED_FEATURES.register(
            "mithril_block",
            () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(EXAMPLE_OVERWORLD_REPLACE.get(),4))
    );
}
