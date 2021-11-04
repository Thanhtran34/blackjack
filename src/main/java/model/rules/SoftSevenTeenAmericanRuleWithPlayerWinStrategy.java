package model.rules;

public class SoftSevenTeenAmericanRuleWithPlayerWinStrategy implements Game {
  @Override
  public NewGameStrategy getNewGameStrategy() {
    return new AmericanNewGameStrategy();
  }

  @Override
  public HitStrategy getHitStrategy() {
    return new SoftSevenTeenHitStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new PlayerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyAmericanNewGameStrategy(this.getNewGameStrategy());
    visitor.applySoftSevenTeenHitStrategy(this.getHitStrategy());
    visitor.applyPlayerWinStrategy(this.getWinStrategy());
  }
}
