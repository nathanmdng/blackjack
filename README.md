# blackjack

### Create a game of blackjack played by AI
#### Stage 1

To start the assignment try and create a game with N number of players and deal them 2 cards each, remember to keep track of the state of the deck. Then by printing the state of the game you should have something like this...

```java
Game game = new Game(5);
game.start();
game.showGameState();
```

```
Player 1 has hand [NINE of DIAMONDS, ACE of CLUBS] for total [10, 20]
Player 2 has hand [EIGHT of HEARTS, EIGHT of DIAMONDS] for total [16]
Player 3 has hand [ACE of SPADES, FIVE of HEARTS] for total [6, 16]
Player 4 has hand [ACE of DIAMONDS, TWO of SPADES] for total [3, 13]
Player 5 has hand [THREE of CLUBS, QUEEN of HEARTS] for total [13]
```

#### Stage 2

Add some players and play one round.  Output can look like this...

```
=== Dealing cards ===
=== Begin game state ===
Player 1 has hand [FOUR of SPADES, TEN of HEARTS] for total [14]
Player 2 has hand [EIGHT of DIAMONDS, THREE of CLUBS] for total [11]
Player 3 has hand [FOUR of DIAMONDS, FIVE of DIAMONDS] for total [9]
Player 4 has hand [TWO of DIAMONDS, TWO of HEARTS] for total [4]
Player 5 has hand [FIVE of SPADES, NINE of CLUBS] for total [14]
=== Players draw cards ===
Player 1 draws JACK of HEARTS for [24]
Player 1 busts with 24
Player 2 draws KING of SPADES for [21]
Player 2 stands on 21
Player 3 draws SIX of SPADES for [15]
Player 3 draws JACK of CLUBS for [25]
Player 3 busts with 25
Player 4 draws SEVEN of DIAMONDS for [11]
Player 4 draws TEN of CLUBS for [21]
Player 4 stands on 21
Player 5 draws SEVEN of HEARTS for [21]
Player 5 stands on 21
=== End game state ===
Player 1 has hand [FOUR of SPADES, TEN of HEARTS, JACK of HEARTS] for total [24]
Player 2 has hand [EIGHT of DIAMONDS, THREE of CLUBS, KING of SPADES] for total [21]
Player 3 has hand [FOUR of DIAMONDS, FIVE of DIAMONDS, SIX of SPADES, JACK of CLUBS] for total [25]
Player 4 has hand [TWO of DIAMONDS, TWO of HEARTS, SEVEN of DIAMONDS, TEN of CLUBS] for total [21]
Player 5 has hand [FIVE of SPADES, NINE of CLUBS, SEVEN of HEARTS] for total [21]
=== Winners ===
Player 2 wins with 21
Player 4 wins with 21
Player 5 wins with 21
```
