package model.cards

/**
 * Represents a clear weather card.
 *
 * When played, this card removes all weather effects currently
 * active on the battlefield, restoring unit cards to their
 * original strength values.
 *
 * @param name The name of the clear weather card
 */
class ClearWeatherCard(val name: String) extends WeatherCard {

  /** The weather type is always "clear" for clear weather cards */
  val weatherType: String = "clear"
}