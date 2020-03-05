package com.gildedrose.evolution;

import com.gildedrose.Item;

class LegendaryEvolution extends ItemEvolution {

  LegendaryEvolution(Item item) {
    super(item);
  }

  @Override
  public void updateItem() {
    // A legendary item never changes
  }

}
