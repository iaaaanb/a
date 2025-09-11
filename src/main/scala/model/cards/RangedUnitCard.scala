package model.cards

/**
 * Represents a ranged unit card.
 *
 * Ranged unit cards can only be placed in the ranged combat zone
 * of the battlefield.
 *
 * @param name The name of the ranged unit
 * @param strength The strength value of the unit
 * @param effect The effect of the card or None
 */
class RangedUnitCard(val name: String,
                     val strength: Int,
                     override val effect: Option[UnitCardEffect] = None)
  extends UnitCard {

  /** The unit type is always Ranged for ranged unit cards */
  val unitType: UnitType = UnitType.Ranged
}