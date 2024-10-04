
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobShadeEntity;
import net.mcreator.kraftmine.client.model.Modelshade;

public class MobShadeRenderer extends MobRenderer<MobShadeEntity, Modelshade<MobShadeEntity>> {
	public MobShadeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelshade(context.bakeLayer(Modelshade.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobShadeEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/shade.png");
	}
}
