// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwasp<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "wasp"), "main");
	private final ModelPart body;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart front_legs;
	private final ModelPart middle_legs;
	private final ModelPart back_legs;
	private final ModelPart left_antenna;
	private final ModelPart right_antenna;
	private final ModelPart torso;

	public Modelwasp(ModelPart root) {
		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
		this.front_legs = root.getChild("front_legs");
		this.middle_legs = root.getChild("middle_legs");
		this.back_legs = root.getChild("back_legs");
		this.left_antenna = root.getChild("left_antenna");
		this.right_antenna = root.getChild("right_antenna");
		this.torso = root.getChild("torso");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(),
				PartPose.offset(1.5F, 16.0F, -5.0F));

		PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1",
				CubeListBuilder.create().texOffs(0, 18).mirror()
						.addBox(1.5F, -9.0F, -3.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.5F, 9.1F, 4.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(),
				PartPose.offset(-0.5F, 16.0F, -5.0F));

		PartDefinition right_wing_r1 = right_wing
				.addOrReplaceChild("right_wing_r1",
						CubeListBuilder.create().texOffs(0, 18).addBox(-10.5F, -9.0F, -3.0F, 9.0F, 0.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.5F, 9.1F, 4.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition front_legs = partdefinition.addOrReplaceChild("front_legs", CubeListBuilder.create()
				.texOffs(28, 1).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 22.0F, -2.0F));

		PartDefinition middle_legs = partdefinition.addOrReplaceChild("middle_legs", CubeListBuilder.create()
				.texOffs(27, 3).addBox(-4.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 22.0F, 0.0F));

		PartDefinition back_legs = partdefinition.addOrReplaceChild("back_legs", CubeListBuilder.create().texOffs(27, 5)
				.addBox(-4.0F, -0.6F, 1.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 22.0F, 2.0F));

		PartDefinition left_antenna = partdefinition.addOrReplaceChild("left_antenna", CubeListBuilder.create()
				.texOffs(2, 0).addBox(1.5F, -2.7F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.0F, -5.0F));

		PartDefinition right_antenna = partdefinition.addOrReplaceChild("right_antenna", CubeListBuilder.create()
				.texOffs(2, 3).addBox(-2.5F, -2.7F, -3.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.0F, -5.0F));

		PartDefinition torso = partdefinition.addOrReplaceChild("torso", CubeListBuilder.create(),
				PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition torso3_r1 = torso.addOrReplaceChild("torso3_r1",
				CubeListBuilder.create().texOffs(38, 12).addBox(-3.5F, -4.0F, -3.4F, 7.0F, 7.0F, 6.0F,
						new CubeDeformation(-1.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1",
				CubeListBuilder.create().texOffs(40, 0).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 7.0F, 5.0F,
						new CubeDeformation(-1.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition stinger = torso.addOrReplaceChild("stinger",
				CubeListBuilder.create().texOffs(24, 7)
						.addBox(0.0F, -0.7836F, 5.6237F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 25)
						.addBox(-3.5F, -4.0424F, -0.8104F, 7.0F, 7.0F, 8.0F, new CubeDeformation(-1.2F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		front_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middle_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.right_wing.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.left_wing.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}