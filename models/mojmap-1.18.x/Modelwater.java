// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwater<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "water"), "main");
	private final ModelPart helmet;
	private final ModelPart chestplate;
	private final ModelPart RightArm;
	private final ModelPart Leftarm;
	private final ModelPart leggingsright;
	private final ModelPart leggingsleft;
	private final ModelPart LeftFoot;
	private final ModelPart RightFoot;

	public Modelwater(ModelPart root) {
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

		PartDefinition helmet = partdefinition.addOrReplaceChild("helmet",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-8.0F, -1.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition chestplate = partdefinition.addOrReplaceChild("chestplate",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-8.0F, -4.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-16.0F, 2.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false)
						.texOffs(0, 7).mirror()
						.addBox(-16.0F, -5.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(-4.0F, 1.0F, 0.0F));

		PartDefinition Leftarm = partdefinition.addOrReplaceChild("Leftarm",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(0.0F, -5.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false)
						.texOffs(0, 7).mirror()
						.addBox(0.0F, 2.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false),
				PartPose.offset(4.0F, 1.0F, 0.0F));

		PartDefinition leggingsright = partdefinition.addOrReplaceChild("leggingsright",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-10.0F, -9.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false)
						.texOffs(0, 7).mirror()
						.addBox(-10.0F, -3.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition leggingsleft = partdefinition.addOrReplaceChild("leggingsleft",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-6.0F, -3.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false)
						.texOffs(0, 7).mirror()
						.addBox(-6.0F, -9.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition LeftFoot = partdefinition.addOrReplaceChild("LeftFoot",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-6.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition RightFoot = partdefinition.addOrReplaceChild("RightFoot",
				CubeListBuilder.create().texOffs(0, 7).mirror()
						.addBox(-10.0F, 0.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-4.0F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		helmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		chestplate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leftarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leggingsright.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leggingsleft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
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