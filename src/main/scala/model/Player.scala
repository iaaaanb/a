package model

import model.cards.Card
import scala.collection.mutable.ArrayBuffer

class Player(val name : String, val boardSide : String) {

  /** The number of gems (life points) the player has */
  private var gems: Int = 2

  /** The player's deck of cards */
  private val deckCards: ArrayBuffer[Card] = ArrayBuffer.empty[Card]

  /** The player's hand of cards (maximum 10 cards) */
  private val handCards: ArrayBuffer[Card] = ArrayBuffer.empty[Card]

  /** Maximum number of cards allowed in hand */
  private val maxHandSize = 10

  /**
   * Gets the current number of gems.
   */
  def gemCount: Int = gems

  /**
   * Gets the size of the deck.
   */
  def deckSize: Int = deckCards.size

  /**
   * Gets the size of the hand.
   */
  def handSize: Int = handCards.size

  /**
   * Checks if deck is empty.
   */
  def isDeckEmpty: Boolean = deckCards.isEmpty

  /**
   * Checks if hand is empty.
   */
  def isHandEmpty: Boolean = handCards.isEmpty

  /**
   * Makes the player lose one gem. Gems cannot go below 0.
   */
  def loseGem(): Unit =
    if gems > 0 then
      gems = gems - 1

  /**
   * Adds a card to the player's deck.
   */
  def addCardToDeck(card: Card): Unit =
    deckCards.addOne(card)

  /**
   * Draws a card from the deck to the hand.
   * Returns true if successful, false if deck is empty or hand is full.
   */
  def drawCard(): Boolean =
    if deckCards.nonEmpty && handCards.size < maxHandSize then
      val card = deckCards.remove(0)
      handCards.addOne(card)
      true
    else
      false

  /**
   * Checks if a card is in the hand.
   */
  def hasCardInHand(card: Card): Boolean =
    handCards.contains(card)

  /**
   * Plays a card from the hand.
   * Returns true if successful, false if card is not in hand.
   */
  def playCard(card: Card): Boolean =
    val index = handCards.indexOf(card)
    if index >= 0 then
      handCards.remove(index)
      true
    else
      false

  /**
   * Checks if the player has lost all gems.
   */
  def hasLost: Boolean = gems == 0

  /**
   * Gets a card from the hand by index.
   * Returns None if index is invalid.
   */
  def getCardFromHand(index: Int): Option[Card] =
    if index >= 0 && index < handCards.size then
      Some(handCards(index))
    else
      None

  /**
   * Gets a card from the deck by index.
   * Returns None if index is invalid.
   */
  def getCardFromDeck(index: Int): Option[Card] =
    if index >= 0 && index < deckCards.size then
      Some(deckCards(index))
    else
      None


}
