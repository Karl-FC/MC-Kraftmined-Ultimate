package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class ExplodeCommandCommandExecutedProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((StringArgumentType.getString(arguments, "Location")).equals("Absolute")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (DoubleArgumentType.getDouble(arguments, "x")), (DoubleArgumentType.getDouble(arguments, "y")), (DoubleArgumentType.getDouble(arguments, "z")), (float) DoubleArgumentType.getDouble(arguments, "ExplosionPower"),
						Explosion.BlockInteraction.DESTROY);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Bomb detonated at " + DoubleArgumentType.getDouble(arguments, "x") + DoubleArgumentType.getDouble(arguments, "y") + DoubleArgumentType.getDouble(arguments, "z") + " with power "
						+ DoubleArgumentType.getDouble(arguments, "ExplosionPower"))), (false));
		} else if ((StringArgumentType.getString(arguments, "Location")).equals("Relative")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX() + DoubleArgumentType.getDouble(arguments, "x")), (entity.getY() + DoubleArgumentType.getDouble(arguments, "y")), (entity.getZ() + DoubleArgumentType.getDouble(arguments, "z")),
						(float) DoubleArgumentType.getDouble(arguments, "ExplosionPower"), Explosion.BlockInteraction.DESTROY);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Bomb detonated at " + (entity.getX() + DoubleArgumentType.getDouble(arguments, "x")) + (entity.getY() + DoubleArgumentType.getDouble(arguments, "y"))
						+ (entity.getZ() + DoubleArgumentType.getDouble(arguments, "z")) + " with power " + DoubleArgumentType.getDouble(arguments, "ExplosionPower"))), (false));
		} else if ((StringArgumentType.getString(arguments, "here")).equals("here")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), (float) DoubleArgumentType.getDouble(arguments, "ExplosionPower"), Explosion.BlockInteraction.DESTROY);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Bomb detonated at " + entity.getX() + entity.getY() + entity.getZ() + " with power " + DoubleArgumentType.getDouble(arguments, "ExplosionPower"))), (false));
		}
	}
}
