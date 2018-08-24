package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class InventoryItem {

    private final Item item;

    InventoryItem(Item item) {
        this.item = item;
    }

    public abstract void update();

    boolean isQualityAbove0() {
        return item.quality > 0;
    }

    void decreaseQuality() {
        item.quality--;
    }

    void decreaseSellIn() {
        item.sellIn--;
    }

    boolean isSellInNegative() {
        return isSellInBelow(0);
    }

    boolean isQualityBelow50() {
        return item.quality < 50;
    }

    void increaseQuality() {
        item.quality++;
    }

    void setQualityTo0() {
        item.quality = 0;
    }

    boolean isSellInBelow(int limit){
        return item.sellIn < limit;
    }
}
