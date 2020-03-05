package com.gildedrose.evolution;

import com.gildedrose.Item;
import com.gildedrose.classifier.TypedItem;
import com.gildedrose.classifier.TypedItem.ItemType;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public class ItemEvolutionChooser {

  private static final Map<ItemType, Function<Item, ItemEvolution>> associations;

  static {
    associations = new EnumMap<>(ItemType.class);
    associations.put(ItemType.LEGENDARY, LegendaryEvolution::new);
    associations.put(ItemType.CHEESE, CheeseEvolution::new);
    associations.put(ItemType.BACKSTAGE_PASSES, BackstagePassesEvolution::new);
    associations.put(ItemType.CONJURED, ConjuredEvolution::new);
  }

  private ItemEvolutionChooser() {
  }

  public static ItemEvolution decide(TypedItem typedItem) {
    Function<Item, ItemEvolution> behaviour = associations
        .getOrDefault(typedItem.getItemType(), ItemEvolution::new);
    return behaviour.apply(typedItem.getItem());
  }
}
