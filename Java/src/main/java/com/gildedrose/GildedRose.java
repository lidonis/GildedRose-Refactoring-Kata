package com.gildedrose;

import com.gildedrose.classifier.ItemClassifier;
import com.gildedrose.classifier.rulebased.RuleBasedItemClassifier;
import com.gildedrose.evolution.ItemEvolution;
import com.gildedrose.evolution.ItemEvolutionChooser;
import java.util.Arrays;

class GildedRose {

  Item[] items;
  private final ItemClassifier itemClassifier;

  public GildedRose(Item[] items) {
    this.items = items;
    this.itemClassifier = RuleBasedItemClassifier.withDefaultRules();
  }

  public void updateQuality() {
    Arrays.stream(items)
        .map(itemClassifier::categorize)
        .map(ItemEvolutionChooser::decide)
        .forEach(ItemEvolution::updateItem);
  }

}