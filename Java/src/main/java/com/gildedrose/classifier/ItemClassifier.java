package com.gildedrose.classifier;

import com.gildedrose.Item;

public interface ItemClassifier {

  TypedItem categorize(Item item);
}
