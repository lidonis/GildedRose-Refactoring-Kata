package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldenMaster {

    @Test
    public void compareToOldVersion() {
        GildedRose gildedRose = new GildedRose(getItems());
        LegacyGildedRose legacyGildedRose = new LegacyGildedRose(getItems());

        for (int i = 0; i < 100; i++) {
            assertThat(gildedRose.items).usingFieldByFieldElementComparator().containsExactly(legacyGildedRose.items);
            gildedRose.updateQuality();
            legacyGildedRose.updateQuality();
        }
    }

    private Item[] getItems() {
        return new Item[] {
                    new Item("+5 Dexterity Vest", 10, 20), //
                    new Item("Aged Brie", 2, 0), //
                    new Item("Elixir of the Mongoose", 5, 7), //
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    // this conjured item does not work properly yet
                    new Item("Conjured Mana Cake", 3, 6) };
    }
}
