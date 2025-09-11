package model.cards

/**
 * Represents a siege unit card.
 *
 * Siege unit cards can only be placed in the siege combat zone
 * of the battlefield.
 *
 * @param name The name of the siege unit
 * @param strength The strength value of the unit
 */
class SiegeUnitCard(val name: String, val strength: Int) extends UnitCard {

  /** The unit type is always Siege for siege unit cards */
  val unitType: UnitType = UnitType.Siege
}