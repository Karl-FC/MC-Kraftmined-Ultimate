
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot11Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot11Renderer extends MobRenderer<Nextbot11Entity, Modelnextbot<Nextbot11Entity>> {
	public Nextbot11Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot11Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_uncanny4.png");
	}
}
