package com.gildedrose

class AgedBrie(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {
    constructor(item: Item) : this(item.name, item.sellIn, item.quality)

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
