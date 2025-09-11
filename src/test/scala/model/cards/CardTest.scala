package model.cards

import munit.FunSuite

class CardTest extends FunSuite {
  var meleeCard: MeleeUnitCard = _
  var rangedCard: RangedUnitCard = _
  var siegeCard: SiegeUnitCard = _
  var frostCard: FrostWeatherCard = _
  var fogCard: FogWeatherCard = _
  var rainCard: RainWeatherCard = _
  var clearCard: ClearWeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    meleeCard = new MeleeUnitCard("Warrior", 8)
    rangedCard = new RangedUnitCard("Archer", 6)
    siegeCard = new SiegeUnitCard("Catapult", 10)
    frostCard = new FrostWeatherCard("Biting Frost")
    fogCard = new FogWeatherCard("Impenetrable Fog")
    rainCard = new RainWeatherCard("Torrential Rain")
    clearCard = new ClearWeatherCard("Clear Weather")
  }

  test("MeleeUnitCard should have correct properties") {
    assertEquals(meleeCard.name, "Warrior")
    assertEquals(meleeCard.strength, 8)
    assertEquals(meleeCard.unitType, UnitType.Melee)
    assertEquals(meleeCard.classification, "Melee")
  }

  test("RangedUnitCard should have correct properties") {
    assertEquals(rangedCard.name, "Archer")
    assertEquals(rangedCard.strength, 6)
    assertEquals(rangedCard.unitType, UnitType.Ranged)
    assertEquals(rangedCard.classification, "Ranged")
  }

  test("SiegeUnitCard should have correct properties") {
    assertEquals(siegeCard.name, "Catapult")
    assertEquals(siegeCard.strength, 10)
    assertEquals(siegeCard.unitType, UnitType.Siege)
    assertEquals(siegeCard.classification, "Siege")
  }

  test("FrostWeatherCard should have correct properties") {
    assertEquals(frostCard.name, "Biting Frost")
    assertEquals(frostCard.weatherType, "frost")
    assertEquals(frostCard.classification, "Weather")
  }

  test("FogWeatherCard should have correct properties") {
    assertEquals(fogCard.name, "Impenetrable Fog")
    assertEquals(fogCard.weatherType, "fog")
    assertEquals(fogCard.classification, "Weather")
  }

  test("RainWeatherCard should have correct properties") {
    assertEquals(rainCard.name, "Torrential Rain")
    assertEquals(rainCard.weatherType, "rain")
    assertEquals(rainCard.classification, "Weather")
  }

  test("ClearWeatherCard should have correct properties") {
    assertEquals(clearCard.name, "Clear Weather")
    assertEquals(clearCard.weatherType, "clear")
    assertEquals(clearCard.classification, "Weather")
  }

  test("Different unit types have different classifications") {
    assertEquals(meleeCard.classification != rangedCard.classification, true)
    assertEquals(rangedCard.classification != siegeCard.classification, true)
    assertEquals(meleeCard.classification != siegeCard.classification, true)
  }

  test("All weather cards have Weather classification") {
    assertEquals(frostCard.classification, "Weather")
    assertEquals(fogCard.classification, "Weather")
    assertEquals(rainCard.classification, "Weather")
    assertEquals(clearCard.classification, "Weather")
  }

  test("UnitType enum has correct string values") {
    assertEquals(UnitType.Melee.toString, "Melee")
    assertEquals(UnitType.Ranged.toString, "Ranged")
    assertEquals(UnitType.Siege.toString, "Siege")
  }

  test("Unit card classification matches unitType toString") {
    assertEquals(meleeCard.classification, meleeCard.unitType.toString)
    assertEquals(rangedCard.classification, rangedCard.unitType.toString)
    assertEquals(siegeCard.classification, siegeCard.unitType.toString)
  }

  test("Unit cards can have zero strength") {
    val weakCard = new MeleeUnitCard("Weak Unit", 0)
    assertEquals(weakCard.strength, 0)
  }

  test("Unit cards can have negative strength") {
    val negativeCard = new RangedUnitCard("Negative Unit", -5)
    assertEquals(negativeCard.strength, -5)
  }

  test("Weather cards have different weather types") {
    assertEquals(frostCard.weatherType != fogCard.weatherType, true)
    assertEquals(fogCard.weatherType != rainCard.weatherType, true)
    assertEquals(rainCard.weatherType != clearCard.weatherType, true)
  }

  test("Cards with same name can be created") {
    val duplicate1 = new MeleeUnitCard("Duplicate", 5)
    val duplicate2 = new MeleeUnitCard("Duplicate", 5)
    assertEquals(duplicate1.name, duplicate2.name)
    assertEquals(duplicate1.strength, duplicate2.strength)
  }

  test("Weather cards can have same name but different types") {
    val frost2 = new FrostWeatherCard("Weather Effect")
    val fog2 = new FogWeatherCard("Weather Effect")
    assertEquals(frost2.name, fog2.name)
    assertEquals(frost2.weatherType != fog2.weatherType, true)
  }
}