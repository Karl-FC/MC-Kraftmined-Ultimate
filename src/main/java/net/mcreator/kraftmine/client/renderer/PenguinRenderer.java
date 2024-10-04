
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.PenguinEntity;
import net.mcreator.kraftmine.client.model.Modelpenguinsmall;

public class PenguinRenderer extends MobRenderer<PenguinEntity, Modelpenguinsmall<PenguinEntity>> {
	public PenguinRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpenguinsmall(context.bakeLayer(Modelpenguinsmall.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(PenguinEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/penguin.png");
	}
}
