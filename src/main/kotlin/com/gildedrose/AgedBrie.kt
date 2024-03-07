package com.gildedrose

import kotlin.math.min

class AgedBrie(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

    override fun tick() {
        sellIn -= 1
        quality = if (isReallyAged()) {
            min(quality + 2, 50)
        } else {
            min(quality + 1, 50)
        }
    }

    private fun isReallyAged() = sellIn < 0
}
