
package net.mcreator.kraftmine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public class DiscToreadorsItem extends RecordItem {
	public DiscToreadorsItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:music.disc.toreador")), new Item.Properties().tab(KraftmineModTabs.TAB_CRTAB).stacksTo(1).rarity(Rarity.RARE), 0);
	}
}
