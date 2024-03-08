package com.gildedrose

class AgedBrie(name: String, sellIn: SellIn, quality: Quality) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        sellIn -= 1
        if (isReallyAged()) {
            quality = (quality + 2).capAt(MAX_QUALITY)
        } else {
            quality = (quality + 1).capAt(MAX_QUALITY)
        }
    }

    private fun isReallyAged() = sellIn < 0
}
