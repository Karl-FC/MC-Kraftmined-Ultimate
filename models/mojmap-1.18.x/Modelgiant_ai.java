// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgiant_ai<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "giant_ai"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	private final ModelPart leftLeg;
	private final ModelPart rightLeg;

	public Modelgiant_ai(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leftArm = root.getChild("leftArm");
		this.rightArm = root.getChild("rightArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(-0.1071F, -185.9435F, 9.751F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.1071F, 97.9435F, -9.751F, 0.2618F, 0.0F, 0.0F));

		PartDefinition head_r1_r1 = head_r1.addOrReplaceChild("head_r1_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-32.0F, -66.4429F, -34.4984F, 64.0F, 64.0F, 64.0F,
						new CubeDeformation(4.0F)),
				PartPose.offsetAndRotation(0.0F, -89.0F, 37.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 128)
				.addBox(-31.0F, -180.0F, -5.0F, 64.0F, 96.0F, 32.0F, new CubeDeformation(4.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(128, 256)
				.addBox(-33.5F, -4.0F, -8.0F, 32.0F, 96.0F, 32.0F, new CubeDeformation(4.0F)),
				PartPose.offset(-37.5F, -176.0F, 3.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(256, 0)
				.addBox(3.5F, -4.0F, -8.0F, 32.0F, 96.0F, 32.0F, new CubeDeformation(4.0F)),
				PartPose.offset(37.5F, -176.0F, 3.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 256)
				.addBox(-13.6F, -1.5F, -7.0F, 32.0F, 96.0F, 32.0F, new CubeDeformation(4.0F)),
				PartPose.offset(-22.4F, -74.5F, 2.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create()
				.texOffs(192, 128).addBox(-18.4F, -1.5F, -7.0F, 32.0F, 96.0F, 32.0F, new CubeDeformation(4.0F)),
				PartPose.offset(22.4F, -74.5F, 2.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}