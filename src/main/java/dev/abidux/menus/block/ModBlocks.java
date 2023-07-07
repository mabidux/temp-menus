package dev.abidux.menus.block;

import dev.abidux.menus.MenusMod;
import dev.abidux.menus.block.custom.BoxBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MenusMod.MOD_ID);

    public static final RegistryObject<Block> BOX = BLOCKS.register("box", BoxBlock::new);

}