package model.cards

class MeleeUnitCard(val name: String, val strength: Int) extends UnitCard {
  val unitType: UnitType = UnitType.Melee
}
