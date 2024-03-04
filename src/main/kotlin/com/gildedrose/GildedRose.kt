package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            doThingWithItem(item)
        }
    }

    private fun doThingWithItem(item: Item) {
        if (item.name == "Aged Brie") {
            agedBrie(item)
        } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            backStagePass(item)
        } else if (item.name == "Sulfuras, Hand of Ragnaros") {
            sulfuras(item)
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

    private fun sulfuras(item: Item) {
    }

    private fun backStagePass(item: Item) {
        if (item.quality < 50) {
            item.quality += 1

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality += 1
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality += 1
                }
            }
            item.sellIn -= 1
            if (item.sellIn < 0) {
                item.quality = 0
            }
        } else {
            item.sellIn -= 1
            if (item.sellIn < 0) {
                item.quality = 0
            }
        }
    }

    private fun agedBrie(item: Item) {
        if (item.quality < 50) {
            item.quality += 1
        }
        if (item.name != "Sulfuras, Hand of Ragnaros") {
            item.sellIn -= 1
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality += 1
            }
        }
    }

}
