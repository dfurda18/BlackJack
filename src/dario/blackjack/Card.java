package dario.blackjack;

import javax.swing.ImageIcon;

class Card {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Card
	//
	// Synopsis				:   This class represents an American card.
	//							Images of the cards were obtained from: 
	//									https://code.google.com/archive/p/vector-playing-cards/
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
	private static String[] suitNames = {			// A static array with the name of suits
			"hearts",
			"diamonds",
			"spades",
			"clubs"
	};
	private static String[] valueNames = {			// A static array with the name of values
			"ace",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"jack",
			"queen",
			"king"
	};
	private int cardSuit;							// The card's suit
	
	private int cardValue;							// The card's value
	
	private ImageIcon image;						// The image that represents the card
	
	public Card (int suit, int value) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Card
		//
		// Method parameters	:	int The card's suit.
		//							int The card's value.
		//
		// Method return		:	Card A new instance of the Card class
		//
		// Synopsis				:   Creates a new instance of the Card class with a the speficied suit and value. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
		this.cardSuit = suit;						// Set the card's suit with the suit passed as parameter
		
		this.cardValue = value;						// Set the card's value with the value passed as parameter
		
													// Set the card's image as the image using the value and suit
		this.image = new ImageIcon(getClass().getResource("/images/cards/"+Card.valueNames[this.cardValue]+"_of_"+Card.suitNames[this.cardSuit]+".png"));
	}
	public int getCardValue() {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	int getCardValue
	//
	// Method parameters	:	void
	//
	// Method return		:	int The card's value
	//
	// Synopsis				:   Returns the card's value. 
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.cardValue;				// Return the card's value
	}
	public int getCardSuit()
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Method				:	int getCardSuit
	//
	// Method parameters	:	void
	//
	// Method return		:	int The card's suit
	//
	// Synopsis				:   Returns the card's suit. 
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
	{
		return this.cardSuit;				// Return the card's suit
	}
	public ImageIcon getImage() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	ImageIcon getImage
		//
		// Method parameters	:	void
		//
		// Method return		:	ImageIcon The card's image
		//
		// Synopsis				:   Returns the card's image. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
		return this.image;					// Return the card's image
	}
	public int getBlackJackValue () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int getBlackJackValue
		//
		// Method parameters	:	void
		//
		// Method return		:	int The value of the card for the BlackJack game rules.
		//
		// Synopsis				:   Returns the value of the card for the BlackJack game rules. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
		switch(this.cardValue) {			// Check the value of the card
		case 0:
			return 11;						// If it is an ace, return 0
		case 10:
		case 11:
		case 12:
			return 10;						// If it's jack, queen or king, return 10
		default:
			return this.cardValue + 1;		// Return the card's value +1
		}
	}
}
