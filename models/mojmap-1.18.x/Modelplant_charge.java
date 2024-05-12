// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelplant_charge<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "plant_charge"), "main");
	private final ModelPart bullet;

	public Modelplant_charge(ModelPart root) {
		this.bullet = root.getChild("bullet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bullet = partdefinition.addOrReplaceChild("bullet",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-1.0F, -4.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 0)
						.addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 20.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bullet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bullet.xRot = ageInTicks;
	}
}