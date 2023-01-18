package dario.blackjack;

import java.util.Random;

class Deck {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Deck
	//
	// Synopsis				:   This class represents an American cards deck.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
	private Card[] deck;							// The member that represents all the cards
	private int topCard;							// A pointer to the top card of the deck
	
	public Deck () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Deck
		//
		// Method parameters	:	void
		//
		// Method return		:	Deck A new instance of the Deck class
		//
		// Synopsis				:   Creates a new instance of the Deck class. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
		this.topCard = 0;							// Set the top card pointer to 0
		
		int cardCounter = 0;						// Declare and set a counter through the cards
		
		this.deck = new Card[52];					// Set the deck as a new array of 52 Cards
		
													// Loop through the amount of suits
		for(int cardSuitCounter  = 0; cardSuitCounter < 4; cardSuitCounter ++) {
				
													// Loop through the amount of card values
			for(int cardValueCounter  = 0; cardValueCounter < 13; cardValueCounter ++) {
								
													// Set the position in the counter to the card with the corresponding
													// suit and value
				this.deck[cardCounter] = new Card(cardSuitCounter, cardValueCounter);
				
				cardCounter++;						// Increment the coutner
			}
		}
	}
	public void shuffle () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void shuffle
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shuffles the deck. It creates a new array with random positions to swap them 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		Random rand = new Random();								// Create a random instance of Random
		
		Card temporalCard;										// Declare a temporal card for the swap
		
		int[] randomSwapArray = new int[52];					// Declare and create an array of 52 integers
		
																// Loop through the array we just created
		for (int randomArrayCount = 0; randomArrayCount < randomSwapArray.length; randomArrayCount ++) {
			
																// Set the value as a random integer between 0 and 51
			randomSwapArray[randomArrayCount] = rand.nextInt(randomSwapArray.length);
		}
																// Loop through the deck cards
		for (int deckArrayCount  = 0; deckArrayCount  < this.deck.length; deckArrayCount ++) {
			
			temporalCard = this.deck[deckArrayCount];			// Store the value in the current position to the temporal variable
			
																// Store the value of the random position in the current position
			this.deck[deckArrayCount] = this.deck[randomSwapArray[deckArrayCount]];
			
																// Store the stores value in the random position
			this.deck[randomSwapArray[deckArrayCount]] = temporalCard;
		}
		this.topCard = 0;										// Set the top card pointer to the first element of the array
	}
	public Card getNextCard() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Card getNextCard
		//
		// Method parameters	:	void
		//
		// Method return		:	Cards The top card of the deck.
		//
		// Synopsis				:   Returns the top card of the deck.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		Card temporalCard = this.deck[this.topCard];		// Store the top card into a variable
		
		this.topCard++;										// Increment the top card pointer
		
		return temporalCard;								// Return the stored card
	}
}
