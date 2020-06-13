package com.gildedrose

final case class Sulfuras(private val name: ItemName,
                          private val ourItemSellIn: ItemSellIn,
                          private val ourItemQuality: ItemQuality)
extends Item(name, ourItemSellIn, ourItemQuality) {
  override def update(): Unit = {}
}
