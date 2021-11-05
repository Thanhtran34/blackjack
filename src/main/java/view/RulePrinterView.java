package view;

import model.rules.GameVisitor;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

/**
 * A class for printing out the rules of the game.
 * 
 */
public class RulePrinterView implements GameVisitor {
  @Override
  public void applyAmericanNewGameStrategy(NewGameStrategy newGameStrategy) {
    System.out.println("New Game Strategy: American New Game Strategy!");
  }

  @Override
  public void applyInternationalNewGameStrategy(NewGameStrategy newGameStrategy) {
    System.out.println("New Game Strategy: International New Game Strategy!");
  }

  @Override
  public void applyBasicHitStrategy(HitStrategy hitStrategy) {
    System.out.println("Hit Strategy: Basic Hit Strategy!");
  }

  @Override
  public void applySoftSevenTeenHitStrategy(HitStrategy hitStrategy) {
    System.out.println("Hit Strategy: Soft17 Hit Strategy!");
  }

  @Override
  public void applyDealerWinStrategy(WinStrategy dealerWinStrategy) {
    System.out.println("Win Strategy: Dealer Win Strategy!");
  }

  @Override
  public void applyPlayerWinStrategy(WinStrategy playerWinStrategy) {
    System.out.println("Win Strategy: Player Win Strategy!");
  }
}
