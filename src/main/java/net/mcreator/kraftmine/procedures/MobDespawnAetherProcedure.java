package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class MobDespawnAetherProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:aether"))
				|| (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:domain_expansion"))) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
