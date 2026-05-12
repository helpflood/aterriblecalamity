package com.helpflood.calamity.items;

import com.helpflood.calamity.ATerribleCalamity;
import com.helpflood.calamity.items.custom.WitherEssenceExtractorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.math.IEEE754rUtils;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ATerribleCalamity.MODID);

    public static final DeferredItem<Item> WITHEREDSTICK = ITEMS.register("witheredstick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WITHEREDBONE = ITEMS.register("witheredbone",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WITHER_ESSENCE = ITEMS.register("wither_essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WITHER_ESSENCE_EXTRACTOR = ITEMS.register("wither_essence_extractor",
            () -> new WitherEssenceExtractorItem(new Item.Properties()));

    public static final DeferredItem<Item> WITHERED_NETHER_STAR = ITEMS.register("withered_nether_star",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> AMULET = ITEMS.register("amulet",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
