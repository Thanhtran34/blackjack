package model.rules;

/**
 * A class for International style with Dealer Win Strategy.
 * 
 */
public class BasicInternationalRuleWithDealerWinStrategy implements Game {
  @Override
  public NewGameStrategy getNewGameStrategy() {
    return new InternationalNewGameStrategy();
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
    visitor.applyInternationalNewGameStrategy(this.getNewGameStrategy());
    visitor.applyBasicHitStrategy(this.getHitStrategy());
    visitor.applyDealerWinStrategy(this.getWinStrategy());
  }
}
