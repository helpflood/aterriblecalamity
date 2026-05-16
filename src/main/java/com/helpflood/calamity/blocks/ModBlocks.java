package com.helpflood.calamity.blocks;

import com.helpflood.calamity.ATerribleCalamity;
import com.helpflood.calamity.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.redstone.Redstone;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ATerribleCalamity.MODID);

    //block registry start

    public static final DeferredBlock<Block> WITHER_DIRT = registerBlock("wither_dirt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).sound(SoundType.MUD)));

    public static final DeferredBlock<Block> WITHERED_GRAVEL = registerBlock("withered_gravel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.9f).sound(SoundType.MANGROVE_ROOTS)));

    public static final DeferredBlock<Block> WITHER_FLESH = registerBlock("wither_flesh",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.7f).sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> WITHER_TUMOR = registerBlock("wither_tumor",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.SPONGE)));

    public static final DeferredBlock<Block> WITHER_PHLEGM = registerBlock("wither_phlegm",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.SAND).liquid()));

    public static final DeferredBlock<Block> WITHERED_STONE = registerBlock("withered_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.5f).sound(SoundType.TUFF_BRICKS).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> WITHERED_OAK_PLANKS = registerBlock("withered_oak_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.3f).sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> WITHERED_ACACIA_PLANKS = registerBlock("withered_acacia_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.3f).sound(SoundType.FUNGUS)));

    public static final DeferredBlock<Block> REDSTONE_HEART = registerBlock("redstone_heart",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> CORRUPTED_COMMAND_BLOCK = registerBlock("corrupted_command_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10f).sound(SoundType.METAL)));

    //block registry end


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
