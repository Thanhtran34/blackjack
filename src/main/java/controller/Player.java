package controller;

import model.Game;
import model.Observer;
import view.View;

/** Scenario controller for playing the game. */
public class Player implements Observer {
  private Game game;
  private View view;

  public Player(Game game, View view) {
    this.game = game;
    this.view = view;
    game.addGameObserver(this);
    game.setGameObserver(this);
  }

  public enum InputMenu {
    PLAY,
    HIT,
    STAND,
    QUIT,
    NOTVALID
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

    InputMenu input = view.getInput();

    if (input == InputMenu.PLAY) {
      game.newGame();
    } else if (input == InputMenu.HIT) {
      game.hit();
    } else if (input == InputMenu.STAND) {
      game.stand();
    }

    return input != InputMenu.QUIT;
  }

  /** Method to show hands of dealer and player. */
  private void showHands() {
    view.displayDealerHand(game.getDealerHand(), game.getDealerScore());
    view.displayPlayerHand(game.getPlayerHand(), game.getPlayerScore());
  }

  @Override
  public void update() {
    this.showHands();
  }
}
