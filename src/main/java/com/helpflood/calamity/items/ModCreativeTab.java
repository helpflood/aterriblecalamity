package com.helpflood.calamity.items;

import com.helpflood.calamity.ATerribleCalamity;
import com.helpflood.calamity.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ATerribleCalamity.MODID);

    public static final Supplier<CreativeModeTab> ATC_CTAB = CREATIVE_MODE_TAB.register("atc_ctab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.WITHER_FLESH.get()))
                    .title(Component.translatable("creative.atc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WITHEREDSTICK);
                        output.accept(ModItems.WITHEREDBONE);
                        output.accept(ModItems.WITHER_ESSENCE);
                        output.accept(ModItems.AMULET);
                        output.accept(ModItems.WITHERED_NETHER_STAR);
                        output.accept(ModBlocks.REDSTONE_HEART);
                        output.accept(ModBlocks.WITHER_FLESH);
                        output.accept(ModBlocks.WITHER_TUMOR);
                        output.accept(ModBlocks.WITHER_DIRT);
                        output.accept(ModBlocks.WITHERED_STONE);
                        output.accept(ModBlocks.WITHERED_GRAVEL);
                        output.accept(ModBlocks.WITHERED_OAK_PLANKS);
                        output.accept(ModBlocks.WITHERED_ACACIA_PLANKS);
                        output.accept(ModItems.WITHER_ESSENCE_EXTRACTOR);
                    })
            .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
