package model;

/** Represents an immutable common playing card that is hidden i.e. face down. */
public class Card {

  /** Represents the four playing card colors, as well as a hidden color. */
  public enum Color {
    Hearts,
    Spades,
    Diamonds,
    Clubs,
    Count,
    Hidden
  }

  /** Represents the 13 card values, as well as a hidden value. */
  public enum Value {
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Knight,
    Queen,
    King,
    Ace,
    Count,
    Hidden
  }

  private Color color;
  private Value value;
  protected boolean isHidden;
  protected boolean isVisible;

  /**
   * Initalizing constructor that creates a hidden card.
   *
   * @param color The color of the card.
   * @param value The value of the card.
   */
  public Card(Color color, Value value) {
    this.value = value;
    this.color = color;
    isHidden = true;
  }

  /**
   * Returns the color of the card or hidden if the card is face down.
   *
   * @return The card color.
   */
  public Color getColor() {
    if (isHidden) {
      return Color.Hidden;
    }
    return color;
  }

  /**
   * returns the value of the card or hidden if the card is face down.
   *
   * @return The card value.
   */
  public Value getValue() {
    if (isHidden) {
      return Value.Hidden;
    }
    return value;
  }

  /**
   * Method to show hidden card.
   *
   * @param isShown true if the card is to be shown.
   */
  public void show(boolean isShown) {
    isHidden = !isShown;
  }

  /** Method for marking that a card is aldready shown. */
  public void markCardOnTable() {
    isVisible = true;
  }

  /** Method for checking if card is shown. */
  public boolean isCardOnTable() {
    return isVisible;
  }
}
