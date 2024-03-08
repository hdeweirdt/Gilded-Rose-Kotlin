package com.gildedrose

import kotlin.math.max
import kotlin.math.min

const val MAX_QUALITY = 50

abstract class TickableItem(name: String, sellIn: SellIn, quality: Quality) : Item(name, sellIn, quality){
    abstract fun tick()

    internal fun Int.atLeast(bound: Int): Int {
        return max(this, bound)
    }

    internal fun Int.capAt(bound: Int): Int {
        return min(this, bound)
    }
}
