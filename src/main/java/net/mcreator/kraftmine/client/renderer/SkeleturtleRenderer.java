
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.SkeleturtleEntity;
import net.mcreator.kraftmine.client.model.Modelskeleturtle;

public class SkeleturtleRenderer extends MobRenderer<SkeleturtleEntity, Modelskeleturtle<SkeleturtleEntity>> {
	public SkeleturtleRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleturtle(context.bakeLayer(Modelskeleturtle.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(SkeleturtleEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/skeleturtle.png");
	}
}
