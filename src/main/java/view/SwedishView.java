package view;

import controller.Player.InputMenu;

/** Implements a Swedish console view. */
public class SwedishView implements View {
  private Input userChoice;

  public SwedishView() {
    userChoice = new Input();
  }

  /** Shows a welcome message. */
  public void displayWelcomeMessage() {
    userChoice.createLines();
    System.out.println("Hej Black Jack Världen");
    System.out.println("----------------------");
    System.out.println(
        "Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
  }

  /**
   * Returns pressed characters from the keyboard.
   *
   * @return the pressed character.
   */
  public InputMenu getInput() {
    return userChoice.getUserInput();
  }

  /**
   * Displays a card.
   *
   * @param card The card to display.
   */
  public void displayCard(model.Card card) {
    if (card.isCardOnTable() == false) {
      try {
        Thread.sleep(1500);
        card.markCardOnTable();
        System.out.println("\033[0;33m" + "***paus***");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (card.getColor() == model.Card.Color.Hidden) {
      System.out.println("Dolt Kort");
    } else {
      String[] colors = {"Hjärter", "Spader", "Ruter", "Klöver"};
      String[] values = {
        "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung",
        "ess"
        };
      System.out.println(
          "\033[0;32m"
              + ""
              + colors[card.getColor().ordinal()]
              + " "
              + values[card.getValue().ordinal()]);
    }
  }

  public void displayPlayerHand(Iterable<model.Card> hand, int score) {
    displayHand("Spelare", hand, score);
  }

  public void displayDealerHand(Iterable<model.Card> hand, int score) {
    displayHand("Croupier", hand, score);
  }

  /**
   * Displays the winner of the game.
   *
   * @param dealerIsWinner True if the dealer is the winner.
   */
  public void displayGameOver(boolean dealerIsWinner) {
    System.out.println("Slut: ");
    if (dealerIsWinner) {
      System.out.println("\033[1;31m" + "Croupiern Vann!");
    } else {
      System.out.println("\033[1;31m" + "Du vann!");
    }
  }

  private void displayHand(String name, Iterable<model.Card> hand, int score) {
    System.out.println(name + " Har: " + score);
    for (model.Card c : hand) {
      displayCard(c);
    }
    System.out.println("Poäng: " + score);
    System.out.println("");
  }
}
