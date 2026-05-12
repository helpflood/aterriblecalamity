package com.helpflood.calamity.items.custom;

import com.helpflood.calamity.blocks.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Properties;

import java.util.Map;

public class WitherEssenceExtractorItem extends Item {

    private static final Map<Block, Block> EXTRACT_MAP = Map.of(ModBlocks.WITHER_TUMOR.get(), ModBlocks.WITHER_FLESH.get());

    public WitherEssenceExtractorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(EXTRACT_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), EXTRACT_MAP.get(clickedBlock).defaultBlockState());

                level.playSound(null, context.getClickedPos(), SoundEvents.SLIME_ATTACK, SoundSource.BLOCKS);

            }
        }



        return InteractionResult.SUCCESS;
    }
}
