package com.gildedrose

case class ItemName(value: String) {
  private val AGED_BRIE: String = "Aged Brie"
  private val BACKSTAGE_PASSES: String = "Backstage passes to a TAFKAL80ETC concert"
  private val SULFURAS: String = "Sulfuras, Hand of Ragnaros"
  private val CONJURED: String = "Conjured Mana Cake"

  def isAgedBrie: Boolean = {
    AGED_BRIE.equals(value)
  }

  def isBackstagePasses: Boolean = {
    BACKSTAGE_PASSES.equals(value)
  }

  def isSulfuras = {
    SULFURAS.equals(value)
  }

  def isConjured = {
    CONJURED.equals(value)
  }
}