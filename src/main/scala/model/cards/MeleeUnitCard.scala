package model.cards

/**
 * Represents a melee unit card.
 *
 * Melee unit cards can only be placed in the melee combat zone
 * of the battlefield.
 *
 * @param name The name of the melee unit
 * @param strength The strength value of the unit
 */
class MeleeUnitCard(val name: String, val strength: Int) extends UnitCard {

  /** The unit type is always Melee for melee unit cards */
  val unitType: UnitType = UnitType.Melee
}