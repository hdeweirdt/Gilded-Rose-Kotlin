package com.gildedrose

class Conjured(name: String, var sellIn: Int, var quality: Int) {
    fun tick() {
        sellIn -= 1

        if(sellIn < 0) {
           quality -= 4
        } else {
            quality -= 2
        }
    }

}
