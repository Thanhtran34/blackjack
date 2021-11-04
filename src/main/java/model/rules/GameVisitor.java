package model.rules;

public interface GameVisitor {
  void applyAmericanNewGameStrategy(NewGameStrategy newGameStrategy);

  void applyInternationalNewGameStrategy(NewGameStrategy newGameStrategy);

  void applyBasicHitStrategy(HitStrategy hitStrategy);

  void applySoftSevenTeenHitStrategy(HitStrategy hitStrategy);

  void applyDealerWinStrategy(WinStrategy dealerWinStrategy);

  void applyPlayerWinStrategy(WinStrategy playerWinStrategy);
}
