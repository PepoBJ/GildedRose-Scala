package com.gildedrose

case class ItemSellIn(value: Int) {
  def decrease: ItemSellIn = {
    ItemSellIn(value - 1)
  }

  def isLessThan(days: Int): Boolean = {
    value < days
  }
}
