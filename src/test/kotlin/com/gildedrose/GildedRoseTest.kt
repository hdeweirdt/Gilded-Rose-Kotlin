package com.gildedrose

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun conjuredItemsGetProcessed() {
        val items = listOf(Item("Conjured", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertThat(app.items[0].quality).isEqualTo(8)

    }

}


