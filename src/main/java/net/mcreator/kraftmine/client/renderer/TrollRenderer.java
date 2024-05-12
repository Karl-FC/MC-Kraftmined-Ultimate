
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.TrollEntity;
import net.mcreator.kraftmine.client.model.Modeltroll;

public class TrollRenderer extends MobRenderer<TrollEntity, Modeltroll<TrollEntity>> {
	public TrollRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltroll(context.bakeLayer(Modeltroll.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TrollEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/troll.png");
	}
}
