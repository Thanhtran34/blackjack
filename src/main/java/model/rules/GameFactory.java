package model.rules;

/**
 * A class for Game factory (concrete factory).
 * 
 */
public class GameFactory implements GameAbstractFactory {
  @Override
  public Game createBasicAmericanRuleWithDealerWinStrategy() {
    return new BasicAmericanRuleWithDealerWinStrategy();
  }

  @Override
  public Game createBasicAmericanRuleWithPlayerWinStrategy() {
    return new BasicAmericanRuleWithPlayerWinStrategy();
  }

  @Override
  public Game createSoftSevenTeenAmericanRuleWithPlayerWinStrategy() {
    return new SoftSevenTeenAmericanRuleWithPlayerWinStrategy();
  }

  @Override
  public Game createSoftSevenTeenAmericanRuleWithDealerWinStrategy() {
    return new SoftSevenTeenAmericanRuleWithDealerWinStrategy();
  }

  @Override
  public Game createBasicInternationalRuleWithDealerWinStrategy() {
    return new BasicInternationalRuleWithDealerWinStrategy();
  }

  @Override
  public Game createBasicInternationalRuleWithPlayerWinStrategy() {
    return new BasicInternationalRuleWithPlayerWinStrategy();
  }

  @Override
  public Game createSoftSevenTeenInternationalRuleWithPlayerWinStrategy() {
    return new SoftSevenTeenInternationalRuleWithPlayerWinStrategy();
  }

  @Override
  public Game createSoftSevenTeenInternationalRuleWithDealerWinStrategy() {
    return new SoftSevenTeenInternationalRuleWithDealerWinStrategy();
  }
}
