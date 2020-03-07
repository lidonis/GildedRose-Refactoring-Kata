
package com.gildedrose.evolution;

import com.gildedrose.Item;

public class CheeseEvolution extends AbstractItemEvolution {

  CheeseEvolution(Item item) {
    super(item);
  }

  @Override
  protected void mandatoryUpdate() {
    increaseQuality();
  }

  @Override
  protected void updateIfExpired() {
    increaseQuality();
  }

}
