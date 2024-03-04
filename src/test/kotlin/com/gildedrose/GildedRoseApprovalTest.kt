package com.gildedrose

import org.approvaltests.Approvals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GildedRoseApprovalTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10, 100])
    fun approvalTest(days: Int) {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            Item("Conjured Mana Cake", 3, 6)
        )

        val app = GildedRose(items)

        val output: MutableList<String> = mutableListOf()
        for (i in 0 until days) {
            for (item in items) {
                output.add(item.toString())
            }
            app.updateQuality()
        }

        Approvals.verify(output, Approvals.NAMES.withParameters("$days"))
    }

}
