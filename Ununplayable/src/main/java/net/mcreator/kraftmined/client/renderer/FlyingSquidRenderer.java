
package net.mcreator.kraftmined.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmined.entity.FlyingSquidEntity;
import net.mcreator.kraftmined.client.model.Modelflying_squid;

public class FlyingSquidRenderer extends MobRenderer<FlyingSquidEntity, Modelflying_squid<FlyingSquidEntity>> {
	public FlyingSquidRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelflying_squid(context.bakeLayer(Modelflying_squid.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(FlyingSquidEntity entity) {
		return ResourceLocation.parse("kraftmined:textures/entities/squid.png");
	}
}
