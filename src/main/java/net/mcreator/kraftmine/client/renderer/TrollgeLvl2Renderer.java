
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.TrollgeLvl2Entity;
import net.mcreator.kraftmine.client.model.Modeltrollge2;

public class TrollgeLvl2Renderer extends MobRenderer<TrollgeLvl2Entity, Modeltrollge2<TrollgeLvl2Entity>> {
	public TrollgeLvl2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modeltrollge2(context.bakeLayer(Modeltrollge2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrollgeLvl2Entity entity) {
		return new ResourceLocation("kraftmine:textures/entities/trollge2.png");
	}
}
