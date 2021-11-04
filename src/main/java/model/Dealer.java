package model;

import model.rules.Game;
import model.rules.HitStrategy;
import model.rules.NewGameStrategy;
import model.rules.WinStrategy;

/** Represents a dealer player that handles the deck of cards and runs the game using rules. */
public class Dealer extends Player {

  private Deck deck;
  private NewGameStrategy newGameRule;
  private HitStrategy hitRule;
  private WinStrategy winStrategy;

  /** Initializing constructor. * */
  public Dealer(Game g) {

    newGameRule = g.getNewGameStrategy();
    hitRule = g.getHitStrategy();
    winStrategy = g.getWinStrategy();
  }

  /**
   * Starts a new game if the game is not currently under way.
   *
   * @param player - The player to play agains.
   * @return True - if the game could be started.
   */
  public boolean newGame(Player player) {
    if (deck == null || isGameOver()) {
      deck = new Deck();
      clearHand();
      player.clearHand();
      return newGameRule.newGame(this, player);
    }
    return false;
  }

  /**
   * Gives the player one more card if possible. I.e. the player hits.
   *
   * @param player - The player to give a card to.
   * @return true - if the player could get a new card, false otherwise.
   */
  public boolean hit(Player player) {
    if (deck != null && player.calcScore() < maxScore && !isGameOver()) {
      dealCard(player, true);
      return true;
    }
    return false;
  }

  /**
   * Checks if the dealer is the winner compared to a player.
   *
   * @param player - The player to check agains.
   * @return True - if the dealer is the winner, false if the player is the winner.
   */
  public boolean isDealerWinner(Player player) {
    return winStrategy.isWinner(player, this, maxScore);
  }

  /**
   * Checks if the game is over, i.e. the dealer can take no more cards.
   *
   * @return True - if the game is over.
   */
  public boolean isGameOver() {
    if (deck != null && hitRule.doHit(this) != true) {
      return true;
    }
    return false;
  }

  /** The player has choosen to take no more cards, it is the dealers turn. */
  public boolean stand(Player player) {
    if (deck != null) {
      showHand();
      while (hitRule.doHit(this) == true) {
        hit(this);
      }
    }
    return false;
  }

  /**
   * Method to get the card from deck and add to dealer's hand.
   *
   * @param player - the player of the game.
   * @param isShown - check if the card is hidden to show.
   */
  public void dealCard(Player player, boolean isShown) {
    Card c = deck.getCard();
    c.show(isShown);
    player.dealCard(c);
  }
}
