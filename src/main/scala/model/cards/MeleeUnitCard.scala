package model.cards

/**
 * Represents a melee unit card.
 *
 * Melee unit cards can only be placed in the melee combat zone
 * of the battlefield.
 *
 * @param name The name of the melee unit
 * @param strength The strength value of the unit
 * @param effect The effect of the card or None
 */
class MeleeUnitCard(val name: String,
                    val strength: Int,
                    override val effect: Option[UnitCardEffect] = None)
  extends UnitCard {

  /** The unit type is always Melee for melee unit cards */
  val unitType: UnitType = UnitType.Melee
}