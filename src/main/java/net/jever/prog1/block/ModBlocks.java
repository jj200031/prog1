package net.jever.prog1.block;

import net.jever.prog1.block.custom.cook_smeltery;
import net.jever.prog1.block.custom.still_smeltery;
import net.jever.prog1.item.ModCreativeModeTab;
import net.jever.prog1.item.ModItems;
import net.jever.prog1.prog1;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, prog1.MOD_ID);

    public static final RegistryObject<Block> STILL_BLOCK = registerBlock("still_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.TMW_TAB);
    public static final RegistryObject<Block> COAL_COOK_BLOCK = registerBlock("coal_cook_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.TMW_TAB);


    public static final RegistryObject<Block> STILL_SMELTERY = registerBlock("still_smeltery",
            () -> new still_smeltery(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            ModCreativeModeTab.TMW_TAB);

    public static final RegistryObject<Block> COOK_SMELTERY = registerBlock("cook_smeltery",
            () -> new cook_smeltery(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()),
            ModCreativeModeTab.TMW_TAB);





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));

    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
