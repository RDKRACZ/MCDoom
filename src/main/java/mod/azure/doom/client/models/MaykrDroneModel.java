package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierfodder.MaykrDroneEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;

public class MaykrDroneModel extends AnimatedTickingGeoModel<MaykrDroneEntity> {

	@Override
	public ResourceLocation getModelLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/maykrdrone.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/maykrdrone_" + object.getVariant() + ".png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/maykrdrone.animation.json");
	}
}
