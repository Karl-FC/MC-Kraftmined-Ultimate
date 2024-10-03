
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.NootnootEntity;
import net.mcreator.kraftmine.client.model.Modelnootnoot;

public class NootnootRenderer extends MobRenderer<NootnootEntity, Modelnootnoot<NootnootEntity>> {
	public NootnootRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelnootnoot(context.bakeLayer(Modelnootnoot.LAYER_LOCATION)), 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(NootnootEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/noot.png");
	}
}
