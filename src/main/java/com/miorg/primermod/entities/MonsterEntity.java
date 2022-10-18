package com.miorg.primermod.entities;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class MonsterEntity extends ShoulderRidingEntity implements RangedAttackMob { // CAMBIAR POR TAMABLEANIMAL Y QUITAR FLYINGANIMAL
    public MonsterEntity(EntityType<? extends ShoulderRidingEntity> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_); // CAMBIAR POR TAMABLEANIMAL
    }
    static final Map<EntityType<?>, SoundEvent> MOB_SOUND_MAP = Util.make(Maps.newHashMap(), (p_29398_) -> {
        p_29398_.put(EntityType.BLAZE, SoundEvents.PARROT_IMITATE_BLAZE);
        p_29398_.put(EntityType.CAVE_SPIDER, SoundEvents.PARROT_IMITATE_SPIDER);
        p_29398_.put(EntityType.CREEPER, SoundEvents.PARROT_IMITATE_CREEPER);
        p_29398_.put(EntityType.DROWNED, SoundEvents.PARROT_IMITATE_DROWNED);
        p_29398_.put(EntityType.ELDER_GUARDIAN, SoundEvents.PARROT_IMITATE_ELDER_GUARDIAN);
        p_29398_.put(EntityType.ENDER_DRAGON, SoundEvents.PARROT_IMITATE_ENDER_DRAGON);
        p_29398_.put(EntityType.ENDERMITE, SoundEvents.PARROT_IMITATE_ENDERMITE);
        p_29398_.put(EntityType.EVOKER, SoundEvents.PARROT_IMITATE_EVOKER);
        p_29398_.put(EntityType.GHAST, SoundEvents.PARROT_IMITATE_GHAST);
        p_29398_.put(EntityType.GUARDIAN, SoundEvents.PARROT_IMITATE_GUARDIAN);
        p_29398_.put(EntityType.HOGLIN, SoundEvents.PARROT_IMITATE_HOGLIN);
        p_29398_.put(EntityType.HUSK, SoundEvents.PARROT_IMITATE_HUSK);
        p_29398_.put(EntityType.ILLUSIONER, SoundEvents.PARROT_IMITATE_ILLUSIONER);
        p_29398_.put(EntityType.MAGMA_CUBE, SoundEvents.PARROT_IMITATE_MAGMA_CUBE);
        p_29398_.put(EntityType.PHANTOM, SoundEvents.PARROT_IMITATE_PHANTOM);
        p_29398_.put(EntityType.PIGLIN, SoundEvents.PARROT_IMITATE_PIGLIN);
        p_29398_.put(EntityType.PIGLIN_BRUTE, SoundEvents.PARROT_IMITATE_PIGLIN_BRUTE);
        p_29398_.put(EntityType.PILLAGER, SoundEvents.PARROT_IMITATE_PILLAGER);
        p_29398_.put(EntityType.RAVAGER, SoundEvents.PARROT_IMITATE_RAVAGER);
        p_29398_.put(EntityType.SHULKER, SoundEvents.PARROT_IMITATE_SHULKER);
        p_29398_.put(EntityType.SILVERFISH, SoundEvents.PARROT_IMITATE_SILVERFISH);
        p_29398_.put(EntityType.SKELETON, SoundEvents.PARROT_IMITATE_SKELETON);
        p_29398_.put(EntityType.SLIME, SoundEvents.PARROT_IMITATE_SLIME);
        p_29398_.put(EntityType.SPIDER, SoundEvents.PARROT_IMITATE_SPIDER);
        p_29398_.put(EntityType.STRAY, SoundEvents.PARROT_IMITATE_STRAY);
        p_29398_.put(EntityType.VEX, SoundEvents.PARROT_IMITATE_VEX);
        p_29398_.put(EntityType.VINDICATOR, SoundEvents.PARROT_IMITATE_VINDICATOR);
        p_29398_.put(EntityType.WARDEN, SoundEvents.PARROT_IMITATE_WARDEN);
        p_29398_.put(EntityType.WITCH, SoundEvents.PARROT_IMITATE_WITCH);
        p_29398_.put(EntityType.WITHER, SoundEvents.PARROT_IMITATE_WITHER);
        p_29398_.put(EntityType.WITHER_SKELETON, SoundEvents.PARROT_IMITATE_WITHER_SKELETON);
        p_29398_.put(EntityType.ZOGLIN, SoundEvents.PARROT_IMITATE_ZOGLIN);
        p_29398_.put(EntityType.ZOMBIE, SoundEvents.PARROT_IMITATE_ZOMBIE);
        p_29398_.put(EntityType.ZOMBIE_VILLAGER, SoundEvents.PARROT_IMITATE_ZOMBIE_VILLAGER);
    });
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0F, 3.0F, false)); // CAMBIAR A FALSE
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this)); // QUITAR
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Mob.class, 10, true, false, (p_29932_) -> {
            return p_29932_ instanceof Enemy;
        }));
    }

    // LO HACEMOS INVULNERABLE AL DAÑO

    @Override
    public boolean hurt (DamageSource damageSource, float floatArgument){
        return false;
    }

    public static AttributeSupplier.Builder getMonsterEntityAttrs(){
        return Mob.createMobAttributes().add(ForgeMod.ENTITY_GRAVITY.get(),1.5D).add(Attributes.MOVEMENT_SPEED,0.3D);
    }

    @Override

    // DOMABLE CON MANZANA DE ORO
    public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
        ItemStack itemstack = player.getItemInHand(interactionHand);
        if (itemstack.is(Items.GOLDEN_APPLE)) {
            this.customTamingParticles();
            this.tame(player);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    private void customTamingParticles() {
        ParticleOptions particleoptions = ParticleTypes.ELECTRIC_SPARK;

        for(int i = 0; i < 7; ++i){
            double d0 = this.random.nextGaussian() * 0.02D;
            double d1 = this.random.nextGaussian() * 0.02D;
            double d2 = this.random.nextGaussian() * 0.02D;
            this.level.addParticle(particleoptions, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity p_29912_, float p_29913_) {
        //Snowball snowball = new Snowball(this.level, this);
        Arrow arrow = new Arrow(this.level, this);
        double d0 = p_29912_.getEyeY() - (double)1.1F;
        double d1 = p_29912_.getX() - this.getX();
        double d2 = d0 - arrow.getY();
        double d3 = p_29912_.getZ() - this.getZ();
        double d4 = Math.sqrt(d1 * d1 + d3 * d3) * (double)0.2F;
        arrow.shoot(d1, d2 + d4, d3, 10.6F, 12.0F);
        this.playSound(SoundEvents.SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(arrow);
    }

    // SE PUEDE QUITAR
    public SoundEvent getAmbientSound() {
        return getAmbient(this.level, this.level.random);
    }

    public static SoundEvent getAmbient(Level p_218239_, RandomSource p_218240_) {
        if (p_218239_.getDifficulty() != Difficulty.PEACEFUL && p_218240_.nextInt(1000) == 0) {
            List<EntityType<?>> list = Lists.newArrayList(MOB_SOUND_MAP.keySet());
            return getImitatedSound(list.get(p_218240_.nextInt(list.size())));
        } else {
            return SoundEvents.OCELOT_AMBIENT;
        }
    }

    private static SoundEvent getImitatedSound(EntityType<?> p_29409_) {
        return MOB_SOUND_MAP.getOrDefault(p_29409_, SoundEvents.OCELOT_AMBIENT);
    }

    private static final Predicate<Mob> NOT_PARROT_PREDICATE = new Predicate<Mob>() {
        public boolean test(@Nullable Mob p_29453_) {
            return p_29453_ != null && MonsterEntity.MOB_SOUND_MAP.containsKey(p_29453_.getType());
        }
    };

    public static boolean imitateNearbyMobs(Level p_29383_, Entity p_29384_) {
        if (p_29384_.isAlive() && !p_29384_.isSilent() && p_29383_.random.nextInt(2) == 0) {
            List<Mob> list = p_29383_.getEntitiesOfClass(Mob.class, p_29384_.getBoundingBox().inflate(20.0D), NOT_PARROT_PREDICATE);
            if (!list.isEmpty()) {
                Mob mob = list.get(p_29383_.random.nextInt(list.size()));
                if (!mob.isSilent()) {
                    SoundEvent soundevent = getImitatedSound(mob.getType());
                    p_29383_.playSound((Player)null, p_29384_.getX(), p_29384_.getY(), p_29384_.getZ(), soundevent, p_29384_.getSoundSource(), 0.7F, getPitch(p_29383_.random));
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static float getPitch(RandomSource p_218237_) {
        return (p_218237_.nextFloat() - p_218237_.nextFloat()) * 0.2F + 1.0F;
    }

    public void aiStep(){
        if (this.level.random.nextInt(400) == 0) {
            imitateNearbyMobs(this.level, this);
        }
        super.aiStep();
    }

}
