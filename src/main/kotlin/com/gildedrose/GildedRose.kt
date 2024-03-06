package com.gildedrose

import kotlin.reflect.KFunction1

class GildedRose(var items: List<Item>) {

    private val itemClassMap: Map<String, KFunction1<Item, TickableItem>> = mapOf(
        "Aged Brie" to ::AgedBrie,
        "Backstage passes to a TAFKAL80ETC concert" to ::BackstagePass,
        "Sulfuras, Hand of Ragnaros" to ::Sulfuras,
    )

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            tick(item)
        }
    }

    private fun tick(item: Item) {
        val tickableItem = createTickableItem(item)
        tickableItem.tick()
        item.updateUsing(tickableItem)
    }

    private fun createTickableItem(item: Item): TickableItem {
        val constructorForItem = itemClassMap.getOrDefault(item.name, ::RegularItem)
        val tickableItem = constructorForItem(item)
        return tickableItem
    }

    fun Item.updateUsing(other: Item) {
        quality = other.quality;
        name = other.name;
        sellIn = other.sellIn
    }

}

