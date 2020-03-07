package com.gildedrose.evolution;

import com.gildedrose.Item;

class BackstagePassesEvolution extends AbstractItemEvolution {

  BackstagePassesEvolution(Item item) {
    super(item);
  }

  @Override
  protected void mandatoryUpdate() {
    increaseQuality();

    if (isConcertClose()) {
      increaseQuality();
    }

    if (isConcertVeryClose()) {
      increaseQuality();
    }
  }

  @Override
  protected void updateIfExpired() {
    qualityDropsToZero();
  }

  private boolean isConcertClose() {
    return sellInLessThan(10);
  }

  private boolean isConcertVeryClose() {
    return sellInLessThan(5);
  }

}
