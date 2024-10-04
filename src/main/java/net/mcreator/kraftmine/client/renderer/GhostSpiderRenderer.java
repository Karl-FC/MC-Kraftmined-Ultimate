
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.kraftmine.entity.GhostSpiderEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GhostSpiderRenderer extends MobRenderer<GhostSpiderEntity, SpiderModel<GhostSpiderEntity>> {
	public GhostSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new RenderLayer<GhostSpiderEntity, SpiderModel<GhostSpiderEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("kraftmine:textures/entities/ghost_spider_eyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, GhostSpiderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GhostSpiderEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/ghostspider.png");
	}
}
