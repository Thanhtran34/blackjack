package model.rules;

import model.Player;

public class SoftSevenTeenStrategy implements HitStrategy {
  private final int hitLimit = 17;

  @Override
  public boolean doHit(Player dealer) {
    if (dealer.calcScore() == hitLimit && dealer.hasAceCard()) {
      return true;
    } else if (dealer.calcScore() < hitLimit) {
      return true;
    } else {
      return false;
    }
  }
}
