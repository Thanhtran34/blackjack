package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.rules.DealerWinStrategy;
import model.rules.RulesFactory;
import model.rules.SoftSevenTeenStrategy;

public class StrategyTest {
  private Player dealer = new Player();
  private RulesFactory rulesFactory = new RulesFactory();
  private Player player = new Player();
  private Dealer dealerD = new Dealer(rulesFactory);
  private final int maxScore = 21;
  private int dealerScore;
  private int playerScore;
  private int score;
  private boolean hasAce = true;
  private SoftSevenTeenStrategy softAce = new SoftSevenTeenStrategy();
  private DealerWinStrategy dealerStrategy = new DealerWinStrategy();

  @Test
  @DisplayName("Test SoftSevenTeenstrategy")
  public void shouldReturnTrueIfDealerHasSoftAce() {
    score = 17;
    score = dealer.calcScore();
    hasAce = dealer.hasSoftAceCard();
    Assertions.assertEquals(softAce.doHit(dealer), true);
  }

  @Test
  @DisplayName("Test SoftSevenTeenstrategy")
  public void shouldReturnTrueIfDealerScoreIsNotSevenTeen() {
    score = 16;
    score = dealer.calcScore();
    Assertions.assertEquals(softAce.doHit(dealer), true);
  }

  @Test
  @DisplayName("Test DealerWinStrategy")
  public void shouldReturnTrueIfDealerWin() {
    dealerScore = 20;
    playerScore = 18;
    dealerScore = dealer.calcScore();
    playerScore = player.calcScore();
    Assertions.assertEquals(dealerStrategy.isWinner(player, dealerD, maxScore), true);
  }

  @Test
  @DisplayName("Test DealerWinStrategy")
  public void shouldReturnTrueIfDealerWinWithSameScore() {
    dealerScore = 18;
    playerScore = 18;
    dealerScore = dealer.calcScore();
    playerScore = player.calcScore();
    Assertions.assertEquals(dealerStrategy.isWinner(player, dealerD, maxScore), true);
  }
}
