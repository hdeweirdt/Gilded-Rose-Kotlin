package com.gildedrose

class BackstagePass(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {
    constructor(item: Item) : this(item.name, item.sellIn, item.quality)

    override fun tick() {
        if (quality < 50) {
            quality += 1

            if (quality < 50) {
                if (sellIn < 11) {
                    quality += 1
                }
                if (sellIn < 6) {
                    quality += 1
                }
                sellIn -= 1
                if (sellIn < 0) {
                    quality = 0
                }
            } else {
                sellIn -= 1
                if (sellIn < 0) {
                    quality = 0
                }
            }

        } else {
            sellIn -= 1
            if (sellIn < 0) {
                quality = 0
            }
        }
    }
}
