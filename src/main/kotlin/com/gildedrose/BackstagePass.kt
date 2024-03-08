package com.gildedrose

class BackstagePass(name: String, sellIn: SellIn, quality: Quality) : TickableItem(name, sellIn, quality) {

    override fun tick() {
        if (sellIn <= 5) {
            quality = (quality + 3).capAt(MAX_QUALITY)
        } else if (sellIn <= 10) {
            quality = (quality + 2).capAt(MAX_QUALITY)
        } else {
            quality = (quality + 1).capAt(MAX_QUALITY)
        }

        sellIn -= 1
        if (concertHasPassed()) {
            quality = 0
        }
    }

    private fun concertHasPassed() = sellIn < 0
}
