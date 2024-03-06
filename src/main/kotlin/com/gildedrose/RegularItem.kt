package com.gildedrose

class RegularItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    constructor(item: Item) : this(item.name, item.sellIn, item.quality)

   fun tick() {
        if (quality > 0) {
            quality -= 1
        }
        sellIn -= 1
        if (sellIn < 0) {
            if (quality > 0) {
                quality -= 1
            }
        }
    }
}
