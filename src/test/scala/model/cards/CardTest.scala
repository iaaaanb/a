package model.cards

import munit.FunSuite

class CardTest extends FunSuite {
  var meleeCard: TestMeleeCard = _
  var rangedCard: TestRangedCard = _
  var siegeCard: TestSiegeCard = _
  var frostCard: TestWeatherCard = _
  var fogCard: TestWeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    meleeCard = new TestMeleeCard("Warrior", 8)
    rangedCard = new TestRangedCard("Archer", 6)
    siegeCard = new TestSiegeCard("Catapult", 10)
    frostCard = new TestWeatherCard("Biting Frost", "frost")
    fogCard = new TestWeatherCard("Impenetrable Fog", "fog")
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

  test("WeatherCard should have correct properties") {
    assertEquals(frostCard.name, "Biting Frost")
    assertEquals(frostCard.weatherType, "frost")
    assertEquals(frostCard.classification, "Weather")
  }

  test("Different unit types have different classifications") {
    assertEquals(meleeCard.classification != rangedCard.classification, true)
    assertEquals(rangedCard.classification != siegeCard.classification, true)
    assertEquals(meleeCard.classification != siegeCard.classification, true)
  }

  test("All weather cards have Weather classification") {
    assertEquals(frostCard.classification, "Weather")
    assertEquals(fogCard.classification, "Weather")
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
    val weakCard = new TestMeleeCard("Weak Unit", 0)
    assertEquals(weakCard.strength, 0)
  }
}

// Test helper classes
class TestMeleeCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Melee
}

class TestRangedCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Ranged
}

class TestSiegeCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Siege
}

class TestWeatherCard(val name: String, val weatherType: String) extends WeatherCard
