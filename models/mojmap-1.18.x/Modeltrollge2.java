// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltrollge2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "trollge2"), "main");
	private final ModelPart body;
	private final ModelPart bigcloud;
	private final ModelPart face;

	public Modeltrollge2(ModelPart root) {
		this.body = root.getChild("body");
		this.bigcloud = root.getChild("bigcloud");
		this.face = root.getChild("face");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 256)
				.addBox(-60.235F, 160.4072F, -32.0F, 128.0F, 1.0F, 143.0F, new CubeDeformation(28.0F)).texOffs(399, 118)
				.addBox(-60.235F, 127.4072F, -29.0F, 128.0F, 1.0F, 138.0F, new CubeDeformation(21.0F)).texOffs(399, 257)
				.addBox(-43.235F, 82.4072F, -1.0F, 96.0F, 9.0F, 84.0F, new CubeDeformation(20.0F)).texOffs(384, 0)
				.addBox(-43.235F, 103.4072F, -11.0F, 96.0F, 1.0F, 105.0F, new CubeDeformation(25.0F)).texOffs(0, 400)
				.addBox(-28.235F, 70.4072F, 17.0F, 64.0F, 1.0F, 55.0F, new CubeDeformation(21.0F)).texOffs(0, 0)
				.addBox(-12.235F, 36.4072F, 26.0F, 32.0F, 1.0F, 32.0F, new CubeDeformation(21.0F)).texOffs(0, 0)
				.addBox(-60.235F, -53.5928F, -32.0F, 128.0F, 128.0F, 128.0F, new CubeDeformation(-34.0F)),
				PartPose.offset(-0.765F, -162.4072F, -21.0F));

		PartDefinition bigcloud = partdefinition.addOrReplaceChild("bigcloud", CubeListBuilder.create(),
				PartPose.offset(-7.0F, -172.0F, -44.0F));

		PartDefinition face = partdefinition.addOrReplaceChild("face", CubeListBuilder.create().texOffs(704, 0)
				.addBox(-48.0F, -63.0F, 46.0F, 128.0F, 128.0F, 32.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-13.0F, -172.0F, -88.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bigcloud.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		face.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.face.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.face.xRot = headPitch / (180F / (float) Math.PI);
	}
}