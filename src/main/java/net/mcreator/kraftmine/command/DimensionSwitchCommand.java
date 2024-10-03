
package net.mcreator.kraftmine.command;

import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import net.mcreator.kraftmine.procedures.DimensionSwitchCommandExecutedProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;

@EventBusSubscriber
public class DimensionSwitchCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("dimension")

				.then(Commands.argument("Dimension", StringArgumentType.word()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					DimensionSwitchCommandExecutedProcedure.execute(arguments, entity);
					return 0;
				})));
	}
}
