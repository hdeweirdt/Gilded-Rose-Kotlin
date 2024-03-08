package com.gildedrose

import kotlin.math.min

class AgedBrie(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        sellIn -= 1
        if (isReallyAged()) {
            quality = min(quality + 2, MAX_QUALITY)
        } else {
            quality = min(quality + 1, MAX_QUALITY)
        }
    }

    private fun isReallyAged() = sellIn < 0
}
