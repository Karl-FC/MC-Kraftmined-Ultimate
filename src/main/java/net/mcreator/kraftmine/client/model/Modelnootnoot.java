package net.mcreator.kraftmine.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelnootnoot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelnootnoot"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public Modelnootnoot(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -224.0F, 0.0F));
		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 336).addBox(-89.5F, -217.5F, -9.5F, 179.0F, 99.0F, 123.0F, new CubeDeformation(2.5F)),
				PartPose.offsetAndRotation(0.0F, 240.0F, -16.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-118.0F, -34.0F, -110.0F, 236.0F, 156.0F, 180.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(0.0F, -104.0F, -16.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(720, 224).addBox(-47.6F, -81.0249F, -69.0364F, 96.0F, 112.0F, 112.0F, new CubeDeformation(1.2F)).texOffs(481, 336).addBox(-24.0F, -9.4249F, -104.6364F, 48.0F, 24.0F, 64.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -380.0F, -32.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-160.0F, -360.0F, -40.0F));
		PartDefinition right_arm_r1 = right_arm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(0, 560).mirror().addBox(-10.0F, -163.4172F, -73.6313F, 92.0F, 188.0F, 108.0F, new CubeDeformation(2.0F)).mirror(false),
				PartPose.offsetAndRotation(-44.0F, 124.0F, 24.0F, 2.5744F, 0.0F, 0.0F));
		PartDefinition right_arm_r2 = right_arm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(692, 746).addBox(-198.0F, -282.0F, 10.0F, 92.0F, 156.0F, 108.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(144.0F, 288.0F, 24.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(160.0F, -360.0F, -40.0F));
		PartDefinition right_arm_r3 = left_arm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(687, 746).addBox(-50.0F, -84.1429F, -20.9282F, 92.0F, 156.0F, 108.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(12.0F, 90.0F, -6.0F, 0.3054F, 0.0F, 0.0F));
		PartDefinition right_arm_r4 = left_arm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(0, 560).addBox(-56.0F, -166.1316F, -70.0992F, 92.0F, 188.0F, 108.0F, new CubeDeformation(2.0F)),
				PartPose.offsetAndRotation(18.0F, 126.0F, 24.0F, 2.5744F, 0.0F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(654, 0).addBox(-36.0F, 88.0F, -128.0F, 80.0F, 56.0F, 72.0F, new CubeDeformation(0.0F)).texOffs(0, 924).addBox(-35.0F, -23.0F, -55.0F, 78.0F, 166.0F, 86.0F, new CubeDeformation(1.0F)),
				PartPose.offset(-48.0F, -120.0F, 24.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(0, 924).addBox(-43.0F, -23.0F, -55.0F, 78.0F, 166.0F, 86.0F, new CubeDeformation(1.0F)).texOffs(652, 0).addBox(-44.0F, 88.0F, -128.0F, 80.0F, 56.0F, 72.0F, new CubeDeformation(0.0F)),
				PartPose.offset(48.0F, -120.0F, 24.0F));
		return LayerDefinition.create(meshdefinition, 2048, 2048);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
