package dev.abidux.menus.block.custom.entity;

import dev.abidux.menus.MenusMod;
import dev.abidux.menus.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MenusMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<BoxBlockEntity>> BOX = BLOCK_ENTITIES.register("box", () ->
            BlockEntityType.Builder.of(BoxBlockEntity::new, ModBlocks.BOX.get()).build(null));

}