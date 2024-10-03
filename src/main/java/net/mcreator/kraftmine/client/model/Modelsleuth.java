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
public class Modelsleuth<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modelsleuth"), "main");
	public final ModelPart head;
	public final ModelPart jaw;
	public final ModelPart body;
	public final ModelPart leg4;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart leg1;

	public Modelsleuth(ModelPart root) {
		this.head = root.getChild("head");
		this.jaw = root.getChild("jaw");
		this.body = root.getChild("body");
		this.leg4 = root.getChild("leg4");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg1 = root.getChild("leg1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 54).addBox(-7.0F, -6.0F, -13.5F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -16.0F));
		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw",
				CubeListBuilder.create().texOffs(58, 54).addBox(-7.0F, -4.0F, -12.5F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(75, 44).addBox(-6.0F, -6.0F, -11.5F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(124, 88)
						.addBox(-6.0F, -6.0F, -9.5F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(80, 118).addBox(4.0F, -6.0F, -9.5F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.5F, -15.5F, 0.3491F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -30.0F, -11.0F, 20.0F, 36.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, 14.0F, 1.4835F, 0.0F, 0.0F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(82, 88).addBox(-1.0F, 8.0F, -2.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 80)
				.addBox(-2.0F, -2.0F, -3.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(90, 74).addBox(-2.0F, 26.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, -4.0F, -12.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(108, 36).addBox(1.0F, 8.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(48, 74)
				.addBox(0.0F, -2.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(106, 106).addBox(0.0F, 26.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -4.0F, 16.0F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 102).addBox(-9.0F, 8.0F, -2.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(74, 22)
				.addBox(-10.0F, -2.0F, -3.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(106, 106).addBox(-10.0F, 26.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, -4.0F, -12.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(34, 96).addBox(-7.0F, 8.0F, -4.0F, 8.0F, 18.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(74, 0)
				.addBox(-8.0F, -2.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(106, 12).addBox(-8.0F, 26.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -4.0F, 14.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.jaw.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
