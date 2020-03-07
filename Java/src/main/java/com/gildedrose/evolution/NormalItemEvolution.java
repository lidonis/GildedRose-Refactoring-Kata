package com.gildedrose.evolution;

import com.gildedrose.Item;

public class NormalItemEvolution extends AbstractItemEvolution {

  NormalItemEvolution(Item item) {
    super(item);
  }

  @Override
  void mandatoryUpdate() {
    decreaseQuality();
  }

  @Override
  void updateIfExpired() {
    decreaseQuality();
  }

}
