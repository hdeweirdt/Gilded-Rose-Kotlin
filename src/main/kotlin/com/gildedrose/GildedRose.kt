package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            tick(item)
        }
    }

    private fun tick(item: Item) {
        if (item.name == "Aged Brie") {
            val updatedItem = AgedBrie(item)
            updatedItem.tick()
            item.updateUsing(updatedItem)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            val updatedItem = BackstagePass(item)
            updatedItem.tick()
            item.updateUsing(updatedItem)
        } else if (item.name == "Sulfuras, Hand of Ragnaros") {
            val updatedItem = Sulfuras(item)
            updatedItem.tick()
            item.updateUsing(updatedItem)
        } else {
            regularItem(item)
        }
    }

    private fun regularItem(item: Item) {
        if (item.quality > 0) {
            item.quality -= 1
        }
        item.sellIn -= 1
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality -= 1
            }
        }
    }

    fun Item.updateUsing(other: Item) {
        quality = other.quality;
        name = other.name;
        sellIn = other.sellIn
    }

}

