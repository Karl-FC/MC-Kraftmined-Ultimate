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
public class Modeltrollge3<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "modeltrollge_3"), "main");
	public final ModelPart cloud;
	public final ModelPart bigcloud;
	public final ModelPart face;

	public Modeltrollge3(ModelPart root) {
		this.cloud = root.getChild("cloud");
		this.bigcloud = root.getChild("bigcloud");
		this.face = root.getChild("face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition cloud = partdefinition.addOrReplaceChild("cloud",
				CubeListBuilder.create().texOffs(0, 0).addBox(-61.235F, 94.4072F, -32.0F, 128.0F, 64.0F, 64.0F, new CubeDeformation(28.0F)).texOffs(0, 0).addBox(-61.235F, -154.5928F, -32.0F, 128.0F, 64.0F, 64.0F, new CubeDeformation(28.0F)),
				PartPose.offset(-0.765F, -162.4072F, -21.0F));
		PartDefinition cube_r1 = cloud.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 137).addBox(-116.0F, 9.0F, -53.0F, 29.0F, 17.0F, 64.0F, new CubeDeformation(28.0F)).texOffs(0, 137).addBox(-116.0F, -282.0F, -53.0F, 29.0F, 17.0F, 64.0F, new CubeDeformation(28.0F)),
				PartPose.offsetAndRotation(0.765F, 180.4072F, 21.0F, 0.0F, 0.0F, 0.6981F));
		PartDefinition cube_r2 = cloud.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 137).addBox(112.0F, -40.0F, -53.0F, 29.0F, 17.0F, 64.0F, new CubeDeformation(28.0F)).texOffs(0, 137).addBox(-24.0F, -320.0F, -53.0F, 29.0F, 17.0F, 64.0F, new CubeDeformation(28.0F)),
				PartPose.offsetAndRotation(0.765F, 180.4072F, 21.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r3 = cloud.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-231.0F, 101.0F, -53.0F, 128.0F, 64.0F, 64.0F, new CubeDeformation(28.0F)).texOffs(0, 0).addBox(-231.0F, -169.0F, -53.0F, 128.0F, 64.0F, 64.0F, new CubeDeformation(28.0F)),
				PartPose.offsetAndRotation(0.765F, 180.4072F, 21.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition bigcloud = partdefinition.addOrReplaceChild("bigcloud", CubeListBuilder.create().texOffs(0, 512).addBox(-128.0F, -120.0F, -114.0F, 256.0F, 256.0F, 256.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -172.0F, -44.0F));
		PartDefinition face = partdefinition.addOrReplaceChild("face", CubeListBuilder.create().texOffs(704, 0).addBox(-48.0F, -66.0F, 46.0F, 128.0F, 128.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -172.0F, -88.0F));
		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cloud.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bigcloud.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		face.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.cloud.zRot = ageInTicks;
		this.bigcloud.yRot = ageInTicks / 20.f;
	}
}
