package com.gildedrose.classifier;

import com.gildedrose.Item;

public class TypedItem {
  private final ItemType itemType;
  private final Item item;

  public TypedItem(ItemType itemType, Item item) {
    this.itemType = itemType;
    this.item = item;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public Item getItem() {
    return item;
  }

  public enum ItemType {
    CHEESE, BACKSTAGE_PASSES, CONJURED, NORMAL, LEGENDARY
  }
}
