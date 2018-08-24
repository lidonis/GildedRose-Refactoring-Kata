package com.gildedrose;

import com.gildedrose.items.InventoryItem;
import com.gildedrose.items.InventoryItemFactory;

import java.util.stream.Stream;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Stream.of(items).map(InventoryItemFactory::build).forEach(InventoryItem::update);
    }

}