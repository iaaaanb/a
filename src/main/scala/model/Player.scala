package model

import model.cards.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a player in the Gwent game.
 *
 * Each player has a name, board side, gems (life points), a deck of cards,
 * and a hand of cards. Players can draw cards from their deck to their hand
 * and play cards from their hand.
 *
 * @param name The player's identifier name
 * @param boardSide The section of the board assigned to this player
 */
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
   *
   * @return The current gem count
   */
  def gemCount: Int = gems

  /**
   * Gets the size of the deck.
   *
   * @return The number of cards in the deck
   */
  def deckSize: Int = deckCards.size

  /**
   * Gets the size of the hand.
   *
   * @return The number of cards in the hand
   */
  def handSize: Int = handCards.size

  /**
   * Checks if deck is empty.
   *
   * @return true if the deck has no cards, false otherwise
   */
  def isDeckEmpty: Boolean = deckCards.isEmpty

  /**
   * Checks if hand is empty.
   *
   * @return true if the hand has no cards, false otherwise
   */
  def isHandEmpty: Boolean = handCards.isEmpty

  /**
   * Makes the player lose one gem. Gems cannot go below 0.
   *
   * When a player loses all gems, they lose the game.
   */
  def loseGem(): Unit =
    if gems > 0 then
      gems = gems - 1

  /**
   * Adds a card to the player's deck.
   *
   * @param card The card to add to the deck
   */
  def addCardToDeck(card: Card): Unit =
    deckCards.addOne(card)

  /**
   * Draws a card from the deck to the hand.
   *
   * The card is removed from the deck and added to the hand.
   * This operation fails if the deck is empty or the hand is full.
   *
   * @return true if the card was successfully drawn, false otherwise
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
   *
   * @param card The card to check for
   * @return true if the card is in the hand, false otherwise
   */
  def hasCardInHand(card: Card): Boolean =
    handCards.contains(card)

  /**
   * Plays a card from the hand.
   *
   * The card is removed from the hand. This represents playing
   * the card onto the battlefield.
   *
   * @param card The card to play
   * @return true if the card was successfully played, false if card is not in hand
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
   *
   * A player loses the game when they have 0 gems.
   *
   * @return true if the player has lost (0 gems), false otherwise
   */
  def hasLost: Boolean = gems == 0

  /**
   * Gets a card from the hand by index.
   *
   * @param index The index of the card in the hand (0-based)
   * @return Some(card) if index is valid, None otherwise
   */
  def getCardFromHand(index: Int): Option[Card] =
    if index >= 0 && index < handCards.size then
      Some(handCards(index))
    else
      None

  /**
   * Gets a card from the deck by index.
   *
   * @param index The index of the card in the deck (0-based)
   * @return Some(card) if index is valid, None otherwise
   */
  def getCardFromDeck(index: Int): Option[Card] =
    if index >= 0 && index < deckCards.size then
      Some(deckCards(index))
    else
      None
}