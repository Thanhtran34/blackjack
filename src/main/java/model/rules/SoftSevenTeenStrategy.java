package model.rules;

import model.Player;

public class SoftSevenTeenStrategy implements HitStrategy{

  @Override
  public boolean doHit(Player dealer) {
    return false;
  }
}
