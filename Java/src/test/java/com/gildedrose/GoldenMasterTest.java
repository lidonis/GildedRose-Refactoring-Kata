package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

public class GoldenMasterTest {

  @Test
  public void testUpdateQuality() {
    String[] itemNames = {"+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose",
        "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
        "Conjured Mana Cake"};
    Integer[] sellIns = {-1, 0, 2, 5, 10, 15};
    Integer[] qualities = {0, 1, 7, 20, 49, 50};
    CombinationApprovals.verifyAllCombinations(this::updateQuality,
        itemNames, sellIns, qualities);
  }

  private Object updateQuality(String name, int sellIn, int quality) {
    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();
    return items[0];
  }

}
