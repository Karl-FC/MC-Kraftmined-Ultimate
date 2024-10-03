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
public class Modelchomper<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "modelchomper"), "main");
	public final ModelPart Leaf;
	public final ModelPart Stem;
	public final ModelPart Upperjaw;
	public final ModelPart lowerjaw;

	public Modelchomper(ModelPart root) {
		this.Leaf = root.getChild("Leaf");
		this.Stem = root.getChild("Stem");
		this.Upperjaw = root.getChild("Upperjaw");
		this.lowerjaw = root.getChild("lowerjaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Leaf = partdefinition.addOrReplaceChild("Leaf", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Leaf9_r1 = Leaf.addOrReplaceChild("Leaf9_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 1.2F, 1.2F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));
		PartDefinition Leaf8_r1 = Leaf.addOrReplaceChild("Leaf8_r1", CubeListBuilder.create().texOffs(0, 20).addBox(1.6F, 1.2F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
		PartDefinition Leaf7_r1 = Leaf.addOrReplaceChild("Leaf7_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-9.6F, 1.2F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));
		PartDefinition Leaf6_r1 = Leaf.addOrReplaceChild("Leaf6_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 1.2F, -9.2F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));
		PartDefinition Leaf5_r1 = Leaf.addOrReplaceChild("Leaf5_r1", CubeListBuilder.create().texOffs(0, 20).addBox(0.8F, 0.8F, 0.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3043F, -0.0262F, -0.2222F));
		PartDefinition Leaf4_r1 = Leaf.addOrReplaceChild("Leaf4_r1", CubeListBuilder.create().texOffs(0, 20).addBox(0.4F, 1.2F, -8.4F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.339F, -0.1313F, -0.1935F));
		PartDefinition Leaf3_r1 = Leaf.addOrReplaceChild("Leaf3_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, 1.2F, 0.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, -0.1112F, 0.2374F));
		PartDefinition Leaf2_r1 = Leaf.addOrReplaceChild("Leaf2_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, 0.8F, -8.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2792F, 0.0048F, 0.2088F));
		PartDefinition Stem = partdefinition.addOrReplaceChild("Stem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.4F, 0.4F));
		PartDefinition Stem3_r1 = Stem.addOrReplaceChild("Stem3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0594F, -4.614F, -0.8619F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(0.0F, -10.0F, 3.2F, 1.5849F, -1.1904F, -1.5651F));
		PartDefinition Stem2_r1 = Stem.addOrReplaceChild("Stem2_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-1.4516F, -4.4493F, -1.0736F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)),
				PartPose.offsetAndRotation(0.0F, -5.2F, 2.8F, -1.6075F, -1.4274F, 1.6259F));
		PartDefinition Stem1_r1 = Stem.addOrReplaceChild("Stem1_r1", CubeListBuilder.create().texOffs(24, 20).addBox(-2.5934F, -6.4587F, -1.2883F, 3.0F, 7.0F, 3.0F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.4F, -1.5815F, -1.061F, 1.599F));
		PartDefinition Upperjaw = partdefinition.addOrReplaceChild("Upperjaw", CubeListBuilder.create(), PartPose.offset(0.0F, 8.5F, 2.5F));
		PartDefinition UpperJaw_r1 = Upperjaw.addOrReplaceChild("UpperJaw_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-7.0F, -0.981F, -8.0375F, 14.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.3F, -0.3F, -0.0873F, 0.0F, 0.0F));
		PartDefinition lowerjaw = partdefinition.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -0.281F, -8.3375F, 14.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.5F, 2.5F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		Leaf.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Stem.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		Upperjaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		lowerjaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.lowerjaw.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Upperjaw.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
	}
}
