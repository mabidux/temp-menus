package dev.abidux.menus.item;

import dev.abidux.menus.MenusMod;
import dev.abidux.menus.block.ModBlocks;
import dev.abidux.menus.item.custom.TestSword;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MenusMod.MOD_ID);

    public static final RegistryObject<Item> BOX = ITEMS.register("box", () -> new BlockItem(ModBlocks.BOX.get(), new Item.Properties()));

    public static final RegistryObject<Item> TEST_SWORD = ITEMS.register("test_sword", TestSword::new);

}