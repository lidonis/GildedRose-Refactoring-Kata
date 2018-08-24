package com.gildedrose.items;

import com.gildedrose.Item;

public class NormalItem extends InventoryItem {

    NormalItem(Item item) {
        super(item);
    }

    public void update() {
        if (isQualityAbove0()) {
            decreaseQuality();
        }
        decreaseSellIn();
        if (isQualityAbove0() && isSellInNegative()) {
            decreaseQuality();
        }
    }
}
