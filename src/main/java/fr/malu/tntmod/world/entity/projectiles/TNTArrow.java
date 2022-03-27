package fr.malu.tntmod.world.entity.projectiles;

import fr.malu.tntmod.item.ModItems;
import fr.malu.tntmod.world.entity.ModEntityType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class TNTArrow extends AbstractArrow {

    private int explosionPower = 2;

    private final Item referenceItem;

    public TNTArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.TNT_ARROW.get();
    }

    public TNTArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.TNT_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
        if(shooter.getItemInHand(InteractionHand.MAIN_HAND).getItem() == Items.TNT) {
        }else if(shooter.getItemInHand(InteractionHand.OFF_HAND).getItem() == ModItems.TNT_BOW.get() || shooter.getItemInHand(InteractionHand.MAIN_HAND).getItem() == ModItems.TNT_BOW.get()) {
            this.explosionPower = 4;
        }
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
        if (!this.level.isClientSide) {
            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.getOwner());
            this.level.explode((Entity)null, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, flag, flag ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE);
            this.discard();
        }

    }

    /**
     * Called when the arrow hits an entity
     */
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level.isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            entity.hurt(DamageSource.arrow(this, entity1), 6.0F);
            if (entity1 instanceof LivingEntity) {
                this.doEnchantDamageEffects((LivingEntity)entity1, entity);
            }

        }
    }

}
