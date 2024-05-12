
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot9Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot9Renderer extends MobRenderer<Nextbot9Entity, Modelnextbot<Nextbot9Entity>> {
	public Nextbot9Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot9Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_smile3.png");
	}
}
