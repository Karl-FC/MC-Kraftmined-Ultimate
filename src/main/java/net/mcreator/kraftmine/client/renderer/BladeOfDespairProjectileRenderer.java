package net.mcreator.kraftmine.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.kraftmine.entity.BladeOfDespairProjectileEntity;
import net.mcreator.kraftmine.client.model.Modelbod;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BladeOfDespairProjectileRenderer extends EntityRenderer<BladeOfDespairProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("kraftmine:textures/entities/bod.png");
	private final Modelbod model;

	public BladeOfDespairProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelbod(context.bakeLayer(Modelbod.LAYER_LOCATION));
	}

	@Override
	public void render(BladeOfDespairProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(BladeOfDespairProjectileEntity entity) {
		return texture;
	}
}
