package com.gildedrose

class Conjured(name: String, var sellIn: Int, var quality: Int) {
    fun tick() {
        sellIn -= 1
    }

}
