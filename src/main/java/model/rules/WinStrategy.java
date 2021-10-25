package model.rules;

import model.Dealer;
import model.Player;

/**
 * A class for general win strategy.
 * 
 */
public interface WinStrategy {
  public boolean isWinner(Player player, Dealer dealer, int score);
}
