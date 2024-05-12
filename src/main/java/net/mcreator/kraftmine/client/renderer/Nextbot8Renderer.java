
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot8Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot8Renderer extends MobRenderer<Nextbot8Entity, Modelnextbot<Nextbot8Entity>> {
	public Nextbot8Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot8Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/nextbot_smile2.png");
	}
}
