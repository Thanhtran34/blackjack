package controller;

import model.Game;
import model.Observer;
import view.View;


/**
 * Scenario controller for playing the game.
 */
public class Player implements Observer {
  private Game game;
  private View view;

  public Player(Game game, View view) {
    this.game = game;
    this.view = view;
    game.addGameObserver(this);
    game.getPlayer().setObserver(this);
    game.getDealer().setObserver(this);
  }

  /**
   * Runs the play use case.
   *
   * @return True as long as the game should continue.
   */
  public boolean play() {
    view.displayWelcomeMessage();
    this.showHands();

    if (game.isGameOver()) {
      view.displayGameOver(game.isDealerWinner());
    }

    int input = view.getInput();

    if (input == 'p') {
      game.newGame();
    } else if (input == 'h') {
      game.hit();
    } else if (input == 's') {
      game.stand();
    }

    return input != 'q';
  }

  /**
   * Method to show hands of dealer and player.
   * 
   */
  private void showHands() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }

  @Override
  public void update() {
    this.showHands();
  }
}