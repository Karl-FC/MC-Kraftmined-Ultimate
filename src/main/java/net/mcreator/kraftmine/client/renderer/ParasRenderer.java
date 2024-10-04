
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.ParasEntity;
import net.mcreator.kraftmine.client.model.Modelparas;

public class ParasRenderer extends MobRenderer<ParasEntity, Modelparas<ParasEntity>> {
	public ParasRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelparas(context.bakeLayer(Modelparas.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ParasEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/paras.png");
	}
}
