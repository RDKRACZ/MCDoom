package mod.azure.doom.entity.projectiles.entity;

import mod.azure.doom.util.config.DoomConfig;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RocketMobEntity extends DamagingProjectileEntity implements IAnimatable {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;
	private float directHitDamage = 5F;
	private LivingEntity shooter;

	public RocketMobEntity(EntityType<? extends RocketMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public RocketMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ,
			float directHitDamage) {
		super(ModEntityTypes.ROCKET_MOB.get(), shooter, accelX, accelY, accelZ, worldIn);
		this.shooter = shooter;
		this.directHitDamage = directHitDamage;
	}

	public void setDirectHitDamage(float directHitDamage) {
		this.directHitDamage = directHitDamage;
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<RocketMobEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
		this.ticksInAir = 0;
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		this.ticksInAir = compound.getShort("life");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick() {
		Entity entity = this.getOwner();
		if (this.level.isClientSide
				|| (entity == null || entity.isAlive()) && this.level.hasChunkAt(this.blockPosition())) {
			super.tick();
			RayTraceResult raytraceresult = ProjectileHelper.getHitResult(this, this::canHitEntity);
			if (raytraceresult.getType() != RayTraceResult.Type.MISS
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onHit(raytraceresult);
			}
			this.checkInsideBlocks();
			Vector3d vector3d = this.getDeltaMovement();
			double d0 = this.getX() + vector3d.x;
			double d1 = this.getY() + vector3d.y;
			double d2 = this.getZ() + vector3d.z;
			ProjectileHelper.rotateTowardsMovement(this, 0.2F);
			float f = this.getInertia();
			if (this.isInWater()) {
				for (int i = 0; i < 4; ++i) {
					this.level.addParticle(ParticleTypes.BUBBLE, d0 - vector3d.x * 0.25D, d1 - vector3d.y * 0.25D,
							d2 - vector3d.z * 0.25D, vector3d.x, vector3d.y, vector3d.z);
				}
				f = 0.8F;
			}
			this.setDeltaMovement(vector3d.add(this.xPower, this.yPower, this.zPower).scale((double) f));
			this.level.addParticle(this.getTrailParticle(), d0, d1 + 0.5D, d2, 0.0D, 0.0D, 0.0D);
			this.setPos(d0, d1, d2);
		} else {
			this.remove();
		}
	}

	protected boolean shouldBurn() {
		return false;
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean isNoGravity() {
		if (this.isInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
		super.onHitEntity(p_213868_1_);
		if (!this.level.isClientSide) {
			Entity entity = p_213868_1_.getEntity();
			Entity entity1 = this.getOwner();
			entity.hurt(DamageSource.mobAttack((LivingEntity) entity1), directHitDamage);
			if (entity1 instanceof LivingEntity) {
				this.doEnchantDamageEffects((LivingEntity) entity1, entity);
			}
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
	}

	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.level.isClientSide) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 1.0F,
				DoomConfig.SERVER.enable_block_breaking.get() ? Explosion.Mode.BREAK : Explosion.Mode.NONE);
	}

	public LivingEntity getShooter() {
		return shooter;
	}

	public void setShooter(LivingEntity shooter) {
		this.shooter = shooter;
	}

}