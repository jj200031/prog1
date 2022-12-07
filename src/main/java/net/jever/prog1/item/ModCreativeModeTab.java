package net.jever.prog1.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.units.qual.C;

public class ModCreativeModeTab {
    public static final CreativeModeTab TMW_TAB = new CreativeModeTab("tmwtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TMWLOGO.get());
        }
    };
}
