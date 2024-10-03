package net.mcreator.kraftmine.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelanomaly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modelanomaly"), "main");
	public final ModelPart everything_else;
	public final ModelPart head2;

	public Modelanomaly(ModelPart root) {
		this.everything_else = root.getChild("everything_else");
		this.head2 = root.getChild("head2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition everything_else = partdefinition.addOrReplaceChild("everything_else", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition body = everything_else.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 20).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition bodywear = everything_else.addOrReplaceChild("bodywear", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition arms = everything_else.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -3.5F, 0.3F));
		PartDefinition arms_rotation = arms.addOrReplaceChild("arms_rotation",
				CubeListBuilder.create().texOffs(44, 22).addBox(-8.0F, 0.0F, -2.05F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 38).addBox(-4.0F, 4.0F, -2.05F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.05F, -0.7505F, 0.0F, 0.0F));
		PartDefinition arms_flipped = arms_rotation.addOrReplaceChild("arms_flipped", CubeListBuilder.create().texOffs(44, 22).mirror().addBox(4.0F, -24.0F, -2.05F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_leg = everything_else.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 22).addBox(2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 5.0F, 0.0F));
		PartDefinition right_leg = everything_else.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, 5.0F, 0.0F));
		PartDefinition head = everything_else.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition headwear = everything_else.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 64).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -17.05F, -5.0F));
		PartDefinition hat2 = headwear.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(0, 76).addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.25F, -4.0F, 2.0F, -0.0524F, 0.0F, 0.0262F));
		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));
		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(0, 95).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));
		PartDefinition head2 = partdefinition.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 87).addBox(-1.5F, -42.05F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		everything_else.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		head2.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.everything_else.yRot = ageInTicks / 20.f;
		this.head2.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head2.xRot = headPitch / (180F / (float) Math.PI);
	}
}
