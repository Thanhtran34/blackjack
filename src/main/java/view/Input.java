package view;

import controller.Player;

/**
 * A class for input from user.
 * 
 */
public class Input {
  /**
   * Returns pressed characters from the keyboard.
   *
   * @return the pressed character.
   */
  public Player.InputMenu getUserInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      if (c == 'p') {
        return Player.InputMenu.PLAY;
      } else if (c == 's') {
        return Player.InputMenu.STAND;
      } else if (c == 'h') {
        return Player.InputMenu.HIT;
      } else if (c == 'q') {
        return Player.InputMenu.QUIT;
      } else {
        return Player.InputMenu.NOTVALID;
      }
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return Player.InputMenu.NOTVALID;
    }
  }

  /** Method to create lines for welcome message. */
  public void createLines() {
    for (int i = 0; i < 50; i++) {
      System.out.print("\n");
    }
  }
}
