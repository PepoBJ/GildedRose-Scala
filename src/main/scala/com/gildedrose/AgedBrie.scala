package com.gildedrose

final case class AgedBrie(private val name: ItemName,
                          private val ourSellIn: ItemSellIn,
                          private val ourQuality: ItemQuality)
  extends Item(name, ourSellIn, ourQuality) {

  private val DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD: Int = 0

  override def update(): Unit = {
    decreaseSellIn()

    increaseQuality()

    if(hasToBeSoldInLessThan(DOUBLE_QUALITY_DECREMENT_SELL_IN_THRESHOLD))
      increaseQuality()
  }
}
