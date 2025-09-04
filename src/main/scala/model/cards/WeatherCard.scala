package model.cards

trait WeatherCard extends Card {
  
  def weatherType : String
  
  override def classification: String = "Weather"
  
}
