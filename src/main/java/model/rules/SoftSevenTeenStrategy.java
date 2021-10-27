package model.rules;

import model.Player;

/**
 * A class for adaption of Soft17 rule.
 * 
 */
public class SoftSevenTeenStrategy implements HitStrategy {
  private final int hitLimit = 17;

  @Override
  public boolean doHit(Player dealer) {
    if (dealer.calcScore() == hitLimit && dealer.hasSoftAceCard()) {
      return true;
    } else if (dealer.calcScore() < hitLimit) {
      return true;
    } else {
      return false;
    }
  }
}
