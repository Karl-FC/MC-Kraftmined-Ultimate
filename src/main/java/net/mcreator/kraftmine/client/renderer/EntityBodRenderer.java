
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.EntityBodEntity;
import net.mcreator.kraftmine.client.model.Modelbod;

public class EntityBodRenderer extends MobRenderer<EntityBodEntity, Modelbod<EntityBodEntity>> {
	public EntityBodRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbod(context.bakeLayer(Modelbod.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityBodEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/bod.png");
	}
}
