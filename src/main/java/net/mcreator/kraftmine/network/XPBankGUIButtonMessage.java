
package net.mcreator.kraftmine.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
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

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record XPBankGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<XPBankGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(KraftmineMod.MODID, "xp_bank_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, XPBankGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, XPBankGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new XPBankGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<XPBankGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final XPBankGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
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
		KraftmineMod.addNetworkMessage(XPBankGUIButtonMessage.TYPE, XPBankGUIButtonMessage.STREAM_CODEC, XPBankGUIButtonMessage::handleData);
	}
}
