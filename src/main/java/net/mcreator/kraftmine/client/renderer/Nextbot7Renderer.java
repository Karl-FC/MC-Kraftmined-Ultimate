
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot7Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot7Renderer extends MobRenderer<Nextbot7Entity, Modelnextbot<Nextbot7Entity>> {
	public Nextbot7Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot7Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_smile.png");
	}
}
