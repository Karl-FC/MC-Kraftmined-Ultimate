
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.SleuthEntity;
import net.mcreator.kraftmine.client.model.Modelsleuth;

public class SleuthRenderer extends MobRenderer<SleuthEntity, Modelsleuth<SleuthEntity>> {
	public SleuthRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsleuth(context.bakeLayer(Modelsleuth.LAYER_LOCATION)), 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(SleuthEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/sleuth.png");
	}
}
