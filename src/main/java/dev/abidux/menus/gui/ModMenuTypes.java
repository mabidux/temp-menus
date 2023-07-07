package dev.abidux.menus.gui;

import dev.abidux.menus.MenusMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MenusMod.MOD_ID);

    public static final RegistryObject<MenuType<BoxBlockMenu>> BOX_MENU = MENU_TYPES.register("box_menu",
            () -> IForgeMenuType.create(BoxBlockMenu::new));

}