package com.gildedrose.items;

import com.gildedrose.Item;

class AgeBrie extends InventoryItem {

    AgeBrie(Item item) {
        super(item);
    }

    public void update() {
        if (isQualityBelow50()) {
            increaseQuality();
        }
        decreaseSellIn();
        if (isQualityBelow50() && isSellInNegative()) {
            increaseQuality();
        }
    }
}
