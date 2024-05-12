package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

public class MobDespawnAetherProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:aether")))
				|| (entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:domain_expansion")))) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
