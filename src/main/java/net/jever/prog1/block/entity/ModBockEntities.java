package net.jever.prog1.block.entity;

import net.jever.prog1.block.ModBlocks;
import net.jever.prog1.block.entity.custom.StillSmelteryBlockEntity;
import net.jever.prog1.prog1;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, prog1.MOD_ID);

    public static final RegistryObject<BlockEntityType<StillSmelteryBlockEntity>> STILL_SMELTERY_BLOCK_ENTITY =
            BLOCK_ENTITY.register("still_smeltery_block_entity", () ->
                    BlockEntityType.Builder.of(StillSmelteryBlockEntity::new,
                            ModBlocks.STILL_SMELTERY.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY.register(eventBus);
    }
}
