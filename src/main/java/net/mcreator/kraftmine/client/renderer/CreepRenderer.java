
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.kraftmine.entity.CreepEntity;

public class CreepRenderer extends MobRenderer<CreepEntity, ChickenModel<CreepEntity>> {
	public CreepRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CreepEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/creep.png");
	}
}
