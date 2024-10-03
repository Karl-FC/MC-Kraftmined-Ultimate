package net.mcreator.kraftmine.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.kraftmine.KraftmineMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KraftmineModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, KraftmineMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());
	public static double ScareType = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		KraftmineMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		KraftmineMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.saber_swing = original.saber_swing;
			clone.DashStamina = original.DashStamina;
			clone.double_jump = original.double_jump;
			if (!event.isWasDeath()) {
				clone.SavedArmor_0 = original.SavedArmor_0;
				clone.SavedArmor_1 = original.SavedArmor_1;
				clone.SavedArmor_2 = original.SavedArmor_2;
				clone.SavedArmor_3 = original.SavedArmor_3;
				clone.Jumpscare_Nightmare = original.Jumpscare_Nightmare;
				clone.Jumpscare_Amogus = original.Jumpscare_Amogus;
				clone.Jumpscare_Intruder = original.Jumpscare_Intruder;
				clone.Jumpscare_Squid = original.Jumpscare_Squid;
				clone.AllowDrink = original.AllowDrink;
				clone.IsDashing = original.IsDashing;
				clone.Thirstlevel = original.Thirstlevel;
				clone.PlayerMaxThirst = original.PlayerMaxThirst;
				clone.PlayerMaxThirstExhaustion = original.PlayerMaxThirstExhaustion;
				clone.PlayerMaxHealth = original.PlayerMaxHealth;
				clone.JumpscareVariant = original.JumpscareVariant;
				clone.eyepatch_counter = original.eyepatch_counter;
				clone.saber_slash = original.saber_slash;
				clone.Jumpscare_CD = original.Jumpscare_CD;
				clone.ThirstExhaustionLevel = original.ThirstExhaustionLevel;
				clone.can_double_jump = original.can_double_jump;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "kraftmine_worldvars";
		public boolean Jumpscare_Cooldown = true;
		public boolean Event_Rumbling = false;
		public boolean NoClipped = false;
		public double SupplyTImer = 138000.0;
		public double MickeyCD = 0;

		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			Jumpscare_Cooldown = nbt.getBoolean("Jumpscare_Cooldown");
			Event_Rumbling = nbt.getBoolean("Event_Rumbling");
			NoClipped = nbt.getBoolean("NoClipped");
			SupplyTImer = nbt.getDouble("SupplyTImer");
			MickeyCD = nbt.getDouble("MickeyCD");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putBoolean("Jumpscare_Cooldown", Jumpscare_Cooldown);
			nbt.putBoolean("Event_Rumbling", Event_Rumbling);
			nbt.putBoolean("NoClipped", NoClipped);
			nbt.putDouble("SupplyTImer", SupplyTImer);
			nbt.putDouble("MickeyCD", MickeyCD);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "kraftmine_mapvars";
		public double JumpscareLength = 0;
		public double double_jump_enabled = 0;

		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			JumpscareLength = nbt.getDouble("JumpscareLength");
			double_jump_enabled = nbt.getDouble("double_jump_enabled");
		}

		@Override
		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putDouble("JumpscareLength", JumpscareLength);
			nbt.putDouble("double_jump_enabled", double_jump_enabled);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(KraftmineMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public ItemStack SavedArmor_0 = ItemStack.EMPTY;
		public ItemStack SavedArmor_1 = ItemStack.EMPTY;
		public ItemStack SavedArmor_2 = ItemStack.EMPTY;
		public ItemStack SavedArmor_3 = ItemStack.EMPTY;
		public boolean Jumpscare_Nightmare = false;
		public boolean Jumpscare_Amogus = false;
		public boolean Jumpscare_Intruder = false;
		public boolean Jumpscare_Squid = false;
		public boolean AllowDrink = false;
		public boolean saber_swing = false;
		public boolean IsDashing = false;
		public double DashStamina = 4.0;
		public double Thirstlevel = 20.0;
		public double PlayerMaxThirst = 20.0;
		public double PlayerMaxThirstExhaustion = 10.0;
		public double PlayerMaxHealth = 0.0;
		public double JumpscareVariant = 0;
		public double eyepatch_counter = 0;
		public double saber_slash = 0;
		public double Jumpscare_CD = 0;
		public double ThirstExhaustionLevel = 0;
		public double can_double_jump = 0;
		public double double_jump = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.put("SavedArmor_0", SavedArmor_0.saveOptional(lookupProvider));
			nbt.put("SavedArmor_1", SavedArmor_1.saveOptional(lookupProvider));
			nbt.put("SavedArmor_2", SavedArmor_2.saveOptional(lookupProvider));
			nbt.put("SavedArmor_3", SavedArmor_3.saveOptional(lookupProvider));
			nbt.putBoolean("Jumpscare_Nightmare", Jumpscare_Nightmare);
			nbt.putBoolean("Jumpscare_Amogus", Jumpscare_Amogus);
			nbt.putBoolean("Jumpscare_Intruder", Jumpscare_Intruder);
			nbt.putBoolean("Jumpscare_Squid", Jumpscare_Squid);
			nbt.putBoolean("AllowDrink", AllowDrink);
			nbt.putBoolean("saber_swing", saber_swing);
			nbt.putBoolean("IsDashing", IsDashing);
			nbt.putDouble("DashStamina", DashStamina);
			nbt.putDouble("Thirstlevel", Thirstlevel);
			nbt.putDouble("PlayerMaxThirst", PlayerMaxThirst);
			nbt.putDouble("PlayerMaxThirstExhaustion", PlayerMaxThirstExhaustion);
			nbt.putDouble("PlayerMaxHealth", PlayerMaxHealth);
			nbt.putDouble("JumpscareVariant", JumpscareVariant);
			nbt.putDouble("eyepatch_counter", eyepatch_counter);
			nbt.putDouble("saber_slash", saber_slash);
			nbt.putDouble("Jumpscare_CD", Jumpscare_CD);
			nbt.putDouble("ThirstExhaustionLevel", ThirstExhaustionLevel);
			nbt.putDouble("can_double_jump", can_double_jump);
			nbt.putDouble("double_jump", double_jump);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			SavedArmor_0 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SavedArmor_0"));
			SavedArmor_1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SavedArmor_1"));
			SavedArmor_2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SavedArmor_2"));
			SavedArmor_3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("SavedArmor_3"));
			Jumpscare_Nightmare = nbt.getBoolean("Jumpscare_Nightmare");
			Jumpscare_Amogus = nbt.getBoolean("Jumpscare_Amogus");
			Jumpscare_Intruder = nbt.getBoolean("Jumpscare_Intruder");
			Jumpscare_Squid = nbt.getBoolean("Jumpscare_Squid");
			AllowDrink = nbt.getBoolean("AllowDrink");
			saber_swing = nbt.getBoolean("saber_swing");
			IsDashing = nbt.getBoolean("IsDashing");
			DashStamina = nbt.getDouble("DashStamina");
			Thirstlevel = nbt.getDouble("Thirstlevel");
			PlayerMaxThirst = nbt.getDouble("PlayerMaxThirst");
			PlayerMaxThirstExhaustion = nbt.getDouble("PlayerMaxThirstExhaustion");
			PlayerMaxHealth = nbt.getDouble("PlayerMaxHealth");
			JumpscareVariant = nbt.getDouble("JumpscareVariant");
			eyepatch_counter = nbt.getDouble("eyepatch_counter");
			saber_slash = nbt.getDouble("saber_slash");
			Jumpscare_CD = nbt.getDouble("Jumpscare_CD");
			ThirstExhaustionLevel = nbt.getDouble("ThirstExhaustionLevel");
			can_double_jump = nbt.getDouble("can_double_jump");
			double_jump = nbt.getDouble("double_jump");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(KraftmineMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
