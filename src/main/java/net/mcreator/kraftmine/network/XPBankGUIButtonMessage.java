
package net.mcreator.kraftmine.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.world.inventory.XPBankGUIMenu;
import net.mcreator.kraftmine.procedures.XPButtonDepositAllProcedure;
import net.mcreator.kraftmine.procedures.XPButtonDeposit5Procedure;
import net.mcreator.kraftmine.procedures.XPButtonDeposit20Procedure;
import net.mcreator.kraftmine.procedures.XPButtonDeposit1Procedure;
import net.mcreator.kraftmine.procedures.XPButtonDeposit10Procedure;
import net.mcreator.kraftmine.procedures.XPButtonClaimAllProcedure;
import net.mcreator.kraftmine.procedures.XPButtonClaim5Procedure;
import net.mcreator.kraftmine.procedures.XPButtonClaim20Procedure;
import net.mcreator.kraftmine.procedures.XPButtonClaim1Procedure;
import net.mcreator.kraftmine.procedures.XPButtonClaim10Procedure;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class XPBankGUIButtonMessage {
	private final int buttonID, x, y, z;

	public XPBankGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public XPBankGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(XPBankGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(XPBankGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = XPBankGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			XPButtonDepositAllProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			XPButtonClaimAllProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			XPButtonDeposit1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			XPButtonDeposit5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			XPButtonDeposit10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			XPButtonClaim1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			XPButtonClaim5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			XPButtonClaim10Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			XPButtonDeposit20Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			XPButtonClaim20Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		KraftmineMod.addNetworkMessage(XPBankGUIButtonMessage.class, XPBankGUIButtonMessage::buffer, XPBankGUIButtonMessage::new, XPBankGUIButtonMessage::handler);
	}
}
