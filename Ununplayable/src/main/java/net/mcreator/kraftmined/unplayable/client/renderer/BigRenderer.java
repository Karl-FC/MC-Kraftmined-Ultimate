
package net.mcreator.kraftmined.unplayable.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmined.unplayable.entity.BigEntity;
import net.mcreator.kraftmined.unplayable.client.model.Modelbig;

public class BigRenderer extends MobRenderer<BigEntity, Modelbig<BigEntity>> {
	public BigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbig(context.bakeLayer(Modelbig.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(BigEntity entity) {
		return ResourceLocation.parse("km_unplayable:textures/entities/big.png");
	}
}
