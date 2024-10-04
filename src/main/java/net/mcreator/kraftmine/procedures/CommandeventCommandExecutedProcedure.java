package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.HashMap;

public class CommandeventCommandExecutedProcedure {
	public static void execute(LevelAccessor world, HashMap cmdparams) {
		if (cmdparams == null)
			return;
		if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("rumbling")) {
			if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == true) {
				KraftmineModVariables.WorldVariables.get(world).Event_Rumbling = false;
				KraftmineModVariables.WorldVariables.get(world).syncData(world);
				KraftmineMod.LOGGER.info("Rumbling disabled. How can we be free?");
			} else if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == false) {
				KraftmineModVariables.WorldVariables.get(world).Event_Rumbling = true;
				KraftmineModVariables.WorldVariables.get(world).syncData(world);
				KraftmineMod.LOGGER.info("Rumbling activated. Tatakae intensifies");
			}
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("rumbling true")) {
			if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == false) {
				KraftmineModVariables.WorldVariables.get(world).Event_Rumbling = true;
				KraftmineModVariables.WorldVariables.get(world).syncData(world);
				KraftmineMod.LOGGER.info("Rumbling activated. Tatakae intensifies");
			} else if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == true) {
				KraftmineMod.LOGGER.info("The rumbling is in motion.");
			}
		} else if ((cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "").equals("rumbling false")) {
			if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == true) {
				KraftmineModVariables.WorldVariables.get(world).Event_Rumbling = false;
				KraftmineModVariables.WorldVariables.get(world).syncData(world);
				KraftmineMod.LOGGER.info("Rumbling disabled. How can we be free?");
			} else if (KraftmineModVariables.WorldVariables.get(world).Event_Rumbling == false) {
				KraftmineMod.LOGGER.info("The rumbling is not happening. You safe bro");
			}
		}
	}
}
