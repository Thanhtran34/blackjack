package model.rules;

public class SoftSevenTeenInternationalRuleWithPlayerWinStrategy implements Game {
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
    return new PlayerWinStrategy();
  }

  @Override
  public void accept(GameVisitor visitor) {
    visitor.applyInternationalNewGameStrategy(this.getNewGameStrategy());
    visitor.applySoftSevenTeenHitStrategy(this.getHitStrategy());
    visitor.applyPlayerWinStrategy(this.getWinStrategy());
  }
}
