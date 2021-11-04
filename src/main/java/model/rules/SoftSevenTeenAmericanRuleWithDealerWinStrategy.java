package model.rules;

public class SoftSevenTeenAmericanRuleWithDealerWinStrategy implements Game {
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
    return new DealerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyAmericanNewGameStrategy(this.getNewGameStrategy());
    visitor.applySoftSevenTeenHitStrategy(this.getHitStrategy());
    visitor.applyDealerWinStrategy(this.getWinStrategy());
  }
}
