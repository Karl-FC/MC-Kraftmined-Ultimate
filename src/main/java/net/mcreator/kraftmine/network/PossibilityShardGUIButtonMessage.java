
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

import net.mcreator.kraftmine.world.inventory.PossibilityShardGUIMenu;
import net.mcreator.kraftmine.procedures.PossibilityShardButton3Procedure;
import net.mcreator.kraftmine.procedures.PossibilityShardButton2Procedure;
import net.mcreator.kraftmine.procedures.PossibilityShardButton1Procedure;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record PossibilityShardGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<PossibilityShardGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(KraftmineMod.MODID, "possibility_shard_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PossibilityShardGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PossibilityShardGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PossibilityShardGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<PossibilityShardGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PossibilityShardGUIButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = PossibilityShardGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PossibilityShardButton2Procedure.execute(world, entity);
		}
		if (buttonID == 1) {

			PossibilityShardButton1Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			PossibilityShardButton3Procedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		KraftmineMod.addNetworkMessage(PossibilityShardGUIButtonMessage.TYPE, PossibilityShardGUIButtonMessage.STREAM_CODEC, PossibilityShardGUIButtonMessage::handleData);
	}
}
