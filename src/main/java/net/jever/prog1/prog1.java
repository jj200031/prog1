package net.jever.prog1;

import com.mojang.logging.LogUtils;
import net.jever.prog1.block.ModBlocks;
import net.jever.prog1.block.entity.ModBockEntities;
import net.jever.prog1.item.ModItems;
import net.jever.prog1.screen.ModMenuTypes;
import net.jever.prog1.screen.StillSmelteryInerface.StillSmelteryScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(prog1.MOD_ID)
public class prog1 {
    public static final String MOD_ID = "prog1";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public prog1() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModBockEntities.register(eventBus);

        ModMenuTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourslves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.STILL_SMELTERY_MENU.get(), StillSmelteryScreen::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }
}