
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.IronDroidEntity;
import net.mcreator.kraftmine.client.model.Modeliron_droid;

public class IronDroidRenderer extends MobRenderer<IronDroidEntity, Modeliron_droid<IronDroidEntity>> {
	public IronDroidRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeliron_droid(context.bakeLayer(Modeliron_droid.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IronDroidEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/future_iron_golem.png");
	}
}
