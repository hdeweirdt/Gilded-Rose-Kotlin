package com.gildedrose

import kotlin.math.max

class RegularItem(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

   override fun tick() {
       sellIn -= 1
       if (isExpired()) {
           quality = max(quality - 2, 0)
       } else {
           quality = max(quality - 1, 0)
       }
    }

}
