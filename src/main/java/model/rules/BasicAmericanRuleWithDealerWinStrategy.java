package model.rules;

public class BasicAmericanRuleWithDealerWinStrategy implements Game {
  @Override
  public NewGameStrategy getNewGameStrategy() {
    return new AmericanNewGameStrategy();
  }

  @Override
  public HitStrategy getHitStrategy() {
    return new BasicHitStrategy();
  }

  @Override
  public WinStrategy getWinStrategy() {
    return new DealerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyAmericanNewGameStrategy(this.getNewGameStrategy());
    visitor.applyBasicHitStrategy(this.getHitStrategy());
    visitor.applyDealerWinStrategy(this.getWinStrategy());
  }
}
