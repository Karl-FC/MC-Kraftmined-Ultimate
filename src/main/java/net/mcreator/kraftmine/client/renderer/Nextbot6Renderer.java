
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.Nextbot6Entity;
import net.mcreator.kraftmine.client.model.Modelnextbot;

public class Nextbot6Renderer extends MobRenderer<Nextbot6Entity, Modelnextbot<Nextbot6Entity>> {
	public Nextbot6Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelnextbot(context.bakeLayer(Modelnextbot.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(Nextbot6Entity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/nextbot_rake.png");
	}
}
