package model.cards

class SiegeUnitCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Siege
}
