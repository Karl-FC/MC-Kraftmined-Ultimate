
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.SirenheadEntity;
import net.mcreator.kraftmine.client.model.Modelsirenhead;

public class SirenheadRenderer extends MobRenderer<SirenheadEntity, Modelsirenhead<SirenheadEntity>> {
	public SirenheadRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsirenhead(context.bakeLayer(Modelsirenhead.LAYER_LOCATION)), 0.4f);
	}

	@Override
	public ResourceLocation getTextureLocation(SirenheadEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/sirenhead.png");
	}
}
