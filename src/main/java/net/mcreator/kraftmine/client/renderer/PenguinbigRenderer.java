
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.PenguinbigEntity;
import net.mcreator.kraftmine.client.model.Modelpenguin;

public class PenguinbigRenderer extends MobRenderer<PenguinbigEntity, Modelpenguin<PenguinbigEntity>> {
	public PenguinbigRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpenguin(context.bakeLayer(Modelpenguin.LAYER_LOCATION)), 0.7f);
	}

	@Override
	public ResourceLocation getTextureLocation(PenguinbigEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/penguin.png");
	}
}
