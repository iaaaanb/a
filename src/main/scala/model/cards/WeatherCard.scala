package model.cards

/**
 * Trait for weather cards that affect the battlefield.
 *
 * Weather cards are placed in a special weather zone and have effects
 * that can modify the strength of unit cards on the battlefield.
 */
trait WeatherCard extends Card {

  /**
   * The type of weather effect this card provides.
   *
   * Different weather types have different effects on unit cards.
   *
   * @return The weather type as a string
   */
  def weatherType : String

  /**
   * The classification of weather cards.
   *
   * All weather cards have the classification "Weather".
   *
   * @return "Weather"
   */
  override def classification: String = "Weather"
}