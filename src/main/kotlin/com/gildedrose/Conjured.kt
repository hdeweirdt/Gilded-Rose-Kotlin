package com.gildedrose

class Conjured(name: String, sellIn: SellIn, quality: Quality) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        sellIn -= 1

        if(sellIn < 0) {
            quality = (quality - 4).atLeast(0)
        } else {
            quality = (quality - 2).atLeast(0)
        }
    }

}
