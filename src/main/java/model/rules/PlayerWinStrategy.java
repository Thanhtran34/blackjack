package model.rules;

import model.Dealer;
import model.Player;

public class PlayerWinStrategy implements WinStrategy {

  @Override
  public boolean isWinner(Player player, Dealer dealer, int score) {
    int playerScore = player.calcScore();
    int dealerScore = dealer.calcScore();

    if (dealerScore > score) {
      return false;
    } else if (playerScore > score) {
      return true;
    }

    return dealerScore < playerScore;
  }
}
