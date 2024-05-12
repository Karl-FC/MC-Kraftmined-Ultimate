// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstonespeardropped<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "stonespeardropped"), "main");
	private final ModelPart body;

	public Modelstonespeardropped(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.5F, -14.0F, -0.5F, 1.0F, 27.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 7)
						.addBox(-1.5F, -16.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-1.1F)).texOffs(4, 0)
						.addBox(-1.5F, -15.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.75F)),
				PartPose.offsetAndRotation(0.0F, 27.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.body.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.body.xRot = headPitch / (180F / (float) Math.PI);
	}
}