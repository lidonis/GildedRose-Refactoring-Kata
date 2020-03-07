package com.gildedrose.evolution;

import com.gildedrose.Item;

class BackstagePassesEvolution extends AbstractItemEvolution {

  private static final int DAYS_TO_CLOSE_CONCERT = 10;
  private static final int DAYS_TO_VERY_CLOSE_CONCERT = 5;

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
    qualityDropsToMinimum();
  }

  private boolean isConcertClose() {
    return sellInLessThan(DAYS_TO_CLOSE_CONCERT);
  }

  private boolean isConcertVeryClose() {
    return sellInLessThan(DAYS_TO_VERY_CLOSE_CONCERT);
  }

}
