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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelbig<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelbig"), "main");
	public final ModelPart body;
	public final ModelPart left_wing;
	public final ModelPart right_wing;
	public final ModelPart front_legs;
	public final ModelPart middle_legs;
	public final ModelPart back_legs;
	public final ModelPart left_antenna;
	public final ModelPart stinger;
	public final ModelPart right_antenna;
	public final ModelPart torso;

	public Modelbig(ModelPart root) {
		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
		this.front_legs = root.getChild("front_legs");
		this.middle_legs = root.getChild("middle_legs");
		this.back_legs = root.getChild("back_legs");
		this.left_antenna = root.getChild("left_antenna");
		this.stinger = root.getChild("stinger");
		this.right_antenna = root.getChild("right_antenna");
		this.torso = root.getChild("torso");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(3.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-1.5F, 15.0F, -3.0F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 18).addBox(-12.0F, 0.0F, 0.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 15.0F, -3.0F));
		PartDefinition front_legs = partdefinition.addOrReplaceChild("front_legs", CubeListBuilder.create().texOffs(28, 1).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 22.0F, -2.0F));
		PartDefinition middle_legs = partdefinition.addOrReplaceChild("middle_legs", CubeListBuilder.create().texOffs(27, 3).addBox(-1.0F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 22.0F, 0.0F));
		PartDefinition back_legs = partdefinition.addOrReplaceChild("back_legs", CubeListBuilder.create().texOffs(27, 5).addBox(-1.0F, 0.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 22.0F, 2.0F));
		PartDefinition left_antenna = partdefinition.addOrReplaceChild("left_antenna", CubeListBuilder.create().texOffs(2, 0).addBox(1.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));
		PartDefinition stinger = partdefinition.addOrReplaceChild("stinger", CubeListBuilder.create().texOffs(24, 7).addBox(0.0F, -1.0F, 5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition right_antenna = partdefinition.addOrReplaceChild("right_antenna", CubeListBuilder.create().texOffs(2, 3).addBox(-2.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -5.0F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(35, 11).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 19.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middle_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		stinger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.right_wing.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_wing.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
