package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {
  private def listOf(item: Item): Array[Item] = Array(item)
  
  behavior of "GildedRose"

  it should "testThatSellInValueIsDecreased" in {
    val whateverItem = Item("whatever", 10, 0)
    val gildedRose = new GildedRose(listOf(whateverItem))
    gildedRose.updateQuality()
    val expectedSellIn = ItemSellIn(9)
    expectedSellIn should be (whateverItem.sellIn())
  }

  it should "testThatQualityValueIsDecreased" in {
    val whateverItem = Item("whatever", 1, 10)
    val gildedRose = new GildedRose(listOf(whateverItem))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(9)
    expectedQuality should be (whateverItem.quality())
  }

  it should "testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed" in {
    val whateverItem = Item("whatever", 0, 10)
    val gildedRose = new GildedRose(listOf(whateverItem))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(8)
    expectedQuality should be (whateverItem.quality())
  }

  it should "testThatQualityIsNeverNegative" in {
    val whateverItem = Item("whatever", 0, 0)
    val gildedRose = new GildedRose(listOf(whateverItem))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(0)
    expectedQuality should be (whateverItem.quality())
  }

  it should "testAgedBrieIncreasesQualityWithAge" in {
    val agedBrie = Item("Aged Brie", 5, 1)
    val gildedRose = new GildedRose(listOf(agedBrie))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(2)
    expectedQuality should be (agedBrie.quality())
  }

  it should "testQualityNeverIncreasesPastFifty" in {
    val agedBrie = Item("Aged Brie", 5, 50)
    val gildedRose = new GildedRose(listOf(agedBrie))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(50)
    expectedQuality should be (agedBrie.quality())
  }

  it should "testSulfurasNeverChanges" in {
    val sulfuras = Item("Sulfuras, Hand of Ragnaros", 0, 25)
    val gildedRose = new GildedRose(listOf(sulfuras))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(25)
    expectedQuality should be (sulfuras.quality())
    val expectedSellIn = ItemSellIn(0)
    expectedSellIn should be (sulfuras.sellIn())
  }

  it should "testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen" in {
    val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)
    val gildedRose = new GildedRose(listOf(backstagePasses))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(21)
    expectedQuality should be (backstagePasses.quality())
  }

  it should "testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen" in {
    val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 6, 20)
    val gildedRose = new GildedRose(listOf(backstagePasses))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(22)
    expectedQuality should be (backstagePasses.quality())
  }

  it should "testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive" in {
    val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)
    val gildedRose = new GildedRose(listOf(backstagePasses))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(23)
    expectedQuality should be (backstagePasses.quality())
  }

  it should "testBackstagePassLosesValueAfterSellByPasses" in {
    val backstagePasses = Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
    val gildedRose = new GildedRose(listOf(backstagePasses))
    gildedRose.updateQuality()
    val expectedQuality = new ItemQuality(0)
    expectedQuality should be (backstagePasses.quality())
  }

  it should "testQualityDoesNotAllowValuesBelowZero" in {
    assertThrows[IllegalArgumentException]{
      ItemQuality(-1)
    }
  }

  it should "testQualityDoesNotAllowValuesOverFifty" in {
    assertThrows[IllegalArgumentException]{
      ItemQuality(51)
    }
  }
}