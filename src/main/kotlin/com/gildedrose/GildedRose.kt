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
            val updatedItem = RegularItem(item)
            updatedItem.tick()
            item.updateUsing(updatedItem)
        }
    }


    fun Item.updateUsing(other: Item) {
        quality = other.quality;
        name = other.name;
        sellIn = other.sellIn
    }

}

