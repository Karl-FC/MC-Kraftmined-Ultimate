package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

public class BuffedArmorSpawningProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String armorRegString = "";
		ItemStack armorPiece = ItemStack.EMPTY;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("kraftmined:yes_armor")))) {
			armorPiece = new ItemStack(
					(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("minecraft:leg_armor"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
			armorRegString = BuiltInRegistries.ITEM.getKey(armorPiece.getItem()).toString();
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "helmet"))).toLowerCase(java.util.Locale.ENGLISH)))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "helmet"))).toLowerCase(java.util.Locale.ENGLISH)))));
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "chestplate"))).toLowerCase(java.util.Locale.ENGLISH)))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "chestplate"))).toLowerCase(java.util.Locale.ENGLISH)))));
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, armorPiece);
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, armorPiece);
					}
				}
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "boots"))).toLowerCase(java.util.Locale.ENGLISH)))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((armorRegString.replace("leggings", "boots"))).toLowerCase(java.util.Locale.ENGLISH)))));
					}
				}
			}
			if (Math.random() < 0.001) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("kraftmined:randomheads"))).getRandomElement(RandomSource.create())
								.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("kraftmined:randomheads"))).getRandomElement(RandomSource.create())
								.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
					}
				}
			}
			if (Math.random() < 0.001) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(Items.ELYTRA));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.ELYTRA));
					}
				}
			}
		}
	}
}
