package model.rules;

public interface Game {
  NewGameStrategy getNewGameStrategy();

  HitStrategy getHitStrategy();

  WinStrategy getWinStrategy();

  void accept(GameVisitor visitor);
}
