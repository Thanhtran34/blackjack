package model.rules;

/**
 * A class for basic American style with Player Win Strategy.
 * 
 */
public class BasicAmericanRuleWithPlayerWinStrategy implements Game {
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
    return new PlayerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyAmericanNewGameStrategy(this.getNewGameStrategy());
    visitor.applyBasicHitStrategy(this.getHitStrategy());
    visitor.applyPlayerWinStrategy(this.getWinStrategy());
  }
}
