package com.gildedrose

object ItemQuality {
  private val MAX_VALUE = 50
  private val MIN_VALUE = 0

  def apply(value: Int): ItemQuality = {
    if(value > MAX_VALUE || value < MIN_VALUE) throw new IllegalArgumentException(s"The value ($value) of Quality is incorrect.")

    new ItemQuality(value)
  }
}

case class ItemQuality(value: Int) {
  def increase: ItemQuality = {
    if(value == ItemQuality.MAX_VALUE) return this

    ItemQuality(value + 1)
  }

  def decrease: ItemQuality = {
    if(value == ItemQuality.MIN_VALUE) return this

    ItemQuality(value - 1)
  }

  def reset: ItemQuality = {
    ItemQuality(ItemQuality.MIN_VALUE)
  }
}
