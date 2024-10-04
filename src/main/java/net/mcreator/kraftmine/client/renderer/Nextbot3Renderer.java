
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot3Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot3Renderer extends MobRenderer<Nextbot3Entity, Modelnextbot<Nextbot3Entity>> {
	public Nextbot3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot3Entity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/nextbot_uncanny2.png");
	}
}
