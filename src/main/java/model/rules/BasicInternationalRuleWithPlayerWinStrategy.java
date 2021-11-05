package model.rules;

/**
 * A class for International style with Player Win Strategy.
 * 
 */
public class BasicInternationalRuleWithPlayerWinStrategy implements Game {
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
    return new PlayerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyInternationalNewGameStrategy(this.getNewGameStrategy());
    visitor.applyBasicHitStrategy(this.getHitStrategy());
    visitor.applyPlayerWinStrategy(this.getWinStrategy());
  }
}
