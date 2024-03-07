package com.gildedrose

import kotlin.math.min

class BackstagePass(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

    override fun tick() {
        quality = min(quality + 1, MAX_QUALITY)
        if (sellIn < 11) {
            quality = min(quality + 1, MAX_QUALITY)
        }
        if (sellIn < 6) {
            quality = min(quality + 1, MAX_QUALITY)
        }

        sellIn -= 1
        if (concertHasPassed()) {
            quality = 0
        }
    }

    private fun concertHasPassed() = sellIn < 0
}
