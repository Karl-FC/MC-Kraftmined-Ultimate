
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.ShrooMooEntity;
import net.mcreator.kraftmine.client.model.Modelshroomoo;

public class ShrooMooRenderer extends MobRenderer<ShrooMooEntity, Modelshroomoo<ShrooMooEntity>> {
	public ShrooMooRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelshroomoo(context.bakeLayer(Modelshroomoo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShrooMooEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/shroomoo.png");
	}
}
