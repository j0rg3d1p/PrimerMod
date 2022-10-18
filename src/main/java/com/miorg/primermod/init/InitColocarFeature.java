package com.miorg.primermod.init;

import com.miorg.primermod.Primermod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class InitColocarFeature {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Primermod.MODID);

    public static final RegistryObject<PlacedFeature> MITHRIL_BLOCK = PLACED_FEATURE.register(
            "mithril_block",
            () -> new PlacedFeature(InitConfigureFeature.MITHRIL_BLOCK.getHolder().get(),
                    commonOrePlacement(8, HeightRangePlacement.triangle(
                            VerticalAnchor.bottom(), VerticalAnchor.absolute(20)
                    )))
    );

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height){
        return List.of(CountPlacement.of(countPerChunk), InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}
