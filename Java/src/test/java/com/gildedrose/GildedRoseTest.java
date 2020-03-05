package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void conjuredItemShouldDegradeInQualityTwiceAsFastAsNormalItem() {
        Item[] items = new Item[] { new Item("Conjured Item", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality);
    }

    @Test
    void expiredConjuredItemShouldDegradeInQualityTwiceAsFastAsNormalExpiredItem() {
        Item[] items = new Item[] { new Item("Conjured Item", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, items[0].quality);
    }
}
