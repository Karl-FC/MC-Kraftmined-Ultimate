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
public class Modellavahound<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modellavahound"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart front_left_leg;
	public final ModelPart front_right_leg;
	public final ModelPart back_left_leg;
	public final ModelPart back_right_leg;

	public Modellavahound(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.front_left_leg = root.getChild("front_left_leg");
		this.front_right_leg = root.getChild("front_right_leg");
		this.back_left_leg = root.getChild("back_left_leg");
		this.back_right_leg = root.getChild("back_right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -8.5F));
		PartDefinition head_rotation = head.addOrReplaceChild("head_rotation",
				CubeListBuilder.create().texOffs(0, 19).addBox(-7.0F, -3.0F, -19.0F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(1, 13).addBox(6.0F, -7.0F, -11.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 13)
						.addBox(-8.0F, -7.0F, -11.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 13).addBox(-8.0F, -5.0F, -6.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 13)
						.addBox(6.0F, -5.0F, -6.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 13).addBox(-8.0F, -9.0F, -17.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 13)
						.addBox(6.0F, -9.0F, -17.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8727F, 0.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -3.0F, -9.0F, 7.0F, 5.0F, 18.0F, new CubeDeformation(4.0F)), PartPose.offset(0.0F, 7.0F, 4.5F));
		PartDefinition left_gills = body.addOrReplaceChild("left_gills", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
				.addBox(-3.0F, -5.0F, 9.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 40).addBox(-3.0F, -5.0F, 18.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 1.0F, -10.5F));
		PartDefinition top_gills = body.addOrReplaceChild("top_gills", CubeListBuilder.create().texOffs(3, 37).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -10.5F));
		PartDefinition right_gills = body.addOrReplaceChild("right_gills", CubeListBuilder.create().texOffs(11, 40).addBox(0.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 40)
				.addBox(0.0F, -5.0F, 9.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 40).addBox(0.0F, -5.0F, 18.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 1.0F, -10.5F));
		PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(25, 37).addBox(-3.0F, 0.0F, -2.75F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 10.0F, -4.75F));
		PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(32, 41).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 10.0F, -4.5F));
		PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(0, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 13.0F, 14.0F));
		PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(21, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 13.0F, 14.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		front_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		front_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		back_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		back_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.front_right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.back_right_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.back_left_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.front_left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
