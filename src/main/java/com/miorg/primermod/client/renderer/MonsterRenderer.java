package com.miorg.primermod.client.renderer;

import com.miorg.primermod.Primermod;
import com.miorg.primermod.client.models.MonsterModel;
import com.miorg.primermod.entities.MonsterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MonsterRenderer extends MobRenderer<MonsterEntity, MonsterModel> {

    // CREAMOS LA VARIABLE DONDE SE VA A ALMACENAR LA TEXTURA

    private static final ResourceLocation TEXTURE = new ResourceLocation(Primermod.MODID, "textures/entities/monster.png");


    public MonsterRenderer(EntityRendererProvider.Context context) {
        super(context, new MonsterModel(context.bakeLayer(MonsterModel.LAYER_LOCATION)),0.25f/* TAMAÑO DE LA SOMBRA */);
    }

    @Override
    public ResourceLocation getTextureLocation(MonsterEntity p_114482_) {
        return TEXTURE;
    }
}
