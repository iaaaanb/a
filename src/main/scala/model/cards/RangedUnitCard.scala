package model.cards

/**
 * Represents a ranged unit card.
 *
 * Ranged unit cards can only be placed in the ranged combat zone
 * of the battlefield.
 *
 * @param name The name of the ranged unit
 * @param strength The strength value of the unit
 */
class RangedUnitCard(val name: String, val strength: Int) extends UnitCard {

  /** The unit type is always Ranged for ranged unit cards */
  val unitType: UnitType = UnitType.Ranged
}