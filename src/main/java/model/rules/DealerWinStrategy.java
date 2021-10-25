package model.rules;

import model.Dealer;
import model.Player;

public class DealerWinStrategy implements WinStrategy {

  @Override
  public boolean isWinner(Player player, Dealer dealer, int score) {
    int playerScore = player.calcScore();
    int dealerScore = dealer.calcScore();

    if (dealerScore > score) {
      return true;
    } else if (playerScore > score) {
      return false;
    }

    return dealerScore >= playerScore;
  }
}
