package com.gildedrose

class RegularItem(name: String, sellIn: SellIn, quality: Quality) : TickableItem(name, sellIn, quality) {

   override fun tick() {
       sellIn -= 1
       if (isExpired()) {
           quality = (quality - 2).atLeast(0)
       } else {
           quality = (quality - 1).atLeast(0)
       }
   }

    private fun isExpired() = sellIn < 0

}
