package model.rules;

import model.Player;

/** A class for adaption of Soft17 rule. */
public class SoftSevenTeenHitStrategy implements HitStrategy {
  private final int hitLimit = 17;

  @Override
  public boolean doHit(Player dealer) {
    if (dealer.hasSoftAceCard()) {
      return true;
    }
    if (dealer.calcScore() < hitLimit) {
      return true;
    }
    return false;
  }
}
