
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmine.client.model.Modelwater;
import net.mcreator.kraftmine.client.model.Modelwasp;
import net.mcreator.kraftmine.client.model.Modeltrollge3;
import net.mcreator.kraftmine.client.model.Modeltrollge2;
import net.mcreator.kraftmine.client.model.Modeltroll;
import net.mcreator.kraftmine.client.model.Modelstonespeardropped;
import net.mcreator.kraftmine.client.model.Modelstonespear;
import net.mcreator.kraftmine.client.model.Modelstick_horse;
import net.mcreator.kraftmine.client.model.Modelsleuth;
import net.mcreator.kraftmine.client.model.Modelskeleturtle;
import net.mcreator.kraftmine.client.model.Modelsirenhead;
import net.mcreator.kraftmine.client.model.Modelshroomoo;
import net.mcreator.kraftmine.client.model.Modelshade;
import net.mcreator.kraftmine.client.model.Modelrazor;
import net.mcreator.kraftmine.client.model.Modelquiver;
import net.mcreator.kraftmine.client.model.Modelplant_charge;
import net.mcreator.kraftmine.client.model.Modelpenguinsmall;
import net.mcreator.kraftmine.client.model.Modelpenguin;
import net.mcreator.kraftmine.client.model.Modelparas;
import net.mcreator.kraftmine.client.model.Modelnootnoot;
import net.mcreator.kraftmine.client.model.Modelnoob;
import net.mcreator.kraftmine.client.model.Modelnextbot;
import net.mcreator.kraftmine.client.model.Modellavahound;
import net.mcreator.kraftmine.client.model.Modellava;
import net.mcreator.kraftmine.client.model.Modeliron_droid;
import net.mcreator.kraftmine.client.model.Modeliceologer;
import net.mcreator.kraftmine.client.model.Modelgiant_ai;
import net.mcreator.kraftmine.client.model.Modelgeneral;
import net.mcreator.kraftmine.client.model.Modelfloating_eye;
import net.mcreator.kraftmine.client.model.Modelcursediron;
import net.mcreator.kraftmine.client.model.Modelcone;
import net.mcreator.kraftmine.client.model.Modelchomper;
import net.mcreator.kraftmine.client.model.Modelcatfish;
import net.mcreator.kraftmine.client.model.Modelbullet_seed;
import net.mcreator.kraftmine.client.model.Modelbuffalo_baby;
import net.mcreator.kraftmine.client.model.Modelbuffalo;
import net.mcreator.kraftmine.client.model.Modelbod;
import net.mcreator.kraftmine.client.model.Modelbig;
import net.mcreator.kraftmine.client.model.Modelanomaly;
import net.mcreator.kraftmine.client.model.ModelMutantGhostSpider;
import net.mcreator.kraftmine.client.model.ModelMimic;
import net.mcreator.kraftmine.client.model.ModelMickey;
import net.mcreator.kraftmine.client.model.ModelGoose;
import net.mcreator.kraftmine.client.model.ModelGhostSpider;
import net.mcreator.kraftmine.client.model.ModelAmogus;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KraftmineModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelshroomoo.LAYER_LOCATION, Modelshroomoo::createBodyLayer);
		event.registerLayerDefinition(Modelwater.LAYER_LOCATION, Modelwater::createBodyLayer);
		event.registerLayerDefinition(Modelbullet_seed.LAYER_LOCATION, Modelbullet_seed::createBodyLayer);
		event.registerLayerDefinition(Modelshade.LAYER_LOCATION, Modelshade::createBodyLayer);
		event.registerLayerDefinition(Modelsirenhead.LAYER_LOCATION, Modelsirenhead::createBodyLayer);
		event.registerLayerDefinition(Modeltrollge2.LAYER_LOCATION, Modeltrollge2::createBodyLayer);
		event.registerLayerDefinition(Modelbig.LAYER_LOCATION, Modelbig::createBodyLayer);
		event.registerLayerDefinition(ModelMimic.LAYER_LOCATION, ModelMimic::createBodyLayer);
		event.registerLayerDefinition(Modelcone.LAYER_LOCATION, Modelcone::createBodyLayer);
		event.registerLayerDefinition(ModelMutantGhostSpider.LAYER_LOCATION, ModelMutantGhostSpider::createBodyLayer);
		event.registerLayerDefinition(Modelanomaly.LAYER_LOCATION, Modelanomaly::createBodyLayer);
		event.registerLayerDefinition(Modellava.LAYER_LOCATION, Modellava::createBodyLayer);
		event.registerLayerDefinition(Modelskeleturtle.LAYER_LOCATION, Modelskeleturtle::createBodyLayer);
		event.registerLayerDefinition(Modellavahound.LAYER_LOCATION, Modellavahound::createBodyLayer);
		event.registerLayerDefinition(Modelpenguinsmall.LAYER_LOCATION, Modelpenguinsmall::createBodyLayer);
		event.registerLayerDefinition(Modelparas.LAYER_LOCATION, Modelparas::createBodyLayer);
		event.registerLayerDefinition(Modelchomper.LAYER_LOCATION, Modelchomper::createBodyLayer);
		event.registerLayerDefinition(Modelbuffalo_baby.LAYER_LOCATION, Modelbuffalo_baby::createBodyLayer);
		event.registerLayerDefinition(ModelGoose.LAYER_LOCATION, ModelGoose::createBodyLayer);
		event.registerLayerDefinition(Modelstick_horse.LAYER_LOCATION, Modelstick_horse::createBodyLayer);
		event.registerLayerDefinition(Modelgiant_ai.LAYER_LOCATION, Modelgiant_ai::createBodyLayer);
		event.registerLayerDefinition(ModelGhostSpider.LAYER_LOCATION, ModelGhostSpider::createBodyLayer);
		event.registerLayerDefinition(Modeltroll.LAYER_LOCATION, Modeltroll::createBodyLayer);
		event.registerLayerDefinition(ModelAmogus.LAYER_LOCATION, ModelAmogus::createBodyLayer);
		event.registerLayerDefinition(Modelplant_charge.LAYER_LOCATION, Modelplant_charge::createBodyLayer);
		event.registerLayerDefinition(Modelstonespear.LAYER_LOCATION, Modelstonespear::createBodyLayer);
		event.registerLayerDefinition(Modelbuffalo.LAYER_LOCATION, Modelbuffalo::createBodyLayer);
		event.registerLayerDefinition(Modelwasp.LAYER_LOCATION, Modelwasp::createBodyLayer);
		event.registerLayerDefinition(Modelfloating_eye.LAYER_LOCATION, Modelfloating_eye::createBodyLayer);
		event.registerLayerDefinition(Modelgeneral.LAYER_LOCATION, Modelgeneral::createBodyLayer);
		event.registerLayerDefinition(ModelMickey.LAYER_LOCATION, ModelMickey::createBodyLayer);
		event.registerLayerDefinition(Modelbod.LAYER_LOCATION, Modelbod::createBodyLayer);
		event.registerLayerDefinition(Modelnootnoot.LAYER_LOCATION, Modelnootnoot::createBodyLayer);
		event.registerLayerDefinition(Modeliron_droid.LAYER_LOCATION, Modeliron_droid::createBodyLayer);
		event.registerLayerDefinition(Modelsleuth.LAYER_LOCATION, Modelsleuth::createBodyLayer);
		event.registerLayerDefinition(Modelpenguin.LAYER_LOCATION, Modelpenguin::createBodyLayer);
		event.registerLayerDefinition(Modelnextbot.LAYER_LOCATION, Modelnextbot::createBodyLayer);
		event.registerLayerDefinition(Modelnoob.LAYER_LOCATION, Modelnoob::createBodyLayer);
		event.registerLayerDefinition(Modelstonespeardropped.LAYER_LOCATION, Modelstonespeardropped::createBodyLayer);
		event.registerLayerDefinition(Modeltrollge3.LAYER_LOCATION, Modeltrollge3::createBodyLayer);
		event.registerLayerDefinition(Modelcatfish.LAYER_LOCATION, Modelcatfish::createBodyLayer);
		event.registerLayerDefinition(Modeliceologer.LAYER_LOCATION, Modeliceologer::createBodyLayer);
		event.registerLayerDefinition(Modelcursediron.LAYER_LOCATION, Modelcursediron::createBodyLayer);
		event.registerLayerDefinition(Modelrazor.LAYER_LOCATION, Modelrazor::createBodyLayer);
		event.registerLayerDefinition(Modelquiver.LAYER_LOCATION, Modelquiver::createBodyLayer);
	}
}
