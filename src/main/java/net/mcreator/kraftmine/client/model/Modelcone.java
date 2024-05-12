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

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcone<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modelcone"), "main");
	public final ModelPart headwear;

	public Modelcone(ModelPart root) {
		this.headwear = root.getChild("headwear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(24, 0).addBox(-5.0F, -9.5F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hat2 = headwear.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -1.0F, 0.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offset(-3.5F, -12.05F, -3.5F));
		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.25F, -1.7F, 0.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -2.0F, 1.5F));
		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offset(1.75F, -6.0F, 2.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.headwear.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.headwear.xRot = headPitch / (180F / (float) Math.PI);
	}
}
