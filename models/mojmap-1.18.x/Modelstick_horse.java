// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstick_horse<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stick_horse"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart saddle;

	public Modelstick_horse(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.saddle = root.getChild("saddle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 13).addBox(
				-3.0F, -11.0F, -5.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -6.0F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F,
				-11.0F, -7.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(19, 16)
				.addBox(0.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.0F, -3.01F));

		PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(19, 16)
				.addBox(-2.55F, -13.0F, 4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.0F, -3.01F));

		PartDefinition neck = head.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 35).addBox(-2.05F,
				-6.0F, -2.0F, 4.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition mane = head.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(56, 36).addBox(-1.0F,
				-11.0F, 5.01F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.01F));

		PartDefinition headpiece = head.addOrReplaceChild("headpiece", CubeListBuilder.create().texOffs(1, 1).addBox(
				-3.0F, -11.0F, -1.9F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, -2.9F));

		PartDefinition noseband = head.addOrReplaceChild("noseband", CubeListBuilder.create().texOffs(19, 0).addBox(
				-2.0F, -11.0F, -4.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition left_bit = head.addOrReplaceChild("left_bit", CubeListBuilder.create().texOffs(29, 5).addBox(
				2.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition right_bit = head.addOrReplaceChild("right_bit", CubeListBuilder.create().texOffs(29, 5).addBox(
				-3.0F, -9.0F, -6.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition left_rein = head.addOrReplaceChild("left_rein", CubeListBuilder.create().texOffs(32, 0).addBox(
				3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 0.5F));

		PartDefinition right_rein = head.addOrReplaceChild("right_rein", CubeListBuilder.create().texOffs(32, 0).addBox(
				-3.1F, -6.0F, -8.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, 0.5F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 6.0F, 6.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(46, 40).addBox(-1.0F, -18.0F, -1.0F, 1.0F, 23.0F, 1.0F,
						new CubeDeformation(0.05F)),
				PartPose.offsetAndRotation(0.0F, 13.0F, -6.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition saddle = partdefinition.addOrReplaceChild("saddle", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		saddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
	}
}