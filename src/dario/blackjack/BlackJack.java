package dario.blackjack;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class BlackJack {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	BlackJack
	//
	// Synopsis				:   This class represents a blackjack game.
	//							Images of the cards were obtained from: 
	//										https://code.google.com/archive/p/vector-playing-cards/
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-18		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

	public static Deck deck;								// The game's deck
	
	public static Player dealer;							// The player
	
	public static Player player;							// The dealer
	
	private static BlackJackInterface blackJackInterface;	// The blackjack graphical interface
	
	private static int numericBet;							// Declare an integer for the bet amount
	
	public static void begin () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void begin
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method starts the BlackJack's game
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		deck = new Deck();								// Create the deck object
		
		dealer = new Player(new Dimension(280,20));		// Create the dealer object
		
		player = new Player(new Dimension(280,280));	// Create the player object
		
		BlackJack.declareInterface();					// Create the Interface
		
	}
	
	private static void declareInterface() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void declareInterface
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method declare's the Graphical interface
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		blackJackInterface = new BlackJackInterface();							// Creates the BlackJackInterface object
		
		blackJackInterface.setPlayButtonActionListener (new ActionListener(){  	// Set the Play Button action
			
			public void actionPerformed(ActionEvent e){							// Implement the actionPerformed method
				
				BlackJack.play();												// Call the play method
	        }  
	    });
		blackJackInterface.setNewHandButtonActionListener (new ActionListener(){	// Set the New Hand Button action
			
			public void actionPerformed(ActionEvent e){  							// Implement the actionPerformed method
				
				BlackJack.newHandButtonAction();												// Call the resetHand method
	        }  
	    }); 
		blackJackInterface.setHitButtonActionListener (new ActionListener(){	// Set the Hit Button action
			
			public void actionPerformed(ActionEvent e){							// Implement the actionPerformed method
				
				BlackJack.hit();												// Call the hit method
	        }  
	    });  
		blackJackInterface.setStandButtonActionListener (new ActionListener(){	// Set the Stand Button action
			
			public void actionPerformed(ActionEvent e){							// Implement the actionPerformed method
				
				BlackJack.stand();												// Call the stand method
	        }  
	    });  
		blackJackInterface.setContinueButtonActionListener (new ActionListener(){	// Set the Continue Button action
			
			public void actionPerformed(ActionEvent e){								// Implement the actionPerformed method
				
				BlackJack.continueAction();											// Call the continueAction method
	        }  
	    });  
		blackJackInterface.setBetUpdateAction(new CaretListener() { 				// Add the bet's text field a listener
			
			public void caretUpdate(CaretEvent e) {									// This will be execute when the text changes
				
				BlackJack.isBetTextFieldReady();							// Call the function checkBetField
			}													
		});
		
		blackJackInterface.showModal(0, 0);
	}
	private static void play () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void play
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when the Play Button is clicked.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		blackJackInterface.removeTitle();									// Call to the method to remove the title
		
																			// Call to the method to add the Hands to the interface
		blackJackInterface.addHandsToInterface(BlackJack.player, BlackJack.dealer);
		
		BlackJack.resetHand();
	}
	public static void newHandButtonAction () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void resetHand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when a hand is restarted.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		BlackJack.player.bet(BlackJack.numericBet);					// Set the player's bet
		
		BlackJack.dealer.bet(BlackJack.numericBet);					// Set the dealer's bet
		
																	// Refresh the money balance in the interface
		blackJackInterface.refreshMoney(BlackJack.player, BlackJack.dealer);
		
		blackJackInterface.setBet(2* BlackJack.numericBet);			// Show the pot amount in the interface
		
		BlackJack.player.grabCard(BlackJack.deck.getNextCard());	// Deal a card to the player
		
		BlackJack.player.grabCard(BlackJack.deck.getNextCard());	// Deal a card to the player
		
																	// Update the hand count
		blackJackInterface.refreshHandCount(BlackJack.player, BlackJack.dealer);
		
		blackJackInterface.newHandClicked();						// Handle events when a new hand is clicked
	}
	public static void resetHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void resetHand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when a hand is restarted.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		BlackJack.deck.shuffle();									// Shuffle the deck
		
		player.resetHand();											// Reset the player's hand
		
		dealer.resetHand();											// Reset the dealer's hand
		
		blackJackInterface.resetHand();								// Resets the interface for a new hand
	}
	public static void isBetTextFieldReady() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void isBetTextFieldReady
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Verifies the value in bet bet Text Field and displays the corresponding message.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if (blackJackInterface.getBetField().getText().isEmpty()) {			// Check if the text field is empty
			
																			// Shows the bet field message
			blackJackInterface.setBetField("Please place your bet with $10 chips.");		
		} else {
			try {
				BlackJack.numericBet = Integer.parseInt(blackJackInterface.getBetField().getText());		// Parse the first text field's text
																								// into an integer
					
				if(BlackJack.numericBet >= 10 && BlackJack.numericBet%10 == 0) {				// Check is the bet is a multiple of 10 greater than 0
					
					if(BlackJack.numericBet <= BlackJack.player.getMoney()) {			// Check is the bet is not over the player's money
						
						if(BlackJack.numericBet > BlackJack.dealer.getMoney()) {		// Check is the bet is not over the dealer's money
							
																			
																			// Let the user know that the bet will be adjusted so the dealer is all in
							blackJackInterface.setBetField("The dealer is all-in. Click the New Hand button.");		
							
							BlackJack.numericBet = BlackJack.dealer.getMoney();		// Set the numericBet as the dealer's money
						} else {
																			// Let the user know that the new hand button can be clicked
							blackJackInterface.setBetField("Valid bet, you may click the New Hand button.");		
						}
						
						blackJackInterface.showNewHandButton();						// Show the New Hand Button
					} else {
																			// Let the user know that the bet can't be more than what he has
						blackJackInterface.setBetField("You cannot bet more than what you have.");		
					}				
				}else {														// Let the user know that the bet must be multiples of 10
					blackJackInterface.setBetField("The minimum bet is $10 dollars, and it must be a multiple of 10.");		
				}   
			} catch(NumberFormatException exception) {						// Catch an exception if the number is not correctly parsed
				
																			// Let the user know that the bet must be a valid integer
				blackJackInterface.setBetField("Please enter a valid integer.");
			}
		}
		
	}
	private static void hit () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hit
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when the Hit Button is clicked.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		BlackJack.player.grabCard(BlackJack.deck.getNextCard());					// Deal a card to the player
		
		blackJackInterface.refreshHandCount(BlackJack.player, BlackJack.dealer);	// Update the hand count
		
																					// Check is the player has 5 cards 
																					// or has a busted hand
		if(BlackJack.player.getHand().handSize() == 5 || BlackJack.player.getHand().isBusted()) {
			
			BlackJack.endPlayerTurn();												// End the player's turn
		}
	}
	
	private static void stand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void stand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when the Stand Button is clicked.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		BlackJack.endPlayerTurn();					// End the player's turn
	}
	
	private static void continueAction () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void continueAction
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when the Continue Button is clicked.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		blackJackInterface.hideContinueMessage();			// Hide the message and Continue Button
		
		if(BlackJack.gameOver()) {							// Check is the game is over
			
															// Show the game over message with the winner information
			blackJackInterface.showGameOverMessage(BlackJack.playerWinsGame());
		}else {
			BlackJack.resetHand();							// Reset the hand if the game is not over
		}
	}
	public static void endPlayerTurn () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void endPlayerTurn
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that is called when the player's turn has ended.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if(!BlackJack.player.getHand().isBusted()) {		// Check if the player's hand is not busted
			
			BlackJack.dealerActions();						// Perform the dealer's actions
		} else {
			BlackJack.showResults();						// Show the hand's results
		}
	}
	private static void dealerActions () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void dealerActions
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method that performs the dealer's actions.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		blackJackInterface.hideActionButtons();							// Hide the player action buttons
		
																		// Run this while the player is winning, the dealer's hand size is
																		// less than 5, and the dealre's hand is not busted
		while (BlackJack.playerWins() && BlackJack.dealer.getHand().handSize() < 5 && !BlackJack.dealer.getHand().isBusted()) {
		
			BlackJack.dealer.grabCard(BlackJack.deck.getNextCard());	// Deal the dealer a new card
			
																		// Update the count hand information
			blackJackInterface.refreshHandCount(BlackJack.player, BlackJack.dealer);
		}
		BlackJack.showResults();										// Show the hand's results
	}
	private static void showResults () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showResults
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Method shows the hand's results.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if (BlackJack.playerWins()) {						// Check is the player won
			
			blackJackInterface.showHandWonMessage();		// Show the message where the player won the hand
			
			player.winBet();								// Give the player the pot amount
		}else {
			dealer.winBet();								// Give the dealer the pot amount
			
			if (BlackJack.player.getHand().isBusted()) {	// Check it the player's hand is busted
				
				blackJackInterface.showBustedMessage();		// Show the busted message
			} else {
				blackJackInterface.showHandLostMessage();	// Show the hand lost message
			}
		}
	}
	private static boolean playerWins () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playerWins
		//
		// Method parameters	:	void
		//
		// Method return		:	boolean True if the player won and false otherwise.
		//
		// Synopsis				:   Method decides who won thegame and returns true if the player won and false otherwise.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if(BlackJack.player.getHand().isBusted()) {		// Check if the player busted
			
			return false;								// Return false
		}
		if(BlackJack.dealer.getHand().isBusted()) {		// Check if the dealer busted
			
			return true;								// Return true
		}
														// Check if the player has a Monty
		if (BlackJack.player.getHand().handSize() >= 5 && BlackJack.player.getHand().countHand() < 22) {
			
			return true;								// Return true
		}
														// Check if the dealer has a Monty
		if (BlackJack.dealer.getHand().handSize() >= 5 && BlackJack.dealer.getHand().countHand() < 22) {
			
			return false;								// Return false
		}
														// If the dealer has a better hand count than the player
		if(BlackJack.dealer.getHand().countHand() > BlackJack.player.getHand().countHand()) {
			
			return false;								// Return false
		}
		return true;									// Return true
	}
	public static boolean gameOver () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void gameOver
		//
		// Method parameters	:	void
		//
		// Method return		:	boolean True if at least one of the players is out of money.
		//
		// Synopsis				:   Method decides if the game is over.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
												// Check is at least one of the players ran out of money
		if (BlackJack.player.getMoney() <= 0 || BlackJack.dealer.getMoney() <= 0) {
			
			return true;						// Return true
		}else {
			return false;						// Return false
		}
	}
	public static boolean playerWinsGame () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playerWinsGame
		//
		// Method parameters	:	void
		//
		// Method return		:	boolean True the dealer ran out of money, false otherwise.
		//
		// Synopsis				:   Method decides if the player won the game.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if (BlackJack.dealer.getMoney() <= 0) {			// Check if the dealer ran out of money
			
			return true;								// Return true
		}else {
			return false;								// Return false
		}
	}
	public static void main (String[] args) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void main
		//
		// Method parameters	:	String[] The command line execution parameter (not used).
		//
		// Method return		:	void
		//
		// Synopsis				:   Main method of the ClackJack class.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		BlackJack.begin();			// Call the begin method to start the program
	}
}
