package dev.abidux.menus.gui;

import dev.abidux.menus.block.ModBlocks;
import dev.abidux.menus.block.custom.entity.BoxBlockEntity;
import dev.abidux.menus.slot.CustomResultSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class BoxBlockMenu extends AbstractContainerMenu {
    public final BoxBlockEntity blockEntity;
    public BoxBlockMenu(int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public BoxBlockMenu(int containerId, Inventory inventory, BlockEntity blockEntity) {
        super(ModMenuTypes.BOX_MENU.get(), containerId);
        this.blockEntity = (BoxBlockEntity) blockEntity;

        addPlayerHotbar(inventory);
        addPlayerInventory(inventory);
        addBoxSlots();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(player.level(), blockEntity.getBlockPos()), player, ModBlocks.BOX.get());
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlot(new Slot(inventory, y*9+x+9, 8+x*18, 84+y*18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inventory) {
        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    private void addBoxSlots() {
        blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    addSlot(new SlotItemHandler(handler, x+y*3, 30 + 18*x, 17 + 18*y));
                }
            }
            addSlot(new CustomResultSlot(handler, 9, 124, 35));
        });
    }
}