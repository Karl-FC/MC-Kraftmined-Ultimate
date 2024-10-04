
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobFloatingEyeEntity;
import net.mcreator.kraftmine.client.model.Modelfloating_eye;

public class MobFloatingEyeRenderer extends MobRenderer<MobFloatingEyeEntity, Modelfloating_eye<MobFloatingEyeEntity>> {
	public MobFloatingEyeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfloating_eye(context.bakeLayer(Modelfloating_eye.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobFloatingEyeEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/eyeball-on-planetminecraft-com.png");
	}
}
