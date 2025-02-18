package mod.azure.doom.client;

import org.lwjgl.glfw.GLFW;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.gui.weapons.GunTableScreen;
import mod.azure.doom.client.render.ArachnotronEternalRender;
import mod.azure.doom.client.render.ArachnotronRender;
import mod.azure.doom.client.render.ArchMaykrRender;
import mod.azure.doom.client.render.ArchvileEternalRender;
import mod.azure.doom.client.render.ArchvileRender;
import mod.azure.doom.client.render.ArmoredBaronRender;
import mod.azure.doom.client.render.Baron2016Render;
import mod.azure.doom.client.render.BaronRender;
import mod.azure.doom.client.render.BarrelRender;
import mod.azure.doom.client.render.BloodMaykrRender;
import mod.azure.doom.client.render.CacodemonRender;
import mod.azure.doom.client.render.ChaingunnerRender;
import mod.azure.doom.client.render.CueBallRender;
import mod.azure.doom.client.render.Cyberdemon2016Render;
import mod.azure.doom.client.render.CyberdemonRender;
import mod.azure.doom.client.render.DoomHunterRender;
import mod.azure.doom.client.render.DreadKnightRender;
import mod.azure.doom.client.render.FireBaronRender;
import mod.azure.doom.client.render.GargoyleRender;
import mod.azure.doom.client.render.GladiatorRender;
import mod.azure.doom.client.render.GoreNestRender;
import mod.azure.doom.client.render.Hellknight2016Render;
import mod.azure.doom.client.render.HellknightRender;
import mod.azure.doom.client.render.IconofsinRender;
import mod.azure.doom.client.render.Imp2016Render;
import mod.azure.doom.client.render.ImpRender;
import mod.azure.doom.client.render.ImpStoneRender;
import mod.azure.doom.client.render.LostSoulRender;
import mod.azure.doom.client.render.MancubusRender;
import mod.azure.doom.client.render.MarauderRender;
import mod.azure.doom.client.render.MaykrDroneRender;
import mod.azure.doom.client.render.MechaZombieRender;
import mod.azure.doom.client.render.MotherDemonRender;
import mod.azure.doom.client.render.NightmareImpRender;
import mod.azure.doom.client.render.PainRender;
import mod.azure.doom.client.render.Pinky2016Render;
import mod.azure.doom.client.render.PinkyRender;
import mod.azure.doom.client.render.PossessedScientistRender;
import mod.azure.doom.client.render.PossessedSoldierRender;
import mod.azure.doom.client.render.PossessedWorkerRender;
import mod.azure.doom.client.render.ProwlerRender;
import mod.azure.doom.client.render.Revenant2016Render;
import mod.azure.doom.client.render.RevenantRender;
import mod.azure.doom.client.render.ShotgunguyRender;
import mod.azure.doom.client.render.SpectreRender;
import mod.azure.doom.client.render.SpiderMastermind2016Render;
import mod.azure.doom.client.render.SpiderMastermindRender;
import mod.azure.doom.client.render.SummonerRender;
import mod.azure.doom.client.render.TentacleRender;
import mod.azure.doom.client.render.TurretRender;
import mod.azure.doom.client.render.TyrantRender;
import mod.azure.doom.client.render.UnwillingRender;
import mod.azure.doom.client.render.WhiplashRender;
import mod.azure.doom.client.render.ZombiemanRender;
import mod.azure.doom.client.render.armors.AstroRender;
import mod.azure.doom.client.render.armors.BronzeRender;
import mod.azure.doom.client.render.armors.ClassicBronzeRender;
import mod.azure.doom.client.render.armors.ClassicIndigoRender;
import mod.azure.doom.client.render.armors.ClassicRedRender;
import mod.azure.doom.client.render.armors.ClassicRender;
import mod.azure.doom.client.render.armors.CrimsonRender;
import mod.azure.doom.client.render.armors.CultistRender;
import mod.azure.doom.client.render.armors.DarkLordArmorRender;
import mod.azure.doom.client.render.armors.DemoncideRender;
import mod.azure.doom.client.render.armors.DemonicRender;
import mod.azure.doom.client.render.armors.DoomRender;
import mod.azure.doom.client.render.armors.DoomicornRender;
import mod.azure.doom.client.render.armors.EmberRender;
import mod.azure.doom.client.render.armors.GoldRender;
import mod.azure.doom.client.render.armors.HotrodRender;
import mod.azure.doom.client.render.armors.MaykrRender;
import mod.azure.doom.client.render.armors.MidnightRender;
import mod.azure.doom.client.render.armors.Mullet1Render;
import mod.azure.doom.client.render.armors.Mullet2Render;
import mod.azure.doom.client.render.armors.Mullet3Render;
import mod.azure.doom.client.render.armors.NightmareRender;
import mod.azure.doom.client.render.armors.PainterRender;
import mod.azure.doom.client.render.armors.PhobosRender;
import mod.azure.doom.client.render.armors.PraetorRender;
import mod.azure.doom.client.render.armors.PurplePonyRender;
import mod.azure.doom.client.render.armors.SantaRender;
import mod.azure.doom.client.render.armors.SentinelRender;
import mod.azure.doom.client.render.armors.TwentyFiveRender;
import mod.azure.doom.client.render.armors.ZombieRender;
import mod.azure.doom.client.render.projectiles.ArgentBoltRender;
import mod.azure.doom.client.render.projectiles.BFGCellRender;
import mod.azure.doom.client.render.projectiles.BarenBlastRender;
import mod.azure.doom.client.render.projectiles.BulletsRender;
import mod.azure.doom.client.render.projectiles.ChaingunBulletRender;
import mod.azure.doom.client.render.projectiles.EnergyRender;
import mod.azure.doom.client.render.projectiles.RocketRender;
import mod.azure.doom.client.render.projectiles.ShotgunShellRender;
import mod.azure.doom.client.render.projectiles.UnmaykrBulletRender;
import mod.azure.doom.client.render.projectiles.entity.ArchvileFiringRender;
import mod.azure.doom.client.render.projectiles.entity.BloodBoltRender;
import mod.azure.doom.client.render.projectiles.entity.ChainBladeRender;
import mod.azure.doom.client.render.projectiles.entity.ChaingunMobRender;
import mod.azure.doom.client.render.projectiles.entity.DroneBoltRender;
import mod.azure.doom.client.render.projectiles.entity.EnergyCellMobRender;
import mod.azure.doom.client.render.projectiles.entity.RocketMobRender;
import mod.azure.doom.client.render.tile.GunCraftingRender;
import mod.azure.doom.client.render.tile.TotemRender;
import mod.azure.doom.item.armor.AstroDoomArmor;
import mod.azure.doom.item.armor.BronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicBronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicDoomArmor;
import mod.azure.doom.item.armor.ClassicIndigoDoomArmor;
import mod.azure.doom.item.armor.ClassicRedDoomArmor;
import mod.azure.doom.item.armor.CrimsonDoomArmor;
import mod.azure.doom.item.armor.CultistDoomArmor;
import mod.azure.doom.item.armor.DarkLordArmor;
import mod.azure.doom.item.armor.DemoncideDoomArmor;
import mod.azure.doom.item.armor.DemonicDoomArmor;
import mod.azure.doom.item.armor.DoomArmor;
import mod.azure.doom.item.armor.DoomicornDoomArmor;
import mod.azure.doom.item.armor.EmberDoomArmor;
import mod.azure.doom.item.armor.GoldDoomArmor;
import mod.azure.doom.item.armor.HotrodDoomArmor;
import mod.azure.doom.item.armor.MaykrDoomArmor;
import mod.azure.doom.item.armor.MidnightDoomArmor;
import mod.azure.doom.item.armor.Mullet2DoomArmor;
import mod.azure.doom.item.armor.Mullet3DoomArmor;
import mod.azure.doom.item.armor.MulletDoomArmor;
import mod.azure.doom.item.armor.NightmareDoomArmor;
import mod.azure.doom.item.armor.PainterDoomArmor;
import mod.azure.doom.item.armor.PhobosDoomArmor;
import mod.azure.doom.item.armor.PraetorDoomArmor;
import mod.azure.doom.item.armor.PurplePonyDoomArmor;
import mod.azure.doom.item.armor.SantaDoomArmor;
import mod.azure.doom.item.armor.SentinelDoomArmor;
import mod.azure.doom.item.armor.TwentyFiveDoomArmor;
import mod.azure.doom.item.armor.ZombieDoomArmor;
import mod.azure.doom.util.registry.DoomBlocks;
import mod.azure.doom.util.registry.DoomScreens;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@EventBusSubscriber(modid = DoomMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		Keybindings.RELOAD = new KeyBinding("key." + DoomMod.MODID + ".reload", GLFW.GLFW_KEY_R,
				"key.categories." + DoomMod.MODID);
		ClientRegistry.registerKeyBinding(Keybindings.RELOAD);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARREL.get(), BarrelRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHOTGUN_SHELL.get(), ShotgunShellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARGENT_BOLT.get(), ArgentBoltRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DRONEBOLT_MOB.get(), DroneBoltRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNMAYKR.get(), UnmaykrBulletRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BULLETS.get(), BulletsRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BFG_CELL.get(), BFGCellRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCKET.get(), RocketRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUN_BULLET.get(),
				ChaingunBulletRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLOODBOLT_MOB.get(), BloodBoltRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARENBLAST.get(), BarenBlastRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LOST_SOUL.get(), LostSoulRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP.get(), ImpRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARACHNOTRON.get(), ArachnotronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NIGHTMARE_IMP.get(), NightmareImpRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PINKY.get(), PinkyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CACODEMON.get(), CacodemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARCHVILE.get(), ArchvileRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARON.get(), BaronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MANCUBUS.get(), MancubusRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPIDERMASTERMIND.get(),
				SpiderMastermindRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ZOMBIEMAN.get(), ZombiemanRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REVENANT.get(), RevenantRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP2016.get(), Imp2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUNNER.get(), ChaingunnerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHOTGUNGUY.get(), ShotgunguyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MARAUDER.get(), MarauderRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PAIN.get(), PainRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HELLKNIGHT.get(), HellknightRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CYBERDEMON.get(), CyberdemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNWILLING.get(), UnwillingRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CYBERDEMON2016.get(),
				Cyberdemon2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ICONOFSIN.get(), IconofsinRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POSSESSEDSCIENTIST.get(),
				PossessedScientistRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POSSESSEDSOLDIER.get(),
				PossessedSoldierRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENERGY_CELL_MOB.get(),
				EnergyCellMobRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENERGY_CELL.get(), EnergyRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ROCKET_MOB.get(), RocketMobRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINGUN_MOB.get(), ChaingunMobRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GORE_NEST.get(), GoreNestRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MECHAZOMBIE.get(), MechaZombieRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GARGOYLE.get(), GargoyleRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HELLKNIGHT2016.get(),
				Hellknight2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FIRING.get(), ArchvileFiringRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHAINBLADE.get(), ChainBladeRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPECTRE.get(), SpectreRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CUEBALL.get(), CueBallRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROWLER.get(), ProwlerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DREADKNIGHT.get(), DreadKnightRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.IMP_STONE.get(), ImpStoneRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANT.get(), TyrantRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.POSSESSEDWORKER.get(),
				PossessedWorkerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DOOMHUNTER.get(), DoomHunterRender::new);

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PINKY2016.get(), Pinky2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WHIPLASH.get(), WhiplashRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BARON2016.get(), Baron2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FIREBARON.get(), FireBaronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARMORBARON.get(), ArmoredBaronRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MAYKRDRONE.get(), MaykrDroneRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLOODMAYKR.get(), BloodMaykrRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARCHMAKER.get(), ArchMaykrRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SPIDERMASTERMIND2016.get(),
				SpiderMastermind2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARACHNOTRONETERNAL.get(),
				ArachnotronEternalRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ARCHVILEETERNAL.get(),
				ArchvileEternalRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TENTACLE.get(), TentacleRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MOTHERDEMON.get(), MotherDemonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TURRET.get(), TurretRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SUMMONER.get(), SummonerRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.REVENANT2016.get(), Revenant2016Render::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GLADIATOR.get(), GladiatorRender::new);

		ClientRegistry.bindTileEntityRenderer(ModEntityTypes.TOTEM.get(), TotemRender::new);
		ClientRegistry.bindTileEntityRenderer(ModEntityTypes.GUN_TABLE_ENTITY.get(), GunCraftingRender::new);

		GeoArmorRenderer.registerArmorRenderer(DoomicornDoomArmor.class, new DoomicornRender());
		GeoArmorRenderer.registerArmorRenderer(NightmareDoomArmor.class, new NightmareRender());
		GeoArmorRenderer.registerArmorRenderer(PurplePonyDoomArmor.class, new PurplePonyRender());
		GeoArmorRenderer.registerArmorRenderer(DoomArmor.class, new DoomRender());
		GeoArmorRenderer.registerArmorRenderer(AstroDoomArmor.class, new AstroRender());
		GeoArmorRenderer.registerArmorRenderer(BronzeDoomArmor.class, new BronzeRender());
		GeoArmorRenderer.registerArmorRenderer(CrimsonDoomArmor.class, new CrimsonRender());
		GeoArmorRenderer.registerArmorRenderer(DemoncideDoomArmor.class, new DemoncideRender());
		GeoArmorRenderer.registerArmorRenderer(DemonicDoomArmor.class, new DemonicRender());
		GeoArmorRenderer.registerArmorRenderer(EmberDoomArmor.class, new EmberRender());
		GeoArmorRenderer.registerArmorRenderer(GoldDoomArmor.class, new GoldRender());
		GeoArmorRenderer.registerArmorRenderer(HotrodDoomArmor.class, new HotrodRender());
		GeoArmorRenderer.registerArmorRenderer(MidnightDoomArmor.class, new MidnightRender());
		GeoArmorRenderer.registerArmorRenderer(PhobosDoomArmor.class, new PhobosRender());
		GeoArmorRenderer.registerArmorRenderer(PraetorDoomArmor.class, new PraetorRender());
		GeoArmorRenderer.registerArmorRenderer(TwentyFiveDoomArmor.class, new TwentyFiveRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicBronzeDoomArmor.class, new ClassicBronzeRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicDoomArmor.class, new ClassicRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicIndigoDoomArmor.class, new ClassicIndigoRender());
		GeoArmorRenderer.registerArmorRenderer(ClassicRedDoomArmor.class, new ClassicRedRender());
		GeoArmorRenderer.registerArmorRenderer(MulletDoomArmor.class, new Mullet1Render());
		GeoArmorRenderer.registerArmorRenderer(Mullet2DoomArmor.class, new Mullet2Render());
		GeoArmorRenderer.registerArmorRenderer(Mullet3DoomArmor.class, new Mullet3Render());
		GeoArmorRenderer.registerArmorRenderer(PainterDoomArmor.class, new PainterRender());
		GeoArmorRenderer.registerArmorRenderer(CultistDoomArmor.class, new CultistRender());
		GeoArmorRenderer.registerArmorRenderer(MaykrDoomArmor.class, new MaykrRender());
		GeoArmorRenderer.registerArmorRenderer(SentinelDoomArmor.class, new SentinelRender());
		GeoArmorRenderer.registerArmorRenderer(ZombieDoomArmor.class, new ZombieRender());
		GeoArmorRenderer.registerArmorRenderer(SantaDoomArmor.class, new SantaRender());
		GeoArmorRenderer.registerArmorRenderer(DarkLordArmor.class, new DarkLordArmorRender());

		RenderTypeLookup.setRenderLayer(DoomBlocks.JUMP_PAD.get(), RenderType.translucent());
		ModItemModelsProperties.init();
		ScreenManager.register(DoomScreens.SCREEN_HANDLER_TYPE.get(), GunTableScreen::new);
	}
}