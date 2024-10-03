
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot1Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot1Renderer extends MobRenderer<Nextbot1Entity, Modelnextbot<Nextbot1Entity>> {
	public Nextbot1Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot1Entity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/nextbot_obunga.png");
	}
}
