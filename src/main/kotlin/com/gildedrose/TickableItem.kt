package com.gildedrose

const val MAX_QUALITY = 50

abstract class TickableItem(name: String, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality){
    abstract fun tick()
}
