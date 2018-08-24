package com.gildedrose.items;

import com.gildedrose.Item;

public class BackStagePasses extends InventoryItem {

    BackStagePasses(Item item) {
        super(item);
    }

    public void update() {
        if (isQualityBelow50()) {
            increaseQuality();

            if (isSellInBelow(11)) {
                if (isQualityBelow50()) {
                    increaseQuality();
                }
            }

            if (isSellInBelow(6)) {
                if (isQualityBelow50()) {
                    increaseQuality();
                }
            }
        }
        decreaseSellIn();
        if(isSellInNegative()) {
            setQualityTo0();
        }
    }
}
