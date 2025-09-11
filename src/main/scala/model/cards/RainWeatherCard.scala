package model.cards

/**
 * Represents a rain weather card (Torrential Rain).
 *
 * When active, this card sets the strength of all siege units
 * to 1, regardless of their original strength value.
 *
 * @param name The name of the rain weather card
 */
class RainWeatherCard(val name: String) extends WeatherCard {

  /** The weather type is always "rain" for rain weather cards */
  val weatherType: String = "rain"
}