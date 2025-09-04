package model.cards

class RangedUnitCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Ranged
}
