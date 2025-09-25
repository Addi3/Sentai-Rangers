package com.addie.core;

import com.addie.core.Items.DinoBucklerItem;
import dev.amble.lib.container.impl.ItemContainer;
import dev.amble.lib.datagen.util.NoEnglish;
import dev.amble.lib.item.AItemSettings;
import net.minecraft.item.Item;

public class SentaiRangersItems extends ItemContainer {

    @NoEnglish
    public static final Item DINO_BUCKLER = new DinoBucklerItem(new AItemSettings());
}
