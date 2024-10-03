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
public class Modelgeneral<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modelgeneral"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart left_arm;
	public final ModelPart left_arm2;
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart bone;
	public final ModelPart right_arm3;
	public final ModelPart right_arm4;

	public Modelgeneral(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.left_arm2 = root.getChild("left_arm2");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.bone = root.getChild("bone");
		this.right_arm3 = root.getChild("right_arm3");
		this.right_arm4 = root.getChild("right_arm4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 30).addBox(-8.0F, -20.0F, -8.0F, 16.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(66, 46).addBox(-2.0F, -5.0F, -13.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -34.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -10.0F, -4.0F, 34.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(58, 60)
				.addBox(-10.0F, 16.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(50, 30).addBox(-6.0F, 10.0F, -4.0F, 12.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(76, 102).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.0F, -20.0F, 0.0F, 0.6301F, 0.2967F, -0.3142F));
		PartDefinition left_forearm_r1 = left_arm.addOrReplaceChild("left_forearm_r1", CubeListBuilder.create().texOffs(94, 78).addBox(-2.0F, -1.0213F, -1.7604F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 16.5566F, 0.1337F, -2.2253F, 0.0F, 0.0F));
		PartDefinition saber = left_arm.addOrReplaceChild("saber", CubeListBuilder.create().texOffs(56, 78).addBox(12.0F, -61.5F, -24.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.2718F, 38.5566F, 10.1337F));
		PartDefinition left_arm2 = partdefinition.addOrReplaceChild("left_arm2", CubeListBuilder.create().texOffs(18, 98).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(18.0F, -32.0F, 0.0F, 0.1396F, 0.4014F, -1.9024F));
		PartDefinition left_forearm_r2 = left_arm2.addOrReplaceChild("left_forearm_r2", CubeListBuilder.create().texOffs(86, 0).addBox(-13.9257F, -0.0556F, -4.4779F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(11.9257F, 19.9811F, 1.1286F, -1.789F, 0.0F, 0.0F));
		PartDefinition saber2 = left_arm2.addOrReplaceChild("saber2", CubeListBuilder.create(), PartPose.offset(11.9257F, 19.9811F, -10.8714F));
		PartDefinition saber_r1 = saber2.addOrReplaceChild("saber_r1", CubeListBuilder.create().texOffs(36, 68).addBox(-2.5F, -15.4F, -5.5F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(18, 68).addBox(-1.0F, 0.0F, -2.2F, 4.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.2F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 68).addBox(-3.0F, 0.0F, -2.2F, 4.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.2F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, -1.1345F, 0.0F, 0.0F));
		PartDefinition right_arm3 = partdefinition.addOrReplaceChild("right_arm3", CubeListBuilder.create().texOffs(36, 102).addBox(-0.181F, -0.827F, -2.0852F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-18.0F, -20.0F, 0.0F, 0.6301F, -0.2967F, 0.3142F));
		PartDefinition right_forearm_r1 = right_arm3.addOrReplaceChild("right_forearm_r1", CubeListBuilder.create().texOffs(76, 78).addBox(4.7282F, -4.7838F, 12.9991F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.9092F, 1.7296F, 6.0485F, -2.2253F, 0.0F, 0.0F));
		PartDefinition saber3 = right_arm3.addOrReplaceChild("saber3", CubeListBuilder.create().texOffs(66, 78).addBox(-12.0F, -61.0F, -25.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0908F, 37.7296F, 10.0485F));
		PartDefinition right_arm4 = partdefinition.addOrReplaceChild("right_arm4", CubeListBuilder.create().texOffs(0, 98).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-16.0F, -32.0F, 0.0F, 0.1396F, -0.4014F, 1.9024F));
		PartDefinition right_forearm4_r1 = right_arm4.addOrReplaceChild("right_forearm4_r1", CubeListBuilder.create().texOffs(92, 24).addBox(13.9257F, -0.0556F, -4.4779F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.9257F, 19.9811F, 1.1286F, -1.789F, 0.0F, 0.0F));
		PartDefinition saber4 = right_arm4.addOrReplaceChild("saber4", CubeListBuilder.create(), PartPose.offset(18.0743F, 19.9811F, -10.8714F));
		PartDefinition saber_r2 = saber4.addOrReplaceChild("saber_r2", CubeListBuilder.create().texOffs(46, 68).addBox(6.5125F, -33.4916F, 11.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -6.0F, 0.0F, 1.6581F, 0.0F, -2.0508F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_arm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		right_arm4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.left_arm2.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_arm4.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.right_arm3.yRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
