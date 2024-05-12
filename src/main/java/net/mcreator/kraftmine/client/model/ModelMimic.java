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
public class ModelMimic<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("kraftmine", "model_mimic"), "main");
	public final ModelPart base;
	public final ModelPart lid;
	public final ModelPart knob;

	public ModelMimic(ModelPart root) {
		this.base = root.getChild("base");
		this.lid = root.getChild("lid");
		this.knob = root.getChild("knob");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 19).addBox(-15.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 24.0F, 8.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 15.0F, 7.0F, 3.1416F, 0.0F, 0.0F));
		PartDefinition knob = partdefinition.addOrReplaceChild("knob", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 16.0F, 8.0F, 3.1416F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, buffer, packedLight, packedOverlay);
		lid.render(poseStack, buffer, packedLight, packedOverlay);
		knob.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.knob.yRot = headPitch / (180F / (float) Math.PI);
		this.lid.yRot = headPitch / (180F / (float) Math.PI);
	}
}
