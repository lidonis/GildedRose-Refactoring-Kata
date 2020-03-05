package com.gildedrose.evolution;

import com.gildedrose.Item;

public class ItemEvolution {

  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;

  private final Item item;

  ItemEvolution(Item item) {
    this.item = item;
  }

  public void updateItem() {
    nextDay();
    mandatoryUpdate();
    if (isExpired()) {
      updateIfExpired();
    }
  }

  void mandatoryUpdate() {
    decreaseQuality();
  }

  void updateIfExpired() {
    decreaseQuality();
  }

  void increaseQuality() {
    if (item.quality < MAX_QUALITY) {
      item.quality++;
    }
  }

  void decreaseQuality() {
    if (item.quality > MIN_QUALITY) {
      item.quality--;
    }
  }

  void nextDay() {
    item.sellIn--;
  }

  boolean isExpired() {
    return item.sellIn < 0;
  }

  void qualityDropsToZero() {
    item.quality = 0;
  }

  boolean sellInLessThan(int days) {
    return item.sellIn < days;
  }

}
