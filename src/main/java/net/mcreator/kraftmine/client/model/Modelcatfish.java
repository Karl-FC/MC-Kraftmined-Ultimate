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
public class Modelcatfish<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelcatfish"), "main");
	public final ModelPart body;
	public final ModelPart nek;
	public final ModelPart head3;
	public final ModelPart tail;

	public Modelcatfish(ModelPart root) {
		this.body = root.getChild("body");
		this.nek = root.getChild("nek");
		this.head3 = root.getChild("head3");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
		PartDefinition fin_back = body.addOrReplaceChild("fin_back", CubeListBuilder.create().texOffs(11, 3).addBox(0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition nek = partdefinition.addOrReplaceChild("nek", CubeListBuilder.create().texOffs(15, 17).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));
		PartDefinition head3 = partdefinition.addOrReplaceChild("head3", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -3.0F));
		PartDefinition head = head3.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(15, 0).addBox(-1.5F, -1.02F, -6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(17, 12)
						.addBox(-2.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 13).addBox(1.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(11, 6).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 7.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		nek.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.nek.yRot = headPitch / (180F / (float) Math.PI);
		this.tail.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.head3.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head3.xRot = headPitch / (180F / (float) Math.PI);
	}
}
