package com.gildedrose

import kotlin.math.max

class Conjured(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        sellIn -= 1

        if(sellIn < 0) {
           quality = max(quality-4, 0)
        } else {
            quality = max(quality-2, 0)
        }
    }

}
