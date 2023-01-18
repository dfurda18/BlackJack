# BlackJack
It is a single-player card game where the computer is the dealer.
The game will keep money and bets until one of them runs out of money.

## System Requirements Summary

* Java Version 8 Update 311 or later
* Processor: 1.1 GHz or faster with 2 or more cores
* RAM: 4Gb
* Storage: 70 Gb
* Graphics: Graphics card compatible with DirectX 12 or later with WDDM 2.0 driver
* Display: HD display greater than 9” diagonally, 8 bits per colour channel
* Internet
* Keyboard: Needed for both modes of the application.
* Mouse: Needed only for window mode.

## Assumptions and Dependencies

* Having 5 cards with less than 21 is called a “Monty”.
* Going over 21 is called a “Bust”.
* For any tie, the hand is given to the player.
* Only 5 cards can be hit to any player.
* If a player has a Monty, that player wins.
* When the game starts, the player and the dealer have the same amount of money.

## Feature Cuts and Unsupported Scenarios

* Only one deck will be used.
*All cards are shown for both players.
* Blackjack is considered as the same value as 21.
* The player can only do the following actions:
  * Bet: Sets an amount of money to bet. The dealer will match that bet and the bet can only be as high as the lowest between the player and the dealer.
  * New hand: Starts a new hand once a hand is over.
  * Hit: Deals a new card to the player.
  * Stand: Finished the players decision.
