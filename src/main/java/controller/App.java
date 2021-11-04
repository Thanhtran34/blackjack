package controller;

import model.Game;
import model.rules.GameAbstractFactory;
import model.rules.GameFactory;
import view.EnglishView;
import view.RulePrinterView;
import view.View;

/** Starts the application using the console. */
public class App {
  /**
   * Starts the game.
   *
   * @param args Not used.
   */
  public static void main(String[] args) {

    GameAbstractFactory gameFactory = new GameFactory();
    model.rules.Game game = gameFactory.createSoftSevenTeenAmericanRuleWithDealerWinStrategy();

    Game g = new Game(game);
    View v = new EnglishView(); // new SwedishView();
    Player ctrl = new Player(g, v);

    RulePrinterView visitor = new RulePrinterView();
    game.accept(visitor);

    while (ctrl.play(g, v)) {}
  }
}
