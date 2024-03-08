package com.gildedrose

import kotlin.math.min

class BackstagePass(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        if (sellIn <= 5) {
            quality = min(quality + 3, MAX_QUALITY)
        } else if (sellIn <= 10) {
            quality = min(quality + 2, MAX_QUALITY)
        } else {
            quality = min(quality + 1, MAX_QUALITY)
        }

        sellIn -= 1
        if (concertHasPassed()) {
            quality = 0
        }
    }

    private fun concertHasPassed() = sellIn < 0
}
