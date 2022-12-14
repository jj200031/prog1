package net.jever.prog1.item;

import net.jever.prog1.prog1;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryManager;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, prog1.MOD_ID);

    public static final RegistryObject<Item> STILL = ITEMS.register("still",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TMW_TAB)));

    public static final RegistryObject<Item> COAL_COOK = ITEMS.register("coal_cook",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TMW_TAB)));

    public static final RegistryObject<Item> TMWLOGO = ITEMS.register("tmw_logo",
            ()->new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


}
