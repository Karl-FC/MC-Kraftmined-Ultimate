
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.NoobEntity;
import net.mcreator.kraftmine.client.model.Modelnoob;

public class NoobRenderer extends MobRenderer<NoobEntity, Modelnoob<NoobEntity>> {
	public NoobRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnoob(context.bakeLayer(Modelnoob.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NoobEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/noob.png");
	}
}
