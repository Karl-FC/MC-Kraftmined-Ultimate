
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobBigEntity;
import net.mcreator.kraftmine.client.model.Modelbig;

public class MobBigRenderer extends MobRenderer<MobBigEntity, Modelbig<MobBigEntity>> {
	public MobBigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbig(context.bakeLayer(Modelbig.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobBigEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/big.png");
	}
}
