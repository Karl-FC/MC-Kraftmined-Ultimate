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
public class Modellava<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modellava"), "main");
	public final ModelPart helmet;
	public final ModelPart chestplate;
	public final ModelPart RightArm;
	public final ModelPart Leftarm;
	public final ModelPart leggingsright;
	public final ModelPart leggingsleft;
	public final ModelPart LeftFoot;
	public final ModelPart RightFoot;

	public Modellava(ModelPart root) {
		this.helmet = root.getChild("helmet");
		this.chestplate = root.getChild("chestplate");
		this.RightArm = root.getChild("RightArm");
		this.Leftarm = root.getChild("Leftarm");
		this.leggingsright = root.getChild("leggingsright");
		this.leggingsleft = root.getChild("leggingsleft");
		this.LeftFoot = root.getChild("LeftFoot");
		this.RightFoot = root.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition helmet = partdefinition.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-8.0F, -1.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition chestplate = partdefinition.addOrReplaceChild("chestplate", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-8.0F, -4.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-16.0F, 2.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false).texOffs(0, 7).mirror()
				.addBox(-16.0F, -5.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false), PartPose.offset(-4.0F, 1.0F, 0.0F));
		PartDefinition Leftarm = partdefinition.addOrReplaceChild("Leftarm", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(0.0F, -5.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false).texOffs(0, 7).mirror()
				.addBox(0.0F, 2.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false), PartPose.offset(4.0F, 1.0F, 0.0F));
		PartDefinition leggingsright = partdefinition.addOrReplaceChild("leggingsright", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-10.0F, -9.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false).texOffs(0, 7)
				.mirror().addBox(-10.0F, -3.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false), PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition leggingsleft = partdefinition.addOrReplaceChild("leggingsleft", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-6.0F, -3.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false).texOffs(0, 7).mirror()
				.addBox(-6.0F, -9.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition LeftFoot = partdefinition.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-6.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition RightFoot = partdefinition.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-10.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leggingsright.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leggingsleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Leftarm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.LeftFoot.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leggingsright.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leggingsleft.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.helmet.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.helmet.xRot = headPitch / (180F / (float) Math.PI);
		this.RightFoot.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
