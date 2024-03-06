package com.gildedrose

class AgedBrie(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

    override fun tick() {
        if (quality < 50) {
            quality += 1
        }
        sellIn -= 1
        if (sellIn < 0) {
            if (quality < 50) {
                quality += 1
            }
        }
    }
}
