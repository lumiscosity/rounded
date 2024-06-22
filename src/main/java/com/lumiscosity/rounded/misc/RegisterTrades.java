package com.lumiscosity.rounded.misc;

import com.lumiscosity.rounded.blocks.RegisterBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.TradeOffers;

public class RegisterTrades {
    public static void initTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    new TradeOffers.SellItemFactory(RegisterBlocks.LUSTERSHROON_PLANT_ITEM, 1, 1, 12, 1);
                });
    }
}
