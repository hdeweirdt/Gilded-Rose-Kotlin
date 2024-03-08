package com.gildedrose

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class ConjuredTest {

    @Test
    fun sellInReducesByOneEachTick() {
        val initialSellIn = 10
        val item = Conjured("Conjured", initialSellIn, 10)

        item.tick()

        assertThat(item.sellIn).isEqualTo(initialSellIn - 1)
    }

    @Test
    fun qualityReducesByTwoEachTick() {
        val initialQuality = 10
        val item = Conjured("Conjured", 10, initialQuality)

        item.tick()

        assertThat(item.quality).isEqualTo(initialQuality - 2)
    }

    @Test
    fun expiredItemsQualityReducesByFourEachTick() {
        val initialQuality = 10
        val item = Conjured("Conjured", -1, initialQuality)

        item.tick()

        assertThat(item.quality).isEqualTo(initialQuality - 4)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 10])
    fun qualityCannotGoLowerThanZero(initialQuality: Int) {
        val item = Conjured("Conjured", initialQuality, 1)

        item.tick()

        assertThat(item.quality).isEqualTo(0)
    }

    @Test
    fun conjuredItemWithSellInZeroFollowsFreshRulesForQuality() {
        val initialQuality = 10
        val twoDaysBeforeExpired = 1
        val item = Conjured("Conjured", twoDaysBeforeExpired, initialQuality)

        item.tick()

        assertThat(item.quality).isEqualTo(initialQuality - 2)
    }
}
