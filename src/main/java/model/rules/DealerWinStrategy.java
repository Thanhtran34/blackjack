package model.rules;

import model.Dealer;
import model.Player;

/** A class for dealer winning streategy. */
public class DealerWinStrategy implements WinStrategy {

  @Override
  public boolean isWinner(Player player, Dealer dealer, int score) {
    int playerScore = player.calcScore();
    int dealerScore = dealer.calcScore();

    if (dealerScore > playerScore && dealerScore < score) {
      return true;
    }
    if (playerScore > score || dealerScore == score) {
      return true;
    }
    if (dealerScore == playerScore && playerScore != score) {
      return true;
    }
    return false;
  }
}
