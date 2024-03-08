package com.gildedrose

import kotlin.reflect.KFunction3

class GildedRose(var items: List<Item>) {

    // We are not allowed to modify the item class nor the list of items passed.
    // We do however like having the 'tick' logic for each possible item in their appropriate class.
    // We accomplish this by mapping the possible names to constructors for the specific subclasses
    // and then modifying the original items by reference.
    private val itemClassMap: Map<String, KFunction3<String, Int, Int, TickableItem>> = mapOf(
        "Aged Brie" to ::AgedBrie,
        "Backstage passes to a TAFKAL80ETC concert" to ::BackstagePass,
        "Sulfuras, Hand of Ragnaros" to ::Sulfuras,
        "Conjured" to ::Conjured
    )

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            val tickableItem = createTickableItem(item)
            tickableItem.tick()
            item.updateInPlace(tickableItem)
        }
    }

    private fun createTickableItem(item: Item): TickableItem {
        val constructorForItem = itemClassMap.getOrDefault(item.name, ::RegularItem)
        val tickableItem = constructorForItem.invoke(item.name, item.sellIn, item.quality)
        return tickableItem
    }

    fun Item.updateInPlace(other: TickableItem) {
        quality = other.quality;
        name = other.name;
        sellIn = other.sellIn
    }

}

