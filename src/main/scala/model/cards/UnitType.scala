package model.cards

/**
 * Enumeration of unit types available in the game.
 *
 * Each unit type corresponds to a specific zone on the battlefield:
 * - Melee: Close combat zone
 * - Ranged: Ranged combat zone
 * - Siege: Siege combat zone
 */
enum UnitType {
  /** Melee combat units for close combat zone */
  case Melee

  /** Ranged combat units for ranged combat zone */
  case Ranged

  /** Siege units for siege combat zone */
  case Siege
}