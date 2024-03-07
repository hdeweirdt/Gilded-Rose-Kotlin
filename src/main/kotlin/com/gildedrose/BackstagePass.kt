package com.gildedrose

class BackstagePass(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

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
            }
        }
        sellIn -= 1
        if (isExpired()) {
            quality = 0
        }
    }
}
