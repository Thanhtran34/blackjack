package model.rules;

/**
 * An interface for Game Abstract Factory (Abstract Factory).
 * 
 */
public interface GameAbstractFactory {
  Game createBasicAmericanRuleWithDealerWinStrategy();

  Game createBasicAmericanRuleWithPlayerWinStrategy();

  Game createSoftSevenTeenAmericanRuleWithPlayerWinStrategy();

  Game createSoftSevenTeenAmericanRuleWithDealerWinStrategy();

  Game createBasicInternationalRuleWithDealerWinStrategy();

  Game createBasicInternationalRuleWithPlayerWinStrategy();

  Game createSoftSevenTeenInternationalRuleWithPlayerWinStrategy();

  Game createSoftSevenTeenInternationalRuleWithDealerWinStrategy();
}
