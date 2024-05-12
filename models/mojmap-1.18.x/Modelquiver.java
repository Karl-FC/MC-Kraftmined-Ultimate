// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelquiver<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "quiver"), "main");
	private final ModelPart Quiver;
	private final ModelPart Larm;
	private final ModelPart Rarm;

	public Modelquiver(ModelPart root) {
		this.Quiver = root.getChild("Quiver");
		this.Larm = root.getChild("Larm");
		this.Rarm = root.getChild("Rarm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Quiver = partdefinition.addOrReplaceChild("Quiver",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-7.0F, 7.0F, 1.75F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 8)
						.addBox(-6.0F, 6.0F, 1.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(9, 7)
						.addBox(-2.0F, 2.0F, 1.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-1.0F, 1.0F, 1.75F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(9, 22)
						.addBox(0.0F, 1.0F, 1.75F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 18)
						.addBox(1.0F, 0.0F, 1.75F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(17, 0)
						.addBox(2.0F, -1.0F, 1.75F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(15, 15)
						.addBox(3.0F, -2.0F, 1.75F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 22)
						.addBox(4.0F, -1.0F, 1.75F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(27, 27)
						.addBox(5.0F, 0.0F, 1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 0)
						.addBox(-3.0F, 3.0F, 1.75F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(24, 15)
						.addBox(-4.0F, 4.0F, 1.75F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-5.0F, 5.0F, 1.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 10)
						.addBox(-6.0F, 10.0F, 1.75F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Strap = Quiver.addOrReplaceChild("Strap", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F,
				0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Larm = partdefinition.addOrReplaceChild("Larm", CubeListBuilder.create().texOffs(0, 39).addBox(
				-13.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(20.0F, 0.0F, 0.0F));

		PartDefinition Rarm = partdefinition.addOrReplaceChild("Rarm", CubeListBuilder.create().texOffs(0, 40).addBox(
				-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Quiver.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Larm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Rarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}