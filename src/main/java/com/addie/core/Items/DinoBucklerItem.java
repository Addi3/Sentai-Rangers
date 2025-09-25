package com.addie.core.Items;

import com.addie.core.SentaiRangersSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DinoBucklerItem extends Item {
    public DinoBucklerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            world.playSound(
                    null,
                    user.getX(), user.getY(), user.getZ(),
                    SentaiRangersSounds.ZYURANGER,
                    SoundCategory.PLAYERS,
                    1.0F,
                    1.0F
            );

            var server = user.getServer();
            if (server != null) {
                var commandManager = server.getCommandManager();

                ServerCommandSource silentSource = new ServerCommandSource(
                        user,
                        user.getPos(),
                        user.getRotationClient(),
                        user.getWorld() instanceof net.minecraft.server.world.ServerWorld sw ? sw : null,
                        4,
                        user.getName().getString(),
                        Text.literal(user.getName().getString()),
                        server,
                        user
                ).withSilent();

                commandManager.executeWithPrefix(
                        silentSource,
                        "amblekit animation @p zyuranger_change:zyuranger_change"
                );
            }
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, stack);
    }
}
