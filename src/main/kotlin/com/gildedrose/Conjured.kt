package com.gildedrose

class Conjured(name: String, var sellIn: Int, quality: Int) {
    fun tick() {
        sellIn -= 1
    }

}
