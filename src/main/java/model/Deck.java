package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a deck of playingcards.
 */
public class Deck {

  private List<Card> cards;
  

  /**
   * Creates a deck with 52 cards of every color and value in random order.
   */
  public Deck() {
    cards = new LinkedList<Card>();

    for (int colIx = 0; colIx < Card.Color.Count.ordinal(); colIx++) {
      for (int valIx = 0; valIx < Card.Value.Count.ordinal(); valIx++) {
        Card c = new Card(Card.Color.values()[colIx], Card.Value.values()[valIx]);
        addCard(c);
      }
    }

    shuffle();
  }

  private void addCard(Card cardToAdd) {
    cards.add(cardToAdd);
  }

  /**
   * Gets the first card in the deck. The card is removed from the deck.

   * @return the card to get and remove.
   */
  public Card getCard() {
    Card c = cards.get(0);
    cards.remove(0);

    return c;
  }

  private void shuffle() {
    
    for (int i = 0; i < 1017; i++) {
      int index = ThreadLocalRandom.current().nextInt(cards.size());
      Card c = cards.get(index);
      cards.remove(index);
      addCard(c);
    }
  }

}