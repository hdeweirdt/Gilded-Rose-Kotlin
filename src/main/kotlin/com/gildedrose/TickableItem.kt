package com.gildedrose

const val MAX_QUALITY = 50

abstract class TickableItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality){
    abstract fun tick()
}
