package com.gildedrose

final case class BackstagePasses(private val name: ItemName,
                                 private val ourSellIn: ItemSellIn,
                                 private val ourQuality: ItemQuality)
  extends Item(name, ourSellIn, ourQuality) {

  private val DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD: Int = 10
  private val TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD: Int = 5
  private val QUALITY_RESET_SELL_IN_THRESHOLD: Int = 0

  override def update(): Unit = {
    decreaseSellIn()

    increaseQuality()

    if (hasToBeSoldInLessThan(DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD)) increaseQuality()

    if (hasToBeSoldInLessThan(TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD)) increaseQuality()

    if (hasToBeSoldInLessThan(QUALITY_RESET_SELL_IN_THRESHOLD)) resetQuality()
  }
}
