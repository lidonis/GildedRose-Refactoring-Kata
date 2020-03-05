package com.gildedrose.classifier.rulebased;

import com.gildedrose.Item;
import com.gildedrose.classifier.TypedItem.ItemType;
import java.util.function.Predicate;

class ItemTypeRule {

  private final Predicate<Item> predicate;
  private final ItemType itemType;

  static ItemTypeRule byName(String name,
      ItemType itemType) {
    return new ItemTypeRule(byNamePredicate(name), itemType);
  }

  static ItemTypeRule byPrefix(String prefix,
      ItemType itemType) {
    return new ItemTypeRule(prefixPredicate(prefix), itemType);
  }

  private ItemTypeRule(Predicate<Item> predicate,
      ItemType itemType) {
    this.predicate = predicate;
    this.itemType = itemType;
  }

  Predicate<Item> getPredicate() {
    return predicate;
  }

  private static Predicate<Item> byNamePredicate(String name) {
    return item -> name.equals(item.name);
  }

  private static Predicate<Item> prefixPredicate(String prefix) {
    return item -> item.name.startsWith(prefix);
  }

  ItemType getItemType() {
    return itemType;
  }
}