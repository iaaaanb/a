package model.cards

/** Represents the possible special effects for unit cards. 
 * 
 * Can be Moral Reinforcement or Strong Bond
 */
enum UnitCardEffect {
  /** Moral Reinforcement: when played, adds +1 strength to all other cards in the row. */
  case MoralReinforcement
  
  /** Strong Bond: when played, if a card with the same name already exists in the row, doubles the strength of that/those cards (including itself). */
  case StrongBond
}