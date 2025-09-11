package model

import munit.FunSuite
import model.cards.{MeleeUnitCard, RangedUnitCard, SiegeUnitCard, FrostWeatherCard, FogWeatherCard}

class PlayerTest extends FunSuite {
  var player: Player = _
  var testCard1: MeleeUnitCard = _
  var testCard2: MeleeUnitCard = _
  var testCard3: MeleeUnitCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player("TestPlayer", "North")
    testCard1 = new MeleeUnitCard("Card 1", 5)
    testCard2 = new MeleeUnitCard("Card 2", 7)
    testCard3 = new MeleeUnitCard("Card 3", 3)
  }

  test("Player should be created with correct name") {
    assertEquals(player.name, "TestPlayer")
  }

  test("Player should be created with correct board side") {
    assertEquals(player.boardSide, "North")
  }

  test("Player should start with 2 gems") {
    assertEquals(player.gemCount, 2)
  }

  test("Player should start with empty hand") {
    assertEquals(player.handSize, 0)
    assertEquals(player.isHandEmpty, true)
  }

  test("Player should start with empty deck") {
    assertEquals(player.deckSize, 0)
    assertEquals(player.isDeckEmpty, true)
  }

  test("Player should lose a gem") {
    player.loseGem()
    assertEquals(player.gemCount, 1)
  }

  test("Player should lose two gems") {
    player.loseGem()
    player.loseGem()
    assertEquals(player.gemCount, 0)
  }

  test("Player cannot have negative gems") {
    player.loseGem()
    player.loseGem()
    player.loseGem() // This should not go below 0
    assertEquals(player.gemCount, 0)
  }

  test("Player should detect when they have lost") {
    assertEquals(player.hasLost, false)
    player.loseGem()
    assertEquals(player.hasLost, false)
    player.loseGem()
    assertEquals(player.hasLost, true)
  }

  test("Player should add card to deck") {
    player.addCardToDeck(testCard1)
    assertEquals(player.deckSize, 1)
    assertEquals(player.isDeckEmpty, false)
  }

  test("Player should add multiple cards to deck") {
    player.addCardToDeck(testCard1)
    player.addCardToDeck(testCard2)
    player.addCardToDeck(testCard3)
    assertEquals(player.deckSize, 3)
  }

  test("Player should draw card from deck to hand") {
    player.addCardToDeck(testCard1)

    val result = player.drawCard()

    assertEquals(result, true)
    assertEquals(player.deckSize, 0)
    assertEquals(player.handSize, 1)
    assertEquals(player.hasCardInHand(testCard1), true)
  }

  test("Player cannot draw from empty deck") {
    val result = player.drawCard()
    assertEquals(result, false)
    assertEquals(player.handSize, 0)
  }

  test("Player should draw multiple cards correctly") {
    player.addCardToDeck(testCard1)
    player.addCardToDeck(testCard2)
    player.addCardToDeck(testCard3)

    assertEquals(player.drawCard(), true)
    assertEquals(player.drawCard(), true)
    assertEquals(player.drawCard(), true)

    assertEquals(player.handSize, 3)
    assertEquals(player.deckSize, 0)
  }

  test("Player should play card from hand") {
    player.addCardToDeck(testCard1)
    player.drawCard()

    val result = player.playCard(testCard1)

    assertEquals(result, true)
    assertEquals(player.handSize, 0)
    assertEquals(player.hasCardInHand(testCard1), false)
  }

  test("Player cannot play card not in hand") {
    val result = player.playCard(testCard1)
    assertEquals(result, false)
  }

  test("Player should have maximum 10 cards in hand") {
    // Add 11 cards to deck
    for (i <- 1 to 11) {
      val card = new MeleeUnitCard(s"Card $i", i)
      player.addCardToDeck(card)
    }

    // Try to draw 11 cards
    for (_ <- 1 to 11) {
      player.drawCard()
    }

    assertEquals(player.handSize, 10)
    assertEquals(player.deckSize, 1) // One card should remain in deck
  }

  test("Player can get card from hand by index") {
    player.addCardToDeck(testCard1)
    player.addCardToDeck(testCard2)
    player.drawCard()
    player.drawCard()

    val retrievedCard = player.getCardFromHand(0)
    assertEquals(retrievedCard.isDefined, true)
    assertEquals(retrievedCard.get, testCard1)
  }

  test("Player returns None for invalid hand index") {
    val result = player.getCardFromHand(0)
    assertEquals(result.isDefined, false)
  }

  test("Player can get card from deck by index") {
    player.addCardToDeck(testCard1)

    val retrievedCard = player.getCardFromDeck(0)
    assertEquals(retrievedCard.isDefined, true)
    assertEquals(retrievedCard.get, testCard1)
  }

  test("Player returns None for invalid deck index") {
    val result = player.getCardFromDeck(0)
    assertEquals(result.isDefined, false)
  }

  test("Player can have different types of cards in deck") {
    val meleeCard = new MeleeUnitCard("Melee", 5)
    val rangedCard = new RangedUnitCard("Ranged", 4)
    val siegeCard = new SiegeUnitCard("Siege", 6)
    val weatherCard = new FrostWeatherCard("Frost")

    player.addCardToDeck(meleeCard)
    player.addCardToDeck(rangedCard)
    player.addCardToDeck(siegeCard)
    player.addCardToDeck(weatherCard)

    assertEquals(player.deckSize, 4)
  }

  test("Player can draw and play weather cards") {
    val weatherCard = new FogWeatherCard("Fog")
    player.addCardToDeck(weatherCard)
    player.drawCard()

    assertEquals(player.hasCardInHand(weatherCard), true)
    assertEquals(player.playCard(weatherCard), true)
    assertEquals(player.handSize, 0)
  }
}