package com.gildedrose

import kotlin.math.max

class RegularItem(item: Item) : TickableItem(item.name, item.sellIn, item.quality) {

   override fun tick() {
       sellIn -= 1
       if (sellIn < 0) {
           quality = max(quality - 2, 0)
       } else {
           quality = max(quality - 1, 0)
       }
   }

}
