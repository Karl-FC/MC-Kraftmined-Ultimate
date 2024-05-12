
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot10Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot10Renderer extends MobRenderer<Nextbot10Entity, Modelnextbot<Nextbot10Entity>> {
	public Nextbot10Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot10Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_uncanny3.png");
	}
}
