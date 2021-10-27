package view;

import controller.Player.InputMenu;

/** Implements an english console view. */
public class EnglishView implements View {

  /** Shows a welcome message. */
  public void displayWelcomeMessage() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
    System.out.println("Hello Black Jack World");
    System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
  }

  /**
   * Returns pressed characters from the keyboard.
   *
   * @return the pressed character.
   */
  public InputMenu getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      if (c == 'p') {
        return InputMenu.PLAY;
      } else if (c == 's') {
        return InputMenu.STAND;
      } else if (c == 'h') {
        return InputMenu.HIT;
      } else if (c == 'q') {
        return InputMenu.QUIT;
      } else {
        return InputMenu.NOTVALID;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return InputMenu.NOTVALID;
    }
  }

  /**
   * Method to display the card on the table.
   * 
   */
  public void displayCard(model.Card card) {
    if (card.isCardShown() == false) {
      try {
        Thread.sleep(1500);
        card.labelCardIsShown();
        System.out.println("\033[0;33m" + "***processing***");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("\033[0;32m" + "" + card.getValue() + " of " + card.getColor());
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Player", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Dealer", hand, score);
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Has: ");
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Score: " + score);
    System.out.println("");
  }

  /**
   * Displays the winner of the game.
   *
   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("GameOver: ");
    if (dealerIsWinner) {
      System.out.println("\033[1;31m" + "Dealer Won!");
    } else {
      System.out.println("\033[1;31m" + "You Won!");
    }
  }
}
