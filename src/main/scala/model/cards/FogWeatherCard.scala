package model.cards

/**
 * Represents a fog weather card (Impenetrable Fog).
 *
 * When active, this card sets the strength of all ranged combat units
 * to 1, regardless of their original strength value.
 *
 * @param name The name of the fog weather card
 */
class FogWeatherCard(val name: String) extends WeatherCard {

  /** The weather type is always "fog" for fog weather cards */
  val weatherType: String = "fog"
}