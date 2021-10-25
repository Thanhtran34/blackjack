package model.rules;

import model.Dealer;
import model.Player;

public interface WinStrategy {
    public boolean isWinner(Player player, Dealer dealer, int score);
}
