
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.kraftmine.procedures.CreepestEntityShakingConditionProcedure;
import net.mcreator.kraftmine.entity.CreepestEntity;

public class CreepestRenderer extends MobRenderer<CreepestEntity, CreeperModel<CreepestEntity>> {
	public CreepestRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CreepestEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/creepest.png");
	}

	@Override
	protected boolean isShaking(CreepestEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return CreepestEntityShakingConditionProcedure.execute(world, x, y, z);
	}
}
