package dario.blackjack;

import java.awt.Dimension;

class Player {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Player
	//
	// Synopsis				:   This class represents a player of a blackjack game.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
	private int money;								// Class member that represents the player's money
	
	private int bet;								// Class member that represents the amount the player has bet
	
	private Hand hand;								// Class member that represents the player's hand
	
	private Dimension handPosition;					// Class member that represents the position of the hand in the
													// interface
	public Player (Dimension position) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Player
		//
		// Method parameters	:	Dimension The position where the hand is displayed in the interface.
		//
		// Method return		:	Player A new instance of the Player class
		//
		// Synopsis				:   Creates a new instance of the Player class with a hand in the specified positions. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
		this.handPosition = position;				// Set the hand position with the position from the parameter
		
		this.money = 100;							// Set the player's money to 100
		
		this.bet = 0;								// Set the bet as 0
		
		this.hand = new Hand(this.handPosition);	// Set the hand as a new Hand in the position from the parameter
	}
	public int getMoney() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int getMoney
		//
		// Method parameters	:	void
		//
		// Method return		:	int The player's money
		//
		// Synopsis				:   Returns the player's current money. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.money;				// Return the player's money
	}
	public Hand getHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Hand getHand
		//
		// Method parameters	:	void
		//
		// Method return		:	Hand The player's hand
		//
		// Synopsis				:   Returns the player's Hand. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.hand;				// Return the player's hand
	}
	public void resetHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void resetHand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Resets the player's Hand
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.bet = 0;					// Reset the bet
		
		this.hand.resetHand();			// Reset the Hand
	}
	public int countHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int countHand
		//
		// Method parameters	:	void
		//
		// Method return		:	int The blackjack value of the hand
		//
		// Synopsis				:   Returns the blackjack value of the player's hand
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.hand.countHand();				// Return the blackjack value of the Hand
	}
	public void grabCard (Card newCard) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void grabCard
		//
		// Method parameters	:	Card The card dealt to the player
		//
		// Method return		:	void
		//
		// Synopsis				:   Adds a card to the hand
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		this.hand.addCard(newCard);					// Adds the card obtained from the parameter to the Hand
	}
	public void bet(int betAmount) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void bet
		//
		// Method parameters	:	int The amount bet by the player
		//
		// Method return		:	void
		//
		// Synopsis				:   This method bets the amount passed as parameter.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.money -= betAmount;				// Subtracts the betting amount from the player's money
		this.bet = betAmount;					// Sets the betting amount
	}
	public void winBet() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void winBet
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is called when a player wins a round.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.money += this.bet * 2;			// Add to the player's money twice the bet (what is on the pot
	}
}
