package com.gildedrose

object Item {
  def apply(name: String, sellIn: Int, quality: Int): Item = {
    val itemName = ItemName(name)
    val itemSellIn = ItemSellIn(sellIn)
    val itemQuality = ItemQuality(quality)

    if(itemName.isAgedBrie) return AgedBrie(itemName, itemSellIn, itemQuality)
    if(itemName.isBackstagePasses) return  BackstagePasses(itemName, itemSellIn, itemQuality)
    if(itemName.isConjured) return Conjured(itemName, itemSellIn, itemQuality)
    if(itemName.isSulfuras) return Sulfuras(itemName, itemSellIn, itemQuality)

    StandardItem(itemName, itemSellIn, itemQuality)
  }
}

abstract class Item(private val name: ItemName, private var ourSellIn: ItemSellIn, private var ourQuality: ItemQuality) {
  def update(): Unit

  def sellIn(): ItemSellIn = ourSellIn

  def quality(): ItemQuality = ourQuality

  def decreaseSellIn(): Unit = {
    ourSellIn = ourSellIn.decrease
  }

  def hasToBeSoldInLessThan(days: Int): Boolean = {
    ourSellIn.isLessThan(days)
  }

  def increaseQuality(): Unit = {
    ourQuality = ourQuality.increase
  }

  def decreaseQuality(): Unit = {
    ourQuality = ourQuality.decrease
  }

  def resetQuality(): Unit = {
    ourQuality = ourQuality.reset
  }

  override def toString: String = {
    s"$name, $ourSellIn, $ourQuality"
  }
}