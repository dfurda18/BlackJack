package dario.blackjack;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hand {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	Hand
	//
	// Synopsis				:   This class represents a hand of a blackjack game.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
	private int cardCounter;						// The counter that points to the next position in the hand
	
	private Card[] cards;							// And Array of cards
	
	private JPanel handDisplay;						// The graphical element of the hand
	
	private static Dimension handContainerSize = new Dimension(525,157);	// The size of the hand graphical element
	
	private static Dimension cardSize = new Dimension(100,147);				// The size of the card graphically
																
													// The Image of the back side of the card 
													// scaled to the card dimension
	private ImageIcon backCardImage = new ImageIcon(new ImageIcon(getClass().getResource("/images/cards/BacksideImage.png")).getImage().getScaledInstance(Hand.cardSize.width,Hand.cardSize.height,Image.SCALE_DEFAULT));
													
	public Hand(Dimension position) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Hand
		//
		// Method parameters	:	Dimension The position where the hand is displayed in the interface.
		//
		// Method return		:	Hand A new instance of the Hand class
		//
		// Synopsis				:   Creates a new instance of the Hand class in the specified positions. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					
		this.handDisplay = new JPanel();							// Instantiate the Hand graphical container
		
		this.handDisplay.setOpaque(false);							// Set the background transparent
		
		this.handDisplay.setPreferredSize(Hand.handContainerSize);	// Set the size of the container
		
																	// Set the bounds of the container to a position and size
		this.handDisplay.setBounds(position.width, position.height,Hand.handContainerSize.width, Hand.handContainerSize.height);
		
		this.handDisplay.setLayout(new FlowLayout(FlowLayout.CENTER));	// Set the layout of the container as a FlowLayout
		
		this.resetHand();											// Reset the hand to its initial state
	}
	public void resetHand() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void resetHand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Resets the hand to its initial state.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

		this.cardCounter = 0;					// Set the card counter to 0
		
		this.cards = new Card[5];				// Set the hand as a new array of cards
		
		this.handDisplay.removeAll();			// Remove all card images from the hand display component
		
		for(int dealerCardCount = 0; dealerCardCount  < 5; dealerCardCount ++) {	// Loop 5 times
			
			this.handDisplay.add(new JLabel(this.backCardImage));		// Set each card with the back side image
		}
	}
	public JPanel getHandDisplay() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	JPanel getHandDisplay
		//
		// Method parameters	:	void
		//
		// Method return		:	JPanel The hand's display component
		//
		// Synopsis				:   Returns the hand's display component
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
		return this.handDisplay;					// Return the Hand's graphical component
	}
	
	public int handSize () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int handSize
		//
		// Method parameters	:	void
		//
		// Method return		:	int The hand size
		//
		// Synopsis				:   Returns the hand's size
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
						
		int handSize = 0;							// Declare and set the hand size as 0
		
		for(int handCounter = 0; handCounter < this.cards.length; handCounter++) {	// Loop through the cards array
			
			if (this.cards[handCounter] != null) {	// Check is there is a card assigned to that position
				
				handSize++;							// Increment the hand size by 1
			}
		}
		return handSize;							// return the hand size
	}
	public int countHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	int countHand 
		//
		// Method parameters	:	void
		//
		// Method return		:	int The hand blackjack count
		//
		// Synopsis				:   Returns the hand's blackjack count
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
						
		int temporalHandCount = 0;				// Declare and set a counter for the blackjack count
		
		int aceCount = 0;						// Declare and set a variable to count aces to 0
		
		for (int playerHandCount = 0; playerHandCount < this.handSize(); playerHandCount++) { // Loop for the amount of cards dealt
			
			temporalHandCount += this.cards[playerHandCount].getBlackJackValue();	// Add the blackjack value of the card
			
			if (this.cards[playerHandCount].getCardValue() == 0) {					// Check is it is an ace
				
				aceCount++;															// Add one to the Ace count
			}
		}
		for (int aceLoopCount = 0; aceLoopCount < aceCount; aceLoopCount++) {		// Loop over the amount of aces
			
			if(temporalHandCount > 21) {											// Check is the hand is busted
				
				temporalHandCount -= 10;											// reduce the difference of ace values
			}
		}
		return temporalHandCount;													// Return the hand value
	}
	public void addCard(Card newCard) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addCard 
		//
		// Method parameters	:	Card The card to add to the hand
		//
		// Method return		:	void
		//
		// Synopsis				:   Adds a card to the card hand
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
					
		this.cards[this.cardCounter] =newCard;					// Sets the card to the cards array
		
																// Sets the image of the card resized to the card dimension
		((JLabel)this.handDisplay.getComponent(this.cardCounter)).setIcon(new ImageIcon(newCard.getImage().getImage().getScaledInstance(cardSize.width,cardSize.height,Image.SCALE_DEFAULT)));
		
		this.cardCounter++;										// Increment the pointer to the next card
		
	}
	public boolean isBusted () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	boolean isBusted 
		//
		// Method parameters	:	void
		//
		// Method return		:	boolean True if the hand is busted, false otherwise.
		//
		// Synopsis				:   Returns true if the Hand is busted, and false otherwise.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
							
		if (this.countHand() > 21) {		// Check if the Hand value is over 21
			
			return true;					// Return true
			
		} else {							// otherwise
			
			return false;					// Return fales
		}
	}
}
