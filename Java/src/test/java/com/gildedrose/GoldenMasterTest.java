package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.combinations.SkipCombination;
import org.junit.jupiter.api.Test;

public class GoldenMasterTest {

  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  @Test
  public void testUpdate() {
    String[] itemNames = {"+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose",
        SULFURAS, "Backstage passes to a TAFKAL80ETC concert",
        "Conjured Mana Cake"};
    Integer[] sellIns = {-5, -1, 0, 2, 5, 10, 15};
    Integer[] qualities = {0, 1, 7, 20, 49, 50, 80};
    CombinationApprovals.verifyAllCombinations(this::updateItem,
        itemNames, sellIns, qualities);
  }

  private Object updateItem(String name, int sellIn, int quality) {
    if ((SULFURAS.equals(name) && (quality != 80)) || (!SULFURAS.equals(name) && (quality == 80))) {
      throw new SkipCombination();
    }

    Item[] items = new Item[]{new Item(name, sellIn, quality)};
    GildedRose gildedRose = new GildedRose(items);
    gildedRose.updateQuality();
    return items[0];
  }

}
