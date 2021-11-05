package model.rules;

/**
 * An interface for Game with hit and win strategy.
 * 
 */
public interface Game {
  NewGameStrategy getNewGameStrategy();

  HitStrategy getHitStrategy();

  WinStrategy getWinStrategy();

  void accept(GameVisitor visitor);
}
