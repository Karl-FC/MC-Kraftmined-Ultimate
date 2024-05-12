
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot4Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot4Renderer extends MobRenderer<Nextbot4Entity, Modelnextbot<Nextbot4Entity>> {
	public Nextbot4Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot4Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_yoshie.png");
	}
}
