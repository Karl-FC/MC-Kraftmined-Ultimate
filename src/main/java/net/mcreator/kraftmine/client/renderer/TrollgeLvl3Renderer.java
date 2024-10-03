
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.TrollgeLvl3Entity;
import net.mcreator.kraftmine.client.model.Modeltrollge3;

public class TrollgeLvl3Renderer extends MobRenderer<TrollgeLvl3Entity, Modeltrollge3<TrollgeLvl3Entity>> {
	public TrollgeLvl3Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeltrollge3(context.bakeLayer(Modeltrollge3.LAYER_LOCATION)), 10f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrollgeLvl3Entity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/trollge3.png");
	}
}
