// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelskeleturtle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "skeleturtle"), "main");
	private final ModelPart head;
	private final ModelPart blaster;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public Modelskeleturtle(ModelPart root) {
		this.head = root.getChild("head");
		this.blaster = root.getChild("blaster");
		this.body = root.getChild("body");
		this.body2 = root.getChild("body2");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(3, 0)
				.addBox(-3.0F, -1.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 19.0F, -10.0F));

		PartDefinition blaster = partdefinition.addOrReplaceChild("blaster", CubeListBuilder.create(),
				PartPose.offset(0.0F, 12.0F, 2.0F));

		PartDefinition head_r1 = blaster.addOrReplaceChild("head_r1",
				CubeListBuilder.create().texOffs(108, 22)
						.addBox(-2.4F, -8.5F, 14.2F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(116, 1)
						.addBox(-1.4F, -7.5F, 15.2F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(104, 10)
						.addBox(-3.0F, -0.5F, 13.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(0.0F, 12.0F, -2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.0F, -10.0F));

		PartDefinition body_rotation = body.addOrReplaceChild("body_rotation",
				CubeListBuilder.create().texOffs(7, 37)
						.addBox(-9.5F, 3.0F, -10.0F, 19.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(31, 1)
						.addBox(-5.5F, 3.0F, -13.0F, 11.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(65, 0)
						.addBox(-6.5F, 6.0F, -4.0F, 13.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.0F, -10.0F));

		PartDefinition body2_rotation = body2.addOrReplaceChild(
				"body2_rotation", CubeListBuilder.create().texOffs(70, 33).addBox(-4.5F, 3.0F, -14.0F, 9.0F, 18.0F,
						1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(1, 23).addBox(
				-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 22.0F, 11.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(1, 12).addBox(
				-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 22.0F, 11.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(27, 30)
				.addBox(-13.0F, 0.0F, -2.0F, 13.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 21.0F, -4.0F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(27, 24).addBox(
				0.0F, 0.0F, -2.0F, 13.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 21.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		blaster.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg4.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg3.yRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.blaster.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.blaster.xRot = headPitch / (180F / (float) Math.PI);
	}
}