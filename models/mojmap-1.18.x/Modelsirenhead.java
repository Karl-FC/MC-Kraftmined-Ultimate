// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelsirenhead<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "sirenhead"), "main");
	private final ModelPart Head;
	private final ModelPart body;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public Modelsirenhead(ModelPart root) {
		this.Head = root.getChild("Head");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 14)
				.addBox(-1.0F, -99.0F, -1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Sirens = Head.addOrReplaceChild("Sirens", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F,
				62.25F, -3.05F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -160.0F, 1.6F));

		PartDefinition bone = Sirens.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(3.5F, 61.5F, 0.3F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(3.5F, 61.5F, -4.5F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(3.5F, 61.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(3.5F, 65.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition bone2 = Sirens.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(2.5F, 62.0F, -0.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(2.5F, 62.0F, -4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(2.5F, 62.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(2.5F, 65.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition Sirens2 = Head.addOrReplaceChild("Sirens2",
				CubeListBuilder.create().texOffs(16, 0).mirror()
						.addBox(0.0F, 57.25F, 0.45F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, -150.0F, -1.9F));

		PartDefinition bone3 = Sirens2.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(9.5F, 56.5F, -1.1F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(9.5F, 56.5F, 3.7F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(9.5F, 56.5F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(9.5F, 60.5F, -1.1F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition bone4 = Sirens2.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(6.5F, 57.0F, -0.55F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(6.5F, 57.0F, 3.15F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(6.5F, 57.0F, -0.6F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(6.5F, 60.0F, -0.6F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(32, 16)
						.addBox(-2.0F, -9.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 20)
						.addBox(-1.55F, 4.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(32, 20)
						.addBox(-1.7F, 11.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -48.0F, 0.0F));

		PartDefinition bone5 = body.addOrReplaceChild("bone5", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(56, 0)
						.addBox(1.0F, 53.0F, -1.0F, 2.0F, 32.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 32)
						.addBox(1.0F, 85.0F, -1.0F, 2.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, -110.0F, 0.0F));

		PartDefinition rightItem = rightArm.addOrReplaceChild("rightItem", CubeListBuilder.create(),
				PartPose.offset(-6.0F, 104.0F, 2.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(56, 0).mirror()
						.addBox(0.0F, 0.0F, -1.0F, 2.0F, 32.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(56, 32).mirror()
						.addBox(0.0F, 32.0F, -1.0F, 2.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(2.0F, -57.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg",
				CubeListBuilder.create().texOffs(58, 0).mirror()
						.addBox(-3.3F, -1.0F, -0.5F, 1.0F, 53.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(4.0F, -28.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(56, 0)
				.addBox(2.3F, -4.0F, -0.5F, 1.0F, 53.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, -25.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}