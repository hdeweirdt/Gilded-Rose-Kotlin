package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            tick(item)
        }
    }

    private fun tick(item: Item) {
        val tickableItem = when (item.name) {
            "Aged Brie" -> {
                AgedBrie(item)
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                BackstagePass(item)
            }
            "Sulfuras, Hand of Ragnaros" -> {
                Sulfuras(item)
            }
            else -> {
                RegularItem(item)
            }
        }
        tickableItem.tick()
        item.updateUsing(tickableItem)
    }


    fun Item.updateUsing(other: Item) {
        quality = other.quality;
        name = other.name;
        sellIn = other.sellIn
    }

}

