package com.gildedrose.evolution;

import com.gildedrose.Item;

abstract class AbstractItemEvolution implements ItemEvolution {

  private static final int MAX_QUALITY = 50;
  private static final int MIN_QUALITY = 0;

  private final Item item;

  AbstractItemEvolution(Item item) {
    this.item = item;
  }

  @Override
  public final void updateItem() {
    nextDay();
    mandatoryUpdate();
    if (isExpired()) {
      updateIfExpired();
    }
  }

  abstract void mandatoryUpdate();

  abstract void updateIfExpired();

  final void increaseQuality() {
    if (item.quality < MAX_QUALITY) {
      item.quality++;
    }
  }

  final void decreaseQuality() {
    if (item.quality > MIN_QUALITY) {
      item.quality--;
    }
  }

  final void nextDay() {
    item.sellIn--;
  }

  final boolean isExpired() {
    return item.sellIn < 0;
  }

  final void qualityDropsToZero() {
    item.quality = 0;
  }

  final boolean sellInLessThan(int days) {
    return item.sellIn < days;
  }

}
