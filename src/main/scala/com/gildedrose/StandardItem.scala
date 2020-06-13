package com.gildedrose

final case class StandardItem(private val name: ItemName,
                              private val ourSellIn: ItemSellIn,
                              private val ourQuality: ItemQuality)
extends Item(name, ourSellIn, ourQuality) {

  private val DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD: Int = 0

  override def update(): Unit = {

    decreaseSellIn()

    decreaseQuality()

    if (hasToBeSoldInLessThan(DOUBLE_QUALITY_DECREASE_SELL_IN_THRESHOLD)) decreaseQuality()
  }
}
