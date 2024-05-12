// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelMickey<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "mickey"), "main");
	private final ModelPart head;
	private final ModelPart left_ear;
	private final ModelPart right_ear;
	private final ModelPart body;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public ModelMickey(ModelPart root) {
		this.head = root.getChild("head");
		this.left_ear = root.getChild("left_ear");
		this.right_ear = root.getChild("right_ear");
		this.body = root.getChild("body");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(12, 16)
						.addBox(-3.0F, -10.0F, -6.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 36)
						.addBox(-8.0F, -19.0F, -5.0F, 16.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition left_ear = partdefinition.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(86, 23)
				.addBox(-2.0F, -12.5F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -22.5F, 0.0F));

		PartDefinition right_ear = partdefinition.addOrReplaceChild("right_ear", CubeListBuilder.create()
				.texOffs(65, 23).addBox(-8.0F, -12.5F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -22.5F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-11.0F, -3.0F, -5.0F, 21.0F, 24.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
				.texOffs(53, 36).addBox(-8.0F, -7.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-11.0F, -6.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(74, 69)
						.addBox(-1.0F, -7.0F, -4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 63)
						.addBox(-2.0F, 4.0F, -5.0F, 10.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(11.0F, -6.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(41, 69)
				.addBox(-6.0F, 0.0F, -4.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 11.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(41, 69).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		left_ear.render(poseStack, buffer, packedLight, packedOverlay);
		right_ear.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		right_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_arm.render(poseStack, buffer, packedLight, packedOverlay);
		left_leg.render(poseStack, buffer, packedLight, packedOverlay);
		right_leg.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}