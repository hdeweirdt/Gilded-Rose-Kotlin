package com.gildedrose

import kotlin.math.max

class Conjured(name: String, var sellIn: Int, var quality: Int) {
    fun tick() {
        sellIn -= 1

        if(sellIn < 0) {
           quality = max(quality-4, 0)
        } else {
            quality = max(quality-2, 0)
        }
    }

}
