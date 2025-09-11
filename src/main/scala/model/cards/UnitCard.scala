package model.cards

import model.cards.UnitCardEffect

/**
 * Trait for unit cards that can be placed on the battlefield.
 *
 * Unit cards have strength values and specific unit types that determine
 * which zone of the battlefield they can be placed in.
 */
trait UnitCard extends Card {

  /**
   * The strength value of the unit card.
   *
   * This represents the card's power and contributes to the player's
   * total strength on the battlefield.
   *
   * @return The card's strength value
   */
  def strength : Int

  /**
   * The type of unit (Melee, Ranged, or Siege).
   *
   * This determines which zone of the battlefield the card can be placed in.
   *
   * @return The unit type
   */
  def unitType : UnitType

  /**
   * Optional
   * @return The unit effect or None.
   */
  def effect : Option[UnitCardEffect] = None

  /**
   * The classification of the unit card.
   *
   * For unit cards, this is the string representation of their unit type.
   *
   * @return The unit type as a string
   */
  override def classification : String = unitType.toString
}