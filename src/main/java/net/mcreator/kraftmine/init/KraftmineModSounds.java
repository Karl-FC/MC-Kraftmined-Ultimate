
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, KraftmineMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> GOOSE_HONK = REGISTRY.register("goose.honk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "goose.honk")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE_SHORT = REGISTRY.register("horror.jumpscare.short",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare.short")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE_LOL = REGISTRY.register("horror.jumpscare.lol", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare.lol")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE_MED = REGISTRY.register("horror.jumpscare.med", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare.med")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE_LONG = REGISTRY.register("horror.jumpscare.long", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare.long")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MICKEY_IDLE = REGISTRY.register("mickey.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mickey.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MICKEY_DEATH = REGISTRY.register("mickey.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mickey.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MICKEY_HURT = REGISTRY.register("mickey.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mickey.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TRAVEL_AETHER = REGISTRY.register("travel.aether", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "travel.aether")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEME_AOT = REGISTRY.register("theme.aot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "theme.aot")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE_CRIMINAL = REGISTRY.register("horror.jumpscare.criminal",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare.criminal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> POTION_TIMEFREEZE = REGISTRY.register("potion.timefreeze", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "potion.timefreeze")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ATTACK_SABER = REGISTRY.register("attack.saber", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "attack.saber")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_CLASSICAL = REGISTRY.register("music.classical", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.classical")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_TERRARIA = REGISTRY.register("music.terraria", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.terraria")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_SWEDEN_REMIX = REGISTRY.register("music.sweden.remix", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.sweden.remix")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_UNDERGROUND = REGISTRY.register("music.underground", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.underground")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DORIME = REGISTRY.register("music.dorime", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.dorime")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_BACKROOMS = REGISTRY.register("ambient.backrooms", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ambient.backrooms")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_BACKROOMS = REGISTRY.register("music.backrooms", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.backrooms")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EFFECTS_BACKROOMS = REGISTRY.register("effects.backrooms", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "effects.backrooms")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_SANS = REGISTRY.register("mob.sans", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.sans")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_GENERALGRIEVOUS_AMBIENCE = REGISTRY.register("mob.generalgrievous.ambience",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.generalgrievous.ambience")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_SANS_HURT = REGISTRY.register("mob.sans.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.sans.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_SENATOR_HURT = REGISTRY.register("mob.senator.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.senator.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_GENERALGRIEVOUS_HURT = REGISTRY.register("mob.generalgrievous.hurt",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.generalgrievous.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SIREN_HURT = REGISTRY.register("siren.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "siren.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SIREN_IDLE = REGISTRY.register("siren.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "siren.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SIREN_DEATH = REGISTRY.register("siren.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "siren.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_SENATOR_IDLE = REGISTRY.register("mob.senator.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.senator.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_SENATOR_DEATH = REGISTRY.register("mob.senator.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.senator.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_IDLE = REGISTRY.register("amogus.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "amogus.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_HURT = REGISTRY.register("amogus.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "amogus.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMOGUS_DEATH = REGISTRY.register("amogus.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "amogus.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SLEUTH_IDLE = REGISTRY.register("sleuth.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "sleuth.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SLEUTH_HURT = REGISTRY.register("sleuth.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "sleuth.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SLEUTH_DEATH = REGISTRY.register("sleuth.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "sleuth.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GIANT_AMBIENT = REGISTRY.register("giant.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "giant.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GIANT_HURT = REGISTRY.register("giant.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "giant.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GIANT_STEP = REGISTRY.register("giant.step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "giant.step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GIANT_DEATH = REGISTRY.register("giant.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "giant.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANOMALY_AMBIENT = REGISTRY.register("anomaly.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "anomaly.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANOMALY_HURT = REGISTRY.register("anomaly.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "anomaly.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ANOMALY_DEATH = REGISTRY.register("anomaly.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "anomaly.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EYE_AMBIENT = REGISTRY.register("eye.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "eye.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EYE_HURTS = REGISTRY.register("eye.hurts", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "eye.hurts")));
	public static final DeferredHolder<SoundEvent, SoundEvent> EYE_DEATH = REGISTRY.register("eye.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "eye.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_RUSHE = REGISTRY.register("music.disc.rushe", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.disc.rushe")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_RICKROLL = REGISTRY.register("music.disc.rickroll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.disc.rickroll")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SHADE_AMBIENT = REGISTRY.register("shade.ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "shade.ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SHADE_DEATH = REGISTRY.register("shade.death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "shade.death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NIGHTMARRIONE = REGISTRY.register("nightmarrione", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "nightmarrione")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HORROR_JUMPSCARE = REGISTRY.register("horror.jumpscare", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "horror.jumpscare")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEME_STARWARS = REGISTRY.register("theme.starwars", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "theme.starwars")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEME_TAKEMEDOWN = REGISTRY.register("theme.takemedown", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "theme.takemedown")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_PENGUIN = REGISTRY.register("mob.penguin", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.penguin")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PINGU_HURT = REGISTRY.register("pingu.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "pingu.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PINGU_IDLE = REGISTRY.register("pingu.idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "pingu.idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PINGU_DIE = REGISTRY.register("pingu.die", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "pingu.die")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_STOMPING = REGISTRY.register("mob.stomping", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.stomping")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEME_24 = REGISTRY.register("theme.24", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "theme.24")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_FROSTCAVERNS = REGISTRY.register("music.frostcaverns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.frostcaverns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_WASTELAND = REGISTRY.register("music.wasteland", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.wasteland")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOOD_BACKROOMS = REGISTRY.register("mood.backrooms", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mood.backrooms")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOOD_WASTELANDS = REGISTRY.register("mood.wastelands", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mood.wastelands")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_RICKROLL = REGISTRY.register("ad.rickroll", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.rickroll")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_DOG = REGISTRY.register("ad.dog", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.dog")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_YOASOBI = REGISTRY.register("ad.yoasobi", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.yoasobi")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_SAUL = REGISTRY.register("ad.saul", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.saul")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_CRAB = REGISTRY.register("ad.crab", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.crab")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_CAT = REGISTRY.register("ad.cat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.cat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_SPONGE = REGISTRY.register("ad.sponge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.sponge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AD_SEASHANTY = REGISTRY.register("ad.seashanty", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ad.seashanty")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_TOREADOR = REGISTRY.register("music.disc.toreador", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.disc.toreador")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PLAYER_OOF = REGISTRY.register("player.oof", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "player.oof")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_EERIE = REGISTRY.register("music.eerie", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.eerie")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_PVZ = REGISTRY.register("music.disc.pvz", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "music.disc.pvz")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_EERIE = REGISTRY.register("ambient.eerie", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "ambient.eerie")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_TARGET = REGISTRY.register("mob.nextbot.target", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.target")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_OBUNGA = REGISTRY.register("mob.nextbot.obunga", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.obunga")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_BONG = REGISTRY.register("mob.nextbot.bong", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.bong")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_QUANDALE = REGISTRY.register("mob.nextbot.quandale", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.quandale")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_YOSHIE = REGISTRY.register("mob.nextbot.yoshie", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.yoshie")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_ENTITY = REGISTRY.register("mob.nextbot.entity", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.entity")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_PIG = REGISTRY.register("mob.nextbot.pig", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.pig")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_INCREDIBLE = REGISTRY.register("mob.nextbot.incredible",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.incredible")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_SMILE = REGISTRY.register("mob.nextbot.smile", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.smile")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOB_NEXTBOT_TEETH = REGISTRY.register("mob.nextbot.teeth", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "mob.nextbot.teeth")));
	public static final DeferredHolder<SoundEvent, SoundEvent> THEME_GIGACHAD = REGISTRY.register("theme.gigachad", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("kraftmine", "theme.gigachad")));
}
