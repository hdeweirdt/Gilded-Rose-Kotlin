package com.gildedrose

abstract class TickableItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality){
    abstract fun tick()
    protected fun isExpired() = sellIn < 0
}
