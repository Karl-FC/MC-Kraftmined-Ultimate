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
public class Modelfloating_eye<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelfloating_eye"), "main");
	public final ModelPart body;
	public final ModelPart eye;
	public final ModelPart tail1;
	public final ModelPart tail2;
	public final ModelPart tail3;

	public Modelfloating_eye(ModelPart root) {
		this.body = root.getChild("body");
		this.eye = root.getChild("eye");
		this.tail1 = root.getChild("tail1");
		this.tail2 = root.getChild("tail2");
		this.tail3 = root.getChild("tail3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 10.0F, -8.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(16, 40).addBox(-6.0F, 8.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(16, 40)
						.addBox(-6.0F, 22.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 28).addBox(-8.0F, 10.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition body_flipped = body.addOrReplaceChild("body_flipped", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition body_sub_1 = body_flipped.addOrReplaceChild("body_sub_1", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(6.0F, -14.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition eye = partdefinition.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 15.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -8.25F));
		PartDefinition tail1 = partdefinition.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 8.0F));
		PartDefinition tail2 = partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 54).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 15.0F));
		PartDefinition tail3 = partdefinition.addOrReplaceChild("tail3",
				CubeListBuilder.create().texOffs(41, 32).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(25, 19).addBox(0.0F, -4.5F, 3.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 20.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tail1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.tail2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.tail3.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
