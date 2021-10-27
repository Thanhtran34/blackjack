package model.rules;

import model.Dealer;
import model.Player;

/** A class for player winning streategy. */
public class PlayerWinStrategy implements WinStrategy {

  @Override
  public boolean isWinner(Player player, Dealer dealer, int score) {
    int playerScore = player.calcScore();
    int dealerScore = dealer.calcScore();

    if (playerScore > dealerScore && dealerScore != score) {
      return true;
    }
    if (playerScore > score) {
      return false;
    }
    if (playerScore == dealerScore && playerScore != score) {
      return false;
    }
    return false;
  }
}
