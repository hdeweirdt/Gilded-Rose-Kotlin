package com.gildedrose

import kotlin.math.max

class RegularItem(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {

   override fun tick() {
       sellIn -= 1
       if (isExpired()) {
           quality = max(quality - 2, 0)
       } else {
           quality = max(quality - 1, 0)
       }
   }

    private fun isExpired() = sellIn < 0

}
