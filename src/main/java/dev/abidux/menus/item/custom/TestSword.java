package dev.abidux.menus.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class TestSword extends SwordItem {
    public TestSword() {
        super(Tiers.NETHERITE, 7, .2f, new Item.Properties());
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeRemaining) {
        if (level.isClientSide()) return;
        int chargedFor = getUseDuration(stack) - timeRemaining;
        if (chargedFor >= 10) { // if player holds for at least half a second
            ServerPlayer player = (ServerPlayer) entity;
            List<Monster> monsters = level.getNearbyEntities(Monster.class, TargetingConditions.forCombat(), player, player.getBoundingBox().inflate(5));
            monsters.forEach(m -> m.hurt(m.damageSources().magic(), 5));
            System.out.println(monsters.size() + " monsters within 5 blocks radius");
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }
}