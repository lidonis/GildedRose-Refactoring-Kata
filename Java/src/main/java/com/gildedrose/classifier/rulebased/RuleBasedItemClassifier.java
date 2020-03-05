package com.gildedrose.classifier.rulebased;

import static com.gildedrose.classifier.rulebased.ItemTypeRule.byName;
import static com.gildedrose.classifier.rulebased.ItemTypeRule.byPrefix;

import com.gildedrose.Item;
import com.gildedrose.classifier.ItemClassifier;
import com.gildedrose.classifier.TypedItem;
import com.gildedrose.classifier.TypedItem.ItemType;
import java.util.ArrayList;
import java.util.List;

public class RuleBasedItemClassifier implements ItemClassifier {

  private static final String AGED_BRIE = "Aged Brie";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES_PREFIX = "Backstage passes to ";
  private static final String CONJURED_ITEM_PREFIX = "Conjured ";

  public static RuleBasedItemClassifier withDefaultRules() {
    List<ItemTypeRule> rules = new ArrayList<>();
    rules.add(byName(SULFURAS, ItemType.LEGENDARY));
    rules.add(byName(AGED_BRIE, ItemType.CHEESE));
    rules.add(byPrefix(BACKSTAGE_PASSES_PREFIX, ItemType.BACKSTAGE_PASSES));
    rules.add(byPrefix(CONJURED_ITEM_PREFIX, ItemType.CONJURED));
    return new RuleBasedItemClassifier(rules);
  }

  private final List<ItemTypeRule> rules;

  public RuleBasedItemClassifier(List<ItemTypeRule> rules) {
    this.rules = rules;
  }

  @Override
  public TypedItem categorize(Item item) {
    ItemType itemType = rules.stream()
        .filter(s -> s.getPredicate().test(item)).findFirst()
        .map(ItemTypeRule::getItemType)
        .orElse(ItemType.NORMAL);
    return new TypedItem(itemType, item);
  }

}
