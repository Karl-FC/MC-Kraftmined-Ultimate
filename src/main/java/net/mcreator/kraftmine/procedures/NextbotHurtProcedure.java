package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class NextbotHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Distance = 0;
		double Interval = 0;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("forge:nextbot_tags")))) {
			Distance = Mth.nextInt(RandomSource.create(), -10, 10);
			for (int index0 = 0; index0 < 20; index0++) {
				Distance = Mth.nextInt(RandomSource.create(), -10, 10);
				if (!world.getBlockState(BlockPos.containing(x + Distance, y + Distance, z + Distance)).canOcclude() && world.getBlockState(BlockPos.containing(x + Distance, (y + Distance) - 1, z + Distance)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + Distance), (y + Distance), (z + Distance));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + Distance), (y + Distance), (z + Distance), _ent.getYRot(), _ent.getXRot());
					}
					break;
				} else if (world.getBlockState(BlockPos.containing(x + Distance, y + Distance, z + Distance)).canOcclude()) {
					continue;
				}
			}
		}
	}
}
