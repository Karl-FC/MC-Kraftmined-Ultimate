package net.mcreator.kraftmine.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.KraftmineMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KraftmineModVariables {
	public static double ScareType = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		KraftmineMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		KraftmineMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
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
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					KraftmineMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					KraftmineMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					KraftmineMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
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

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			Jumpscare_Cooldown = nbt.getBoolean("Jumpscare_Cooldown");
			Event_Rumbling = nbt.getBoolean("Event_Rumbling");
			NoClipped = nbt.getBoolean("NoClipped");
			SupplyTImer = nbt.getDouble("SupplyTImer");
			MickeyCD = nbt.getDouble("MickeyCD");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("Jumpscare_Cooldown", Jumpscare_Cooldown);
			nbt.putBoolean("Event_Rumbling", Event_Rumbling);
			nbt.putBoolean("NoClipped", NoClipped);
			nbt.putDouble("SupplyTImer", SupplyTImer);
			nbt.putDouble("MickeyCD", MickeyCD);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				KraftmineMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "kraftmine_mapvars";
		public double JumpscareLength = 0;
		public double double_jump_enabled = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			JumpscareLength = nbt.getDouble("JumpscareLength");
			double_jump_enabled = nbt.getDouble("double_jump_enabled");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("JumpscareLength", JumpscareLength);
			nbt.putDouble("double_jump_enabled", double_jump_enabled);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				KraftmineMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("kraftmine", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
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

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				KraftmineMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.put("SavedArmor_0", SavedArmor_0.save(new CompoundTag()));
			nbt.put("SavedArmor_1", SavedArmor_1.save(new CompoundTag()));
			nbt.put("SavedArmor_2", SavedArmor_2.save(new CompoundTag()));
			nbt.put("SavedArmor_3", SavedArmor_3.save(new CompoundTag()));
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

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			SavedArmor_0 = ItemStack.of(nbt.getCompound("SavedArmor_0"));
			SavedArmor_1 = ItemStack.of(nbt.getCompound("SavedArmor_1"));
			SavedArmor_2 = ItemStack.of(nbt.getCompound("SavedArmor_2"));
			SavedArmor_3 = ItemStack.of(nbt.getCompound("SavedArmor_3"));
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
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.SavedArmor_0 = message.data.SavedArmor_0;
					variables.SavedArmor_1 = message.data.SavedArmor_1;
					variables.SavedArmor_2 = message.data.SavedArmor_2;
					variables.SavedArmor_3 = message.data.SavedArmor_3;
					variables.Jumpscare_Nightmare = message.data.Jumpscare_Nightmare;
					variables.Jumpscare_Amogus = message.data.Jumpscare_Amogus;
					variables.Jumpscare_Intruder = message.data.Jumpscare_Intruder;
					variables.Jumpscare_Squid = message.data.Jumpscare_Squid;
					variables.AllowDrink = message.data.AllowDrink;
					variables.saber_swing = message.data.saber_swing;
					variables.IsDashing = message.data.IsDashing;
					variables.DashStamina = message.data.DashStamina;
					variables.Thirstlevel = message.data.Thirstlevel;
					variables.PlayerMaxThirst = message.data.PlayerMaxThirst;
					variables.PlayerMaxThirstExhaustion = message.data.PlayerMaxThirstExhaustion;
					variables.PlayerMaxHealth = message.data.PlayerMaxHealth;
					variables.JumpscareVariant = message.data.JumpscareVariant;
					variables.eyepatch_counter = message.data.eyepatch_counter;
					variables.saber_slash = message.data.saber_slash;
					variables.Jumpscare_CD = message.data.Jumpscare_CD;
					variables.ThirstExhaustionLevel = message.data.ThirstExhaustionLevel;
					variables.can_double_jump = message.data.can_double_jump;
					variables.double_jump = message.data.double_jump;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
