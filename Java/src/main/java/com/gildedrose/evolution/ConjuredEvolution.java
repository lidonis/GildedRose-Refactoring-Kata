package com.gildedrose.evolution;

import com.gildedrose.Item;

class ConjuredEvolution extends NormalItemEvolution {

  ConjuredEvolution(Item item) {
    super(item);
  }

  @Override
  protected void mandatoryUpdate() {
    super.mandatoryUpdate();
    super.mandatoryUpdate();
  }

  @Override
  protected void updateIfExpired() {
    super.updateIfExpired();
    super.updateIfExpired();
  }

}
