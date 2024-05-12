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
public class Modelpenguin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelpenguin"), "main");
	public final ModelPart base;
	public final ModelPart leftleg;
	public final ModelPart rightleg;

	public Modelpenguin(ModelPart root) {
		this.base = root.getChild("base");
		this.leftleg = root.getChild("leftleg");
		this.rightleg = root.getChild("rightleg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition base = partdefinition.addOrReplaceChild("base",
				CubeListBuilder.create().texOffs(12, 30).addBox(-2.0F, -12.25F, -8.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-6.0F, -17.75F, -6.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.5F, 0.0F));
		PartDefinition rightwing = base.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, 0.25F, -4.0F, 2.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -12.0F, 0.0F));
		PartDefinition leftwing = base.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(20, 30).addBox(-1.0F, 0.25F, -4.0F, 2.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -12.0F, 0.0F));
		PartDefinition leftleg = partdefinition.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, -1.75F, -4.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, -2.0F));
		PartDefinition rightleg = partdefinition.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, -1.75F, -4.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 22.0F, -2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rightleg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftleg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
