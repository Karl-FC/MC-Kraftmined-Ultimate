// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelparas<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "paras"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart rightleg2;
	private final ModelPart leftleg2;
	private final ModelPart rightleg1;
	private final ModelPart leftleg1;
	private final ModelPart rightpincher;
	private final ModelPart leftpincher;

	public Modelparas(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.rightleg2 = root.getChild("rightleg2");
		this.leftleg2 = root.getChild("leftleg2");
		this.rightleg1 = root.getChild("rightleg1");
		this.leftleg1 = root.getChild("leftleg1");
		this.rightpincher = root.getChild("rightpincher");
		this.leftpincher = root.getChild("leftpincher");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 17)
						.addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 8)
						.addBox(-1.5F, -0.5F, -6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F)).texOffs(46, 15)
						.addBox(-3.0F, -2.75F, -6.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)).texOffs(46, 15)
						.addBox(0.0F, -2.75F, -6.25F, 3.0F, 3.0F, 2.0F, new CubeDeformation(-0.6F)),
				PartPose.offset(0.0F, 20.0F, -6.0F));

		PartDefinition teeth = head.addOrReplaceChild("teeth",
				CubeListBuilder.create().texOffs(56, 19)
						.addBox(-1.55F, 0.1F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)).texOffs(56, 19)
						.addBox(-1.55F, 0.55F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)).texOffs(56, 19)
						.addBox(-1.55F, 1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)).texOffs(56, 19)
						.addBox(-0.45F, 0.1F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)).texOffs(56, 19)
						.addBox(-0.45F, 0.55F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)).texOffs(56, 19)
						.addBox(-0.45F, 1.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.8F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, 1.0F, -8.0353F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, 2.0F));

		PartDefinition mushroom = body.addOrReplaceChild("mushroom",
				CubeListBuilder.create().texOffs(56, 15)
						.addBox(-1.0F, -3.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 8)
						.addBox(-2.0F, -6.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.75F, 2.25F, -2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition mushroom2 = body.addOrReplaceChild("mushroom2", CubeListBuilder.create().texOffs(56, 15)
				.addBox(-1.0F, -3.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 8).mirror()
				.addBox(-2.0F, -6.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(2.75F, 2.25F, -2.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition rightleg2 = partdefinition.addOrReplaceChild("rightleg2", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 21.0F, 1.75F));

		PartDefinition leg1a = rightleg2.addOrReplaceChild("leg1a",
				CubeListBuilder.create().texOffs(44, 4).addBox(-1.0F, 10.1029F, -2.0F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(7.0F, -7.5F, 0.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition leg1b = rightleg2.addOrReplaceChild("leg1b",
				CubeListBuilder.create().texOffs(26, 0).addBox(-6.0438F, 1.117F, -2.0F, 7.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-5.25F, -3.0F, 0.0F, 0.0F, 0.0F, -1.309F));

		PartDefinition leftleg2 = partdefinition.addOrReplaceChild("leftleg2", CubeListBuilder.create(),
				PartPose.offset(3.0F, 21.0F, 0.75F));

		PartDefinition leg2a = leftleg2.addOrReplaceChild("leg2a",
				CubeListBuilder.create().texOffs(44, 0).addBox(2.0F, 3.6176F, 8.0F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-4.0F, 0.0F, -9.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition leg2b = leftleg2.addOrReplaceChild("leg2b",
				CubeListBuilder.create().texOffs(26, 4).addBox(10.0618F, -4.3513F, 8.6F, 7.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-3.0F, -12.3F, -9.6F, 0.0F, 0.0F, 1.309F));

		PartDefinition rightleg1 = partdefinition.addOrReplaceChild("rightleg1", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 21.0F, 0.0F));

		PartDefinition leg7a = rightleg1.addOrReplaceChild("leg7a",
				CubeListBuilder.create().texOffs(44, 4).addBox(-1.1078F, 10.1029F, 2.25F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(7.0F, -7.5F, -5.75F, 0.0F, 0.0F, 1.0472F));

		PartDefinition leg7b = rightleg1.addOrReplaceChild("leg7b",
				CubeListBuilder.create().texOffs(26, 0).addBox(-17.7621F, -4.34F, 2.25F, 7.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(3.0F, -13.0F, -5.75F, 0.0F, 0.0F, -1.309F));

		PartDefinition leftleg1 = partdefinition.addOrReplaceChild("leftleg1", CubeListBuilder.create(),
				PartPose.offset(3.0F, 21.0F, -0.5F));

		PartDefinition leg8a = leftleg1.addOrReplaceChild("leg8a",
				CubeListBuilder.create().texOffs(44, 0).addBox(2.1078F, 3.6176F, 2.0F, 4.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-4.0F, 0.0F, -5.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition leg8b = leftleg1.addOrReplaceChild("leg8b",
				CubeListBuilder.create().texOffs(26, 4).addBox(10.2443F, -5.3935F, 2.6F, 7.0F, 2.0F, 2.0F,
						new CubeDeformation(-0.3F)),
				PartPose.offsetAndRotation(-4.0F, -12.3F, -5.6F, 0.0F, 0.0F, 1.309F));

		PartDefinition rightpincher = partdefinition.addOrReplaceChild("rightpincher", CubeListBuilder.create(),
				PartPose.offset(-3.0F, 21.0F, -5.0F));

		PartDefinition leg7a2 = rightpincher.addOrReplaceChild("leg7a2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.0F, 1.0F, -2.0F, 0.3911F, -0.5392F, 0.1088F));

		PartDefinition leg7a_r1 = leg7a2.addOrReplaceChild("leg7a_r1",
				CubeListBuilder.create().texOffs(32, 13).addBox(-0.2929F, 1.5355F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4645F, -3.1213F, 1.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition leg7b2 = rightpincher.addOrReplaceChild("leg7b2", CubeListBuilder.create().texOffs(18, 17)
				.addBox(-4.8914F, -1.9811F, -1.5298F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)).texOffs(38, 19)
				.addBox(-8.4914F, -1.9811F, -1.5298F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(-3.0F, 1.0F, -3.5F, -3.1416F, -1.5272F, 2.3562F));

		PartDefinition leftpincher = partdefinition.addOrReplaceChild("leftpincher", CubeListBuilder.create(),
				PartPose.offset(9.0F, 21.0F, -5.0F));

		PartDefinition leg7a3 = leftpincher.addOrReplaceChild("leg7a3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-5.0F, 1.0F, -2.25F, 0.3911F, 0.5392F, 0.1088F));

		PartDefinition leg7a_r2 = leg7a3.addOrReplaceChild("leg7a_r2",
				CubeListBuilder.create().texOffs(32, 13).addBox(-0.2929F, 1.5355F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.4645F, -3.1213F, 1.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition leg7b3 = leftpincher.addOrReplaceChild("leg7b3", CubeListBuilder.create().texOffs(18, 17)
				.addBox(-4.8914F, -1.9811F, -1.5298F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.7F)).texOffs(38, 23)
				.addBox(-8.4914F, -1.9811F, -1.5298F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)),
				PartPose.offsetAndRotation(-2.5F, 1.0F, -3.5F, 3.1416F, -1.5272F, 2.3562F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightpincher.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftpincher.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.rightleg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.rightpincher.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.leftpincher.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leftleg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightleg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftleg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}