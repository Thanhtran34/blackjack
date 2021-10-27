package model;

import java.util.LinkedList;
import java.util.List;

/** Represents a player in the Black Jack game. A Player has a hand of cards. */
public class Player extends Subject {

  private List<Card> hand;
  private Observer observer;
  protected final int hitlimit = 17;
  protected final int maxScore = 21;

  /**
   * An instance of the Player class.
   * 
   */
  public Player() {
    hand = new LinkedList<Card>();
  }

  /**
   * Adds a card to the Player's hand.
   *
   * @param addToHand - The card to add to the hand.
   */
  public void dealCard(Card addToHand) {
    hand.add(addToHand);
  }

  /**
   * Returns the cards in thand.
   *
   * @return the cards in the Player's hand
   */
  public Iterable<Card> getHand() {
    return new LinkedList<Card>(hand);
  }

  /** Removes all cards from the hand. */
  public void clearHand() {
    hand.clear();
  }

  /** Shows all cards in the hand. */
  public void showHand() {
    for (Card c : getHand()) {
      c.show(true);
    }
  }

  /**
   * Calculates the score of the hand according to Black Jack rules.
   *
   * @return The score - the total score
   */
  public int calcScore() {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int[] cardScores = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
    assert (cardScores.length == Card.Value.Count.ordinal())
        : "Card Scores array size does not match number of card values";

    int score = 0;

    for (Card c : getHand()) {
      if (c.getValue() != Card.Value.Hidden) {
        score += cardScores[c.getValue().ordinal()];
      }
    }

    if (score > maxScore) {
      for (Card c : getHand()) {
        if (c.getValue() == Card.Value.Ace && score > maxScore) {
          score -= 10;
        }
      }
    }

    return score;
  }

  /** Method to check if player has Ace. */
  public boolean hasAceCard() {
    if (calcScore() == hitlimit) {
      for (Card c : getHand()) {
        if (c.getValue() == Card.Value.Ace) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Method to set the observer.
   *
   * @param observer - the observer which gets information of update.
   */
  public void setObserver(Observer observer) {
    this.observer = observer;
    notifyObservers();
  }
}
