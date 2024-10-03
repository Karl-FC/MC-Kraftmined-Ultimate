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

// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelGhostSpider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("kraftmine", "model_ghost_spider"), "main");
	public final ModelPart head;
	public final ModelPart neck;
	public final ModelPart body;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart leg4;
	public final ModelPart leg5;
	public final ModelPart leg6;
	public final ModelPart leg7;
	public final ModelPart leg8;

	public ModelGhostSpider(ModelPart root) {
		this.head = root.getChild("head");
		this.neck = root.getChild("neck");
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.leg5 = root.getChild("leg5");
		this.leg6 = root.getChild("leg6");
		this.leg7 = root.getChild("leg7");
		this.leg8 = root.getChild("leg8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -3.0F));
		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -4.0F, 1.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 15.0F, 2.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(4.0F, 15.0F, 4.0F));
		PartDefinition leg1a = leg1.addOrReplaceChild("leg1a", CubeListBuilder.create().texOffs(18, 0).addBox(-14.1213F, 6.1924F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition leg1b = leg1.addOrReplaceChild("leg1b", CubeListBuilder.create().texOffs(18, 0).addBox(-18.2929F, -14.1787F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-4.0F, 15.0F, 4.0F));
		PartDefinition leg2a = leg2.addOrReplaceChild("leg2a", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -1.0F, 8.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -9.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg2b = leg2.addOrReplaceChild("leg2b", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -13.0F, 8.8F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -9.8F, -0.0436F, 0.0F, 0.7854F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset(4.0F, 15.0F, -2.0F));
		PartDefinition leg3a = leg3.addOrReplaceChild("leg3a", CubeListBuilder.create().texOffs(18, 0).addBox(-14.1213F, 6.1924F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition leg3b = leg3.addOrReplaceChild("leg3b", CubeListBuilder.create().texOffs(18, 0).addBox(-18.2929F, -14.1787F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create(), PartPose.offset(-4.0F, 15.0F, 1.0F));
		PartDefinition leg4a = leg4.addOrReplaceChild("leg4a", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -1.0F, 5.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -6.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg4b = leg4.addOrReplaceChild("leg4b", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -13.0F, 5.3F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -6.8F, -0.0436F, 0.0F, 0.7854F));
		PartDefinition leg5 = partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create(), PartPose.offset(4.0F, 15.0F, -2.0F));
		PartDefinition leg5a = leg5.addOrReplaceChild("leg5a", CubeListBuilder.create().texOffs(18, 0).addBox(-14.1213F, 6.1924F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition leg5b = leg5.addOrReplaceChild("leg5b", CubeListBuilder.create().texOffs(18, 0).addBox(-18.2929F, -14.1787F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg6 = partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create(), PartPose.offset(-4.0F, 15.0F, -2.0F));
		PartDefinition leg6a = leg6.addOrReplaceChild("leg6a", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -1.0F, 2.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -3.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg6b = leg6.addOrReplaceChild("leg6b", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -13.0F, 2.3F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, -3.8F, -0.0436F, 0.0F, 0.7854F));
		PartDefinition leg7 = partdefinition.addOrReplaceChild("leg7", CubeListBuilder.create(), PartPose.offset(4.0F, 15.0F, -5.0F));
		PartDefinition leg7a = leg7.addOrReplaceChild("leg7a", CubeListBuilder.create().texOffs(18, 0).addBox(-14.1213F, 6.1924F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition leg7b = leg7.addOrReplaceChild("leg7b", CubeListBuilder.create().texOffs(18, 0).addBox(-18.2929F, -14.1787F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg8 = partdefinition.addOrReplaceChild("leg8", CubeListBuilder.create(), PartPose.offset(-1.0F, 22.0F, -5.0F));
		PartDefinition leg8a = leg8.addOrReplaceChild("leg8a", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition leg8b = leg8.addOrReplaceChild("leg8b", CubeListBuilder.create().texOffs(18, 0).addBox(7.0F, -13.0F, -0.7F, 12.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -7.3F, -0.8F, -0.0436F, 0.0F, 0.7854F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int rgb) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		neck.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
		leg4.render(poseStack, buffer, packedLight, packedOverlay);
		leg5.render(poseStack, buffer, packedLight, packedOverlay);
		leg6.render(poseStack, buffer, packedLight, packedOverlay);
		leg7.render(poseStack, buffer, packedLight, packedOverlay);
		leg8.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
