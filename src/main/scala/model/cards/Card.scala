package model.cards

/**
 * Base trait for all cards in the game.
 *
 * All cards have a name and a classification that determines
 * their type and behavior in the game.
 */
trait Card {

  /**
   * The name of the card.
   *
   * @return The card's name
   */
  def name : String

  /**
   * The classification of the card.
   *
   * This determines the card's type and where it can be placed.
   *
   * @return The card's classification
   */
  def classification : String
}