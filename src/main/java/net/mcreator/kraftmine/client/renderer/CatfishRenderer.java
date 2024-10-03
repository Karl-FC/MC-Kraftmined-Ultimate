
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.CatfishEntity;
import net.mcreator.kraftmine.client.model.Modelcatfish;

public class CatfishRenderer extends MobRenderer<CatfishEntity, Modelcatfish<CatfishEntity>> {
	public CatfishRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcatfish(context.bakeLayer(Modelcatfish.LAYER_LOCATION)), 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(CatfishEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/big.png");
	}
}
