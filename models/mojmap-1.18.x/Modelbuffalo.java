// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbuffalo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "buffalo"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public Modelbuffalo(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 30).addBox(
				-4.0F, -3.5F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 6.0F, -9.0F));

		PartDefinition bone2 = head.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(14, 44)
						.addBox(0.0F, -8.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.5F)).texOffs(0, 44)
						.addBox(-3.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(6.0F, -3.0F, -3.0F, -1.0908F, 0.0F, 0.0F));

		PartDefinition bone = head.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 48)
						.addBox(-4.0F, -8.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.5F)).texOffs(0, 44)
						.addBox(-4.0F, -2.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.5F)),
				PartPose.offsetAndRotation(-4.0F, -3.0F, -3.0F, -1.0908F, 0.0F, 0.0F));

		PartDefinition body = partdefinition
				.addOrReplaceChild("body",
						CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -10.0F, -9.5F, 14.0F, 18.0F, 12.0F,
								new CubeDeformation(0.5F)),
						PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(24, 41).addBox(
				-11.0F, 4.5F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(4.0F, 12.0F, 7.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(40, 37).addBox(
				7.0F, 4.5F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-4.0F, 12.0F, 7.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(40, 0).addBox(
				-11.0F, 4.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(4.0F, 12.0F, -6.0F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(28, 30).addBox(
				7.0F, 4.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-4.0F, 12.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}