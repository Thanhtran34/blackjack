package model.rules;

/**
 * An interface for Game Abstract Factory (Abstract Factoty).
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
