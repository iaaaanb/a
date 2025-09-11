package model.cards

/**
 * Represents a frost weather card (Biting Frost).
 *
 * When active, this card sets the strength of all melee combat units
 * to 1, regardless of their original strength value.
 *
 * @param name The name of the frost weather card
 */
class FrostWeatherCard(val name: String) extends WeatherCard {

  /** The weather type is always "frost" for frost weather cards */
  val weatherType: String = "frost"
}