package com.gildedrose;

class GildedRose {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";
  private static final int MAX_QUALITY = 50;
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItem(item);
    }
  }

  private void updateItem(Item item) {
    if (item.name.equals(SULFURAS_HAND)) {
      return;
    }

    decreaseSellIn(item);


    if (item.name.equals(BACKSTAGE_PASSES)) {
      updateBackstage(item);
    }

    if (item.name.equals(AGED_BRIE)) {
      updateAgedBrie(item);
    }

    if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES)) {
      updateNormalItem(item);
    }
  }

  private void updateNormalItem(Item item) {
    decreaseQuality(item);
    if (isExpired(item)) {
      decreaseQuality(item);
    }
  }

  private void updateAgedBrie(Item item) {
    increaseQuality(item);
    if (isExpired(item) && item.name.equals(AGED_BRIE)) {
      increaseQuality(item);
    }
  }

  private void updateBackstage(Item item) {
    increaseQuality(item);
    if (item.sellIn < 10) {
      increaseQuality(item);
    }

    if (item.sellIn < 5) {
      increaseQuality(item);
    }

    if (isExpired(item) && item.name.equals(BACKSTAGE_PASSES)) {
      item.quality = 0;
    }
  }

  private boolean isExpired(Item item) {
    return item.sellIn < 0;
  }

  private void decreaseQuality(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }

  private void decreaseSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  private void increaseQuality(Item item) {
    if (item.quality < MAX_QUALITY) {
      item.quality = item.quality + 1;
    }
  }
}