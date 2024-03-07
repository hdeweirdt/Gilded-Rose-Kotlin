package com.gildedrose

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test


class ConjuredTest() {

    @Test
    fun sellInReducesByOneEachTick() {
        val initialSellIn = 10
        val item = Conjured("Conjured", initialSellIn, 10)

        item.tick()

        assertThat(item.sellIn).isEqualTo(initialSellIn - 1)
    }
}
