package com.gildedrose.items;

import com.gildedrose.Item;


public class InventoryItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static InventoryItem build(Item item) {
        InventoryItem inventoryItem;
        switch (item.name) {
            case AGED_BRIE:
                inventoryItem = new AgeBrie(item);
                break;
            case BACKSTAGE_PASSES:
                inventoryItem = new BackStagePasses(item);
                break;
            case SULFURAS:
                inventoryItem = new Sulfuras(item);
                break;
            default:
                inventoryItem = new NormalItem(item);
        }
        return inventoryItem;
    }
}
