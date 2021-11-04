package model.rules;

public class SoftSevenTeenInternationalRuleWithDealerWinStrategy implements Game {
  @Override
  public NewGameStrategy getNewGameStrategy() {
    return null;
  }

  @Override
  public HitStrategy getHitStrategy() {
    return null;
  }

  @Override
  public WinStrategy getWinStrategy() {
    return null;
  }

  @Override
  public void accept(GameVisitor a_visitor) {}
}
