package model.cards



trait UnitCard extends Card {

  def strength : Int
  def unitType : UnitType

  override def classification : String = unitType.toString

}
