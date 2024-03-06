package com.gildedrose

class Sulfuras(name: String, sellIn: Int, quality: Int) : TickableItem(name, sellIn, quality) {
    constructor(item: Item) : this(item.name, item.sellIn, item.quality)

    override fun tick() {
    }
}
