// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbod<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "bod"),
			"main");
	private final ModelPart corner;
	private final ModelPart bb_main;

	public Modelbod(ModelPart root) {
		this.corner = root.getChild("corner");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition corner = partdefinition.addOrReplaceChild("corner",
				CubeListBuilder.create().texOffs(12, 10)
						.addBox(2.5F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 10)
						.addBox(-2.5F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 10)
						.addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 10)
						.addBox(2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(6, 0)
						.addBox(-2.0F, -9.5F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -9.5F, 0.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 10)
						.addBox(0.0F, -2.5F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(0.0F, -9.5F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 10)
						.addBox(0.0F, -5.5F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		corner.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}