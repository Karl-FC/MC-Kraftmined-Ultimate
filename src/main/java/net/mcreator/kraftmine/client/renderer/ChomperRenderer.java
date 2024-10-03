
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.ChomperEntity;
import net.mcreator.kraftmine.client.model.Modelchomper;

public class ChomperRenderer extends MobRenderer<ChomperEntity, Modelchomper<ChomperEntity>> {
	public ChomperRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelchomper(context.bakeLayer(Modelchomper.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ChomperEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/chomper.png");
	}
}
