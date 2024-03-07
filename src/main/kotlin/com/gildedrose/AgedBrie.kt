package com.gildedrose

import kotlin.math.min

class AgedBrie(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

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
