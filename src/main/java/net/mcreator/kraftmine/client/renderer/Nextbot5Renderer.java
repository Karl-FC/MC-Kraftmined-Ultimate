
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot5Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot5Renderer extends MobRenderer<Nextbot5Entity, Modelnextbot<Nextbot5Entity>> {
	public Nextbot5Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot5Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_bong.png");
	}
}
