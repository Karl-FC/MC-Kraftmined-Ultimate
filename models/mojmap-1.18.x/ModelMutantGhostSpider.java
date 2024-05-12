// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelMutantGhostSpider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "mutantghostspider"), "main");
	private final ModelPart head;
	private final ModelPart neck;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;
	private final ModelPart leg8;
	private final ModelPart Lwing;
	private final ModelPart Rwing;

	public ModelMutantGhostSpider(ModelPart root) {
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
		this.Lwing = root.getChild("Lwing");
		this.Rwing = root.getChild("Rwing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(44, 36).addBox(-4.0F, -3.2F, -8.0F, 8.0F, 8.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 15.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(51, 53).addBox(
				-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 21)
				.addBox(-5.0F, -6.0F, -6.0F, 10.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, 9.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.2F, 13.8F, 9.5F, 0.0F, 0.2182F, 0.0F));

		PartDefinition leg1_r1 = leg1.addOrReplaceChild("leg1_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-8.3448F, 2.17F, 0.6218F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.25F, 0.7F, -0.1F, 0.3054F, 0.3927F, 0.6109F));

		PartDefinition leg1front_r1 = leg1.addOrReplaceChild("leg1front_r1",
				CubeListBuilder.create().texOffs(90, 121).mirror()
						.addBox(-12.9698F, -0.0533F, 0.9554F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-6.55F, -4.2F, 2.8F, -0.385F, 0.3153F, -0.9958F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(4.3F, 14.0F, 9.7F, -0.0349F, -0.2182F, 0.0175F));

		PartDefinition leg2_r1 = leg2.addOrReplaceChild("leg2_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(0.1185F, 3.1658F, 4.656F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3561F, 0.8412F, -4.7566F, 0.3054F, -0.3927F, -0.6109F));

		PartDefinition leg2front_r1 = leg2.addOrReplaceChild("leg2front_r1",
				CubeListBuilder.create().texOffs(90, 121).addBox(4.2503F, -2.3221F, 4.3679F, 10.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.2561F, -3.8588F, -1.3566F, -0.3978F, -0.2987F, 1.0381F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.1F, 14.3F, 5.1F, -0.1753F, -0.1393F, 0.0084F));

		PartDefinition leg3_r1 = leg3.addOrReplaceChild("leg3_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-8.8283F, 2.4073F, 4.2495F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.9081F, 0.8309F, -3.0615F, 0.2156F, 0.0549F, 0.5597F));

		PartDefinition leg3front_r1 = leg3.addOrReplaceChild("leg3front_r1",
				CubeListBuilder.create().texOffs(90, 121).mirror()
						.addBox(-12.2382F, 0.6479F, 4.3981F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-7.6919F, -3.9691F, -2.4615F, -0.0466F, 0.2176F, -0.9785F));

		PartDefinition leg4 = partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(4.4F, 14.5F, 4.7F, -0.1764F, 0.1461F, -0.0259F));

		PartDefinition leg4_r1 = leg4.addOrReplaceChild("leg4_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-1.0207F, 2.4369F, 4.2545F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.2203F, 0.5307F, -2.9487F, 0.2114F, -0.0697F, -0.4913F));

		PartDefinition leg4front_r1 = leg4.addOrReplaceChild("leg4front_r1",
				CubeListBuilder.create().texOffs(90, 121).addBox(2.2237F, 0.1971F, 4.538F, 10.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.8797F, -3.2693F, -2.2487F, -0.0524F, -0.2163F, 1.0053F));

		PartDefinition leg5 = partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.8F, 14.6F, -1.9F, 0.0311F, 0.1767F, -0.0384F));

		PartDefinition leg5_r1 = leg5.addOrReplaceChild("leg5_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-8.5828F, 2.1545F, 1.7001F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0525F, -0.1045F, -0.0135F, -0.1745F, -0.0873F, 0.6109F));

		PartDefinition leg5front_r1 = leg5.addOrReplaceChild("leg5front_r1",
				CubeListBuilder.create().texOffs(90, 121).mirror()
						.addBox(-12.161F, 0.9735F, 1.8886F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-8.0475F, -5.3045F, -1.0135F, 0.0809F, -0.1776F, -0.9311F));

		PartDefinition leg6 = partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(3.0F, 14.8F, -2.0F, -0.0875F, -0.0741F, 0.0572F));

		PartDefinition leg6_r1 = leg6.addOrReplaceChild("leg6_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-1.3163F, 2.2764F, 1.6196F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.2387F, 0.0906F, 0.0425F, 0.0038F, 0.0872F, -0.5671F));

		PartDefinition leg6front_r1 = leg6.addOrReplaceChild("leg6front_r1",
				CubeListBuilder.create().texOffs(90, 121).addBox(2.0964F, 0.4932F, 1.8647F, 10.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.4613F, -4.5094F, -0.9575F, 0.0873F, 0.0F, 0.9599F));

		PartDefinition leg7 = partdefinition.addOrReplaceChild("leg7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-4.1F, 15.0F, -5.2F, 0.0F, -0.2618F, 0.0F));

		PartDefinition leg7_r1 = leg7.addOrReplaceChild("leg7_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-6.516F, 1.0139F, 0.7545F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.45F, -0.5F, 0.2F, -0.5458F, -0.0741F, 0.7956F));

		PartDefinition leg7front_r1 = leg7.addOrReplaceChild("leg7front_r1",
				CubeListBuilder.create().texOffs(90, 121).mirror()
						.addBox(-11.6381F, 1.9629F, 0.8877F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.mirror(false),
				PartPose.offsetAndRotation(-5.0483F, -6.9724F, -0.2184F, 0.0867F, -0.5442F, -0.8202F));

		PartDefinition leg8 = partdefinition.addOrReplaceChild("leg8", CubeListBuilder.create(),
				PartPose.offsetAndRotation(4.2F, 15.0F, -5.4F, 0.0F, 0.2618F, 0.0F));

		PartDefinition leg8_r1 = leg8.addOrReplaceChild("leg8_r1",
				CubeListBuilder.create().texOffs(90, 122).addBox(-3.6467F, 1.5301F, 0.7545F, 10.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.55F, -0.5F, 0.4F, -0.5458F, 0.0741F, -0.7956F));

		PartDefinition leg8front_r1 = leg8.addOrReplaceChild("leg8front_r1",
				CubeListBuilder.create().texOffs(103, 122).addBox(1.7586F, 1.8378F, 1.3961F, 10.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7673F, -6.6816F, -0.6353F, 0.0867F, 0.5442F, 0.8202F));

		PartDefinition Lwing = partdefinition.addOrReplaceChild("Lwing", CubeListBuilder.create(),
				PartPose.offset(-0.6F, 10.0F, 12.8F));

		PartDefinition leg5_r2 = Lwing.addOrReplaceChild("leg5_r2", CubeListBuilder.create().texOffs(1, 105)
				.addBox(-0.6057F, -0.3395F, -3.1143F, 24.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(72, 121)
				.addBox(-0.6057F, -0.4395F, -3.1143F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1797F, -0.9693F, -5.2487F, 0.2224F, -0.0035F, -0.7897F));

		PartDefinition Rwing = partdefinition.addOrReplaceChild("Rwing", CubeListBuilder.create(),
				PartPose.offset(-7.6F, 10.0F, 12.8F));

		PartDefinition leg6_r2 = Rwing.addOrReplaceChild("leg6_r2", CubeListBuilder.create().texOffs(1, 105)
				.addBox(-0.6057F, -0.3395F, -3.1143F, 24.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(72, 121)
				.addBox(-0.6057F, -0.4395F, -3.1143F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.1797F, -0.9693F, -5.2487F, -0.0062F, -0.0831F, -2.4026F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Lwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rwing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Rwing.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Lwing.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg5.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg8.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg6.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg7.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}