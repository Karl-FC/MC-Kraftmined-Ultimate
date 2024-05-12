
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot2Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot2Renderer extends MobRenderer<Nextbot2Entity, Modelnextbot<Nextbot2Entity>> {
	public Nextbot2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot2Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_goofyah.png");
	}
}