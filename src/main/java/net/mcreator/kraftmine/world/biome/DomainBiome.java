
package net.mcreator.kraftmine.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;

public class DomainBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-65536).waterColor(4159204).waterFogColor(329011).skyColor(-65536).foliageColorOverride(10387789).grassColorOverride(9470285)
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("kraftmine:music.dorime")), 12000, 24000, true)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
