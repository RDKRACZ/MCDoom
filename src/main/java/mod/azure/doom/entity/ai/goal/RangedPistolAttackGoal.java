package mod.azure.doom.entity.ai.goal;

import java.util.EnumSet;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.item.weapons.PistolItem;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.projectile.ProjectileHelper;

public class RangedPistolAttackGoal<T extends CreatureEntity & IRangedAttackMob> extends Goal {
	private final DemonEntity entity;
	private final double moveSpeedAmp;
	private int attackCooldown;
	private int attackTime = -1;
	private int seeTime;
	private int statecheck;

	public RangedPistolAttackGoal(DemonEntity mob, double moveSpeedAmpIn, int attackCooldownIn,
			float maxAttackDistanceIn, int state) {
		this.entity = mob;
		this.moveSpeedAmp = moveSpeedAmpIn;
		this.attackCooldown = attackCooldownIn;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		this.statecheck = state;
	}

	public void setAttackCooldown(int attackCooldownIn) {
		this.attackCooldown = attackCooldownIn;
	}

	public boolean canUse() {
		return this.entity.getTarget() == null ? false : this.isBowInMainhand();
	}

	protected boolean isBowInMainhand() {
		return this.entity.getMainHandItem().getItem() instanceof PistolItem
				|| this.entity.getOffhandItem().getItem() instanceof PistolItem;
	}

	public boolean canContinueToUse() {
		return (this.canUse() || !this.entity.getNavigation().isDone()) && this.isBowInMainhand();
	}

	public void start() {
		super.start();
		this.entity.setAggressive(true);
		this.entity.setAttackingState(0);
	}

	public void stop() {
		super.stop();
		this.entity.setAggressive(false);
		this.seeTime = 0;
		this.attackTime = -1;
		this.entity.stopUsingItem();
		this.entity.setAttackingState(0);
	}

	public void tick() {
		LivingEntity livingentity = this.entity.getTarget();
		if (livingentity != null) {
			boolean flag = this.entity.getSensing().canSee(livingentity);
			boolean flag1 = this.seeTime > 0;
			if (flag != flag1) {
				this.seeTime = 0;
			}

			if (flag) {
				++this.seeTime;
			} else {
				--this.seeTime;
			}

			this.entity.getNavigation().moveTo(livingentity, this.moveSpeedAmp);
			this.entity.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
			double d0 = this.entity.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());

			if (this.entity.isUsingItem()) {
				if (!flag && this.seeTime < -60) {
					this.entity.stopUsingItem();
				} else if (flag) {
					int i = this.entity.getTicksUsingItem();
					if (i >= 19) {
						this.entity.setAttackingState(statecheck);
					}
					if (i >= 20) {
						this.entity.stopUsingItem();
						((IRangedAttackMob) this.entity).performRangedAttack(livingentity,
								PistolItem.getArrowVelocity(i));
						this.attackTime = this.attackCooldown;
					}
				}
			} else if (--this.attackTime <= 0 && this.seeTime >= -60) {
				this.checkAndPerformAttack(livingentity, d0);
				this.entity.startUsingItem(ProjectileHelper.getWeaponHoldingHand(this.entity, DoomItems.PISTOL.get()));
			}

		}
	}

	protected void checkAndPerformAttack(LivingEntity livingentity, double squaredDistance) {
		double d0 = this.getAttackReachSqr(livingentity);
		if (squaredDistance <= d0) {
			this.attackTime = 20;
			this.entity.setAttackingState(1);
			this.entity.doHurtTarget(livingentity);
		}
	}

	protected double getAttackReachSqr(LivingEntity attackTarget) {
		return (double) (this.entity.getBbWidth() * 2.0F * this.entity.getBbWidth() * 2.0F + attackTarget.getBbWidth());
	}
}