package model.rules;

public class SoftSevenTeenInternationalRuleWithDealerWinStrategy implements Game {
  @Override
  public NewGameStrategy getNewGameStrategy() {
    return new InternationalNewGameStrategy();
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
    visitor.applyInternationalNewGameStrategy(this.getNewGameStrategy());
    visitor.applySoftSevenTeenHitStrategy(this.getHitStrategy());
    visitor.applyDealerWinStrategy(this.getWinStrategy());
  }
}
