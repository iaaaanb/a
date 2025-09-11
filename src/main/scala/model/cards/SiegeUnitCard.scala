package model.cards

/**
 * Represents a siege unit card.
 *
 * Siege unit cards can only be placed in the siege combat zone
 * of the battlefield.
 *
 * @param name The name of the siege unit
 * @param strength The strength value of the unit
 * @param effect The effect of the card or None
 */
class SiegeUnitCard(val name: String,
                    val strength: Int, 
                    override val effect: Option[UnitCardEffect] = None)
  extends UnitCard {

  /** The unit type is always Siege for siege unit cards */
  val unitType: UnitType = UnitType.Siege
}