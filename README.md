# A3_2_3

Assignment 3, grade 2 and 3.

## Welcome to Black Jack Game

- This is an implementation of a simple Black Jack game (American Style) which uses GoF pattern like Startegy Pattern, Abstract Factory Pattern and Obsever Pattern to increase the cohesion and to achieve the low coupling among classes. This apps follos MVC pattern to separate view, controller and model package.

**SofSevenTeenStrategy**
- This strategy will let the Dealer continue to get more card if Dealer has SoftAce which means that DealerScore is 17 with combination of Ace and (Ace, two, two, two). This accepts Dealer to have more card on hand if his score is under 17 too.
- Unit test for this strategy is in the test folder.

**WinStrategy**
- This apps will use DealerWinStrategy to play as follow:

+ If the DealerScore is equal to PlayerScore together with the PlayerScore is not 21 then the Dealer is the winner.
+ If the PlayerScore is over 21 or DealerScore is equal to 21 then the Dealer is the winner.
+ If the DealerScore is larger than the PlayerScore and the PlayserScore is not 21 then the Dealer is the winner.

**PlayGame**
- It will have a pause whenever the Dealer or the Player get their cards with the help of Observer pattern and the text
will be shown in different color in Console to make this game more interesting.

