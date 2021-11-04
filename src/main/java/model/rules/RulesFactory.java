package model.rules;

/** Creates concrete rules. */
public class RulesFactory {

  /**
   * Creates the rule to use for the dealer's hit behavior.
   *
   * @return The rule to use
   */
  public HitStrategy getHitRule() {
    return new SoftSevenTeenHitStrategy();
  }

  /**
   * Create the rule to use when starting a new game.
   *
   * @return The rule to use.
   */
  public NewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  /**
   * Create the rule to use the winner strategy.
   *
   * @return The rule to use.
   */
  public WinStrategy getWinnerStrategy() {
    return new DealerWinStrategy();
  }
}
