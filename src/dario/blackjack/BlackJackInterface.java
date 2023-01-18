package dario.blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretListener;

public class BlackJackInterface {
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	// Class				:	BlackJackInterface
	//
	// Synopsis				:   This class represents a blackjack game's Graphical Interface.
	//
	// Modifications		:
	//							Date			Developer				Notes
	//							----			---------				-----
	//							2022-03-16		D. Urdapilleta			Initial setup
	//
	// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
	private static Dimension screenSize = new Dimension (900,600);	// The size of the screen 900x600 fore lower resolution screens
	
	private static Dimension titleSize = new Dimension (622,215);	// The size of the title
	
	private static Dimension bigTitleSize = new Dimension (900,200);// Declare and set a Dimension for the final title
	
	private JPanel[] messageList;									// The list of messages in the modal
	
	private JButton[] buttonList;									// The list of buttons in the modal
	
	private JFrame frame;											// The window frame
	
	private JLayeredPane pane;										// The frame's content frame. It is Layered for modal messages
	
	private JPanel background;										// The panel with the background Image
	
	private JPanel modal;											// The modal background
	
	private JPanel title;											// The Game's Title
	
	private JPanel wonMessage;										// The message when the player won a hand
	
	private JPanel bustedMessage;									// The message when the player busted
	
	private JPanel lostMessage;										// The message when the player lost a hand
	
	private JPanel gameWonMessage;									// The message when the player won the game
	
	private JPanel gameLostMessage;									// The message when the player lost the game
	
	private JPanel playersMoney;									// The panel to show the player's money
	
	private JPanel dealersMoney;									// The panel to show the dealer's money
	
	private JPanel playerHandCount;									// The panel to show the player's hand count
	
	private JPanel dealerHandCount;									// The panel to show the dealer's hand count
	
	private JPanel pot;												// The panel to show the current pot
	
	private JPanel betTextMessage;									// The panel to show the bet text field message
	
	private JButton playButton;										// The Play Button
	
	private JButton newHandButton;									// The New Hand Button
	
	private JButton hitButton;										// The Hit Button
	
	private JButton standButton;									// The Stand Button
	
	private JButton continueButton;									// The Continue Button
	
	private JTextField betField;									// The bet Text field
	
	public BlackJackInterface () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	BlackJackInterface
		//
		// Method parameters	:	void
		//
		// Method return		:	BlackJackInterface A new instance of the BlackJackInterface class
		//
		// Synopsis				:   Creates a new instance of the BlackJackInterface class and shows the window. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.frame = new JFrame("Blackjack");							// Instantiate an new frame for Blackjack
		
		this.messageList = new JPanel[6];								// Start the array of messages
		
		this.buttonList = new JButton[2];								// Start the array of buttons
		
																		// Set the Frame's size to the window size.
		this.frame.setSize(BlackJackInterface.screenSize.width, BlackJackInterface.screenSize.height);
		
		this.frame.setResizable(false);									// Set it as non-resizable
		
		this.frame.setLocationRelativeTo(null);							// Set it not relative to other frames
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Set the default close operation to exit
		
		this.pane = new JLayeredPane();									// Create a new layered pane
		
		this.pane.setPreferredSize(screenSize);							// Set the pane's size to the screen size
		
		this.frame.add(this.pane);										// Add the pane to the frame
		
		this.background = new JPanel();									// Create the background panel
		
		URL url = BlackJackInterface.class.getResource(
                "/images/background.png");
		
		this.background.add(new JLabel(new ImageIcon(url)));	// Add an image to the background
		
		this.background.setPreferredSize(screenSize);					// Set the panel size to the screen size
		
		this.background.setBounds(0,0,screenSize.width, screenSize.height);	// Set the bounds to start at the origin and have the screen size
		
		this.pane.add(this.background, JLayeredPane.FRAME_CONTENT_LAYER);	// Add the background to the layered pane in the position as far back as possible
		
		this.frame.pack();												// Pack the frame
		
		this.frame.setVisible(true);									// Show the frame 
		
		this.modal = new JPanel();										// Create the modal panel
		
		this.modal.setBackground(new Color(0,0,0, 0.3f));				// Set a background color for contrast
		
		this.modal.setBorder(new EmptyBorder(10, 10, 10, 10));			// Set modal's margin to 10 in all directions
		
		this.modal.setLayout(new GroupLayout(this.modal));				// Set the modal's layout
		
		this.modal.setVisible(false);									// Hide the modal
		
		this.pane.add(this.modal, JLayeredPane.MODAL_LAYER);			// Add the title in the modal layer
		
		this.title = new JPanel();										// Create the title panel
		
		this.title.add(new JLabel(new ImageIcon(getClass().getResource("/images/BlackJackTitle.png"))));	// Add the title image to the title
		
		this.title.setPreferredSize(titleSize);							// Set the title size
		
		this.title.setBounds(20,10,BlackJackInterface.titleSize.width, BlackJackInterface.titleSize.height);// Set the location and size
		
		this.title.setOpaque(false);									// Set the background transparent
		
		this.messageList[0] = this.title;								// Add the title to the messages list
		
		this.wonMessage = new JPanel();									// Create the panel for the won message
		
		this.wonMessage.add(new JLabel(new ImageIcon(getClass().getResource("/images/WonMessage.png"))));	// Add the message image to the panel
		
		this.wonMessage.setPreferredSize(titleSize);					// Set the message size
		
		this.wonMessage.setBounds(30, 30, BlackJackInterface.titleSize.width, BlackJackInterface.titleSize.height);		// Set the location and size
		
		this.wonMessage.setOpaque(false);								// Set the background transparent

		this.messageList[1] = this.wonMessage;							// Add the message to the messages list
		
		this.bustedMessage = new JPanel();								// Create the panel for the busted message
		
		this.bustedMessage.add(new JLabel(new ImageIcon(getClass().getResource("/images/BustedMessage.png"))));	// Add the message image to the panel
		
		this.bustedMessage.setPreferredSize(titleSize);					// Set the message size
		
		this.bustedMessage.setBounds(30,30,BlackJackInterface.titleSize.width, BlackJackInterface.titleSize.height);		// Set the location and size
		
		this.bustedMessage.setOpaque(false);							// Set the background transparent
		
		this.messageList[2] = this.bustedMessage;						// Add the message to the messages list
		
		this.lostMessage = new JPanel();								// Create the panel for the lost message
		
		this.lostMessage.add(new JLabel(new ImageIcon(getClass().getResource("/images/LostMessage.png"))));	// Add the message image to the panel
		
		this.lostMessage.setPreferredSize(titleSize);					// Set the message size
		
		this.lostMessage.setBounds(20,40,BlackJackInterface.titleSize.width, BlackJackInterface.titleSize.height);		// Set the location and size
		
		this.lostMessage.setOpaque(false);								// Set the background transparent
			
		this.messageList[3] = this.lostMessage;							// Add the message to the messages list
		
		this.gameWonMessage = new JPanel();								// Create the panel for the game won message
		
		this.gameWonMessage.add(new JLabel(new ImageIcon(getClass().getResource("/images/GameWonMessage.png"))));	// Add the message image to the panel
		
		this.gameWonMessage.setPreferredSize(bigTitleSize);				// Set the message size
		
		this.gameWonMessage.setBounds(0,20,BlackJackInterface.bigTitleSize.width, BlackJackInterface.bigTitleSize.height);		// Set the location and size
		
		this.gameWonMessage.setOpaque(false);							// Set the background transparent
		
		this.messageList[4] = this.gameWonMessage;						// Add the message to the messages list
		
		this.gameLostMessage = new JPanel();							// Create the panel for the game lost message
		
		this.gameLostMessage.add(new JLabel(new ImageIcon(getClass().getResource("/images/GameLostMessage.png"))));	// Add the message image to the panel
		
		this.gameLostMessage.setPreferredSize(bigTitleSize);			// Set the message size
		
		this.gameLostMessage.setBounds(0,0,BlackJackInterface.bigTitleSize.width, BlackJackInterface.bigTitleSize.height);		// Set the location and size
		
		this.gameLostMessage.setOpaque(false);							// Set the background transparent
		
		this.messageList[5] = this.gameLostMessage;						// Add the message to the messages list
		
		this.playersMoney = new JPanel();								// Create the panel that displays the player's money
		
		this.playersMoney.add(new JLabel("Player balance: $"));			// Add a label with no value
		
		this.playersMoney.setBounds(20,300, 140,28);					// Set the panel position and size
		
		this.playersMoney.setBackground(new Color(212,194,168));		// Set a background color for contrast
		
		this.playersMoney.setVisible(false);							// Hide the label
		
		this.pane.add(this.playersMoney, JLayeredPane.DEFAULT_LAYER);	// Add the label to the default layer
		
		this.dealersMoney = new JPanel();								// Create the panel that displays the dealer's money
		
		this.dealersMoney.add(new JLabel("Player balance: $"));			// Add a label with no value
		
		this.dealersMoney.setBounds(20,40, 140,28);						// Set the panel position and size
		
		this.dealersMoney.setBackground(new Color(212,194,168));		// Set a background color for contrast
		
		this.dealersMoney.setVisible(false);							// Hide the label
		
		this.pane.add(this.dealersMoney, JLayeredPane.DEFAULT_LAYER);	// Add the label to the default layer
		
		this.playerHandCount = new JPanel();							// Create the panel that displays the player's hand count
		
		this.playerHandCount.add(new JLabel("Player hand count: "));	// Add a label with no value
		
		this.playerHandCount.setBounds(20,340, 140,28);					// Set the panel position and size
		
		this.playerHandCount.setBackground(new Color(212,194,168));		// Set a background color for contrast
		
		this.playerHandCount.setVisible(false);							// Hide the label
		
		this.pane.add(this.playerHandCount, JLayeredPane.DEFAULT_LAYER);// Add the label to the default layer
		
		this.dealerHandCount = new JPanel();							// Create the panel that displays the dealer's hand count
		
		this.dealerHandCount.add(new JLabel("Player hand count: "));	// Add a label with no value
		
		this.dealerHandCount.setBounds(20,80, 140,28);					// Set the panel position and size
		
		this.dealerHandCount.setBackground(new Color(212,194,168));		// Set a background color for contrast
		
		this.dealerHandCount.setVisible(false);							// Hide the label
		
		this.pane.add(this.dealerHandCount, JLayeredPane.DEFAULT_LAYER);// Add the label to the default layer
		
		this.pot = new JPanel();										// Create the panel that displays the pot
		
		this.pot.add(new JLabel("Pot: $ "));							// Add a label with no value
		
		this.pot.setBounds(475,215, 140,28);							// Set the panel position and size
		
		this.pot.setBackground(new Color(212,194,168));					// Set a background color for contrast
		
		this.pot.setVisible(false);										// Hide the label
		
		this.pane.add(this.pot, JLayeredPane.DEFAULT_LAYER);			// Add the label to the default layer
		
		this.betTextMessage = new JPanel();								// Create the panel that displays the bet text field message
		
		this.betTextMessage.add(new JLabel("Please place your bet with $10 chips."));	// Add a label with the innitial value
		
		this.betTextMessage.setBounds(360, 235, 365, 28);				// Set the panel position and size
		
		this.betTextMessage.setBackground(new Color(212,194,168));		// Set a background color for contrast
		
		this.betTextMessage.setVisible(false);							// Hide the label
		
		this.pane.add(this.betTextMessage, JLayeredPane.DEFAULT_LAYER);	// Add the label to the default layer
		
		this.playButton = new JButton("Play");							// Create the Play Button
		
		this.playButton.setBounds((642-100)/2,250,100, 30);						// Set the Button's position and size
		
		this.buttonList[0] = this.playButton;							// Add the button to the list
		
		this.newHandButton = new JButton("New Hand");					// Create the New Hand Button
		
		this.newHandButton.setBounds(20,500,140, 30);	 				// Set the Button's position and size
		
		this.newHandButton.setVisible(false);							// Hide the Button
		
		this.pane.add(this.newHandButton, JLayeredPane.DEFAULT_LAYER);	// Add the button to the default layer
		
		this.hitButton = new JButton("Hit");							// Create the Hit Button
		
		this.hitButton.setBounds(375,500,140, 30); 						// Set the Button's position and size
		
		this.hitButton.setVisible(false);								// Hide the Button
		
		this.pane.add(this.hitButton, JLayeredPane.DEFAULT_LAYER);		// Add the Button to the default layer
		
		this.standButton = new JButton("Stand");						// Create the Stand Button
		
		this.standButton.setBounds(575,500,140, 30);					// Set the Button's position and size
		
		this.standButton.setVisible(false);								// Hide the Button
		
		this.pane.add(this.standButton, JLayeredPane.DEFAULT_LAYER);	// Add the Button to the default layer	
		
		this.continueButton = new JButton("Continue");					// Create the Continue Button
		
		this.continueButton.setBounds((642-100)/2,250, 100, 30);				// Set the Button's position and size
		
		this.buttonList[1] = this.continueButton;						// Add the button to the list

		this.betField = new JTextField();								// Create the bet text field
		
		this.betField.setColumns(10);									// Set the first number's text field size
		
		this.betField.setBounds(475, 195, 140, 28);						// Set the Button's position and size
		
		this.betField.setVisible(false);								// Hide the Button
		
		this.pane.add(this.betField, JLayeredPane.DEFAULT_LAYER);		// Add the bet field to the default layer
		
		this.frame.repaint();											// Refresh the frame
		
	}

	public void setPlayButtonActionListener (ActionListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setPlayButtonActionListener
		//
		// Method parameters	:	ActionListener The Action to take when the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the Play Button. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.playButton.addActionListener(action); 				// Add the action listener to the button
	}
	public void setNewHandButtonActionListener (ActionListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setNewHandButtonActionListener
		//
		// Method parameters	:	ActionListener The Action to take when the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the New Hand Button. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.newHandButton.addActionListener(action);  			// Add the action listener to the button
	}
	public void setHitButtonActionListener (ActionListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setHitButtonActionListener
		//
		// Method parameters	:	ActionListener The Action to take when the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the Hit Button. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.hitButton.addActionListener(action);  				// Add the action listener to the button
	}
	public void setStandButtonActionListener (ActionListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setStandButtonActionListener
		//
		// Method parameters	:	ActionListener The Action to take when the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the Stand Button. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.standButton.addActionListener(action);				// Add the action listener to the button  
	}
	
	public void setContinueButtonActionListener (ActionListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setContinueButtonActionListener
		//
		// Method parameters	:	ActionListener The Action to take when the button is clicked.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the Continue Button. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.continueButton.addActionListener(action);			// Add the action listener to the button  
	}
	
	public void setBetUpdateAction(CaretListener action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setBetUpdateAction
		//
		// Method parameters	:	CaretListener The Action to take when the field changes.
		//
		// Method return		:	void
		//
		// Synopsis				:   Sets the action specified as parameter to the bet Text Field for when the contents change. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.betField.addCaretListener(action);					// Add the caret listener to the Text Field
	}
	
	public void removeTitle() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void removeTitle
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method is called when the main title needs to be removed at the beginning of
		//							the application. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.hideModal();
		
		this.frame.repaint();								// Repaint the frame
		
		this.playersMoney.setVisible(true);					// Show the Player's money
		
		this.dealersMoney.setVisible(true);					// Show the Dealer's money
		
		this.playerHandCount.setVisible(true);				// Show the Player's hand count
		
		this.dealerHandCount.setVisible(true);				// Show the Dealer's hand count
		
		this.newHandButton.setVisible(true);				// Show the New Hand Button
		
	}
	public void addHandsToInterface(Player player, Player dealer) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void addHandsToInterface
		//
		// Method parameters	:	Player The player
		//							Player The dealer's hand
		//
		// Method return		:	void
		//
		// Synopsis				:   This method adds the player's and dealer's hands to the interface. It also refreshes the
		//							money and hand count.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.pane.add(player.getHand().getHandDisplay(), JLayeredPane.DEFAULT_LAYER);	// Add the player's hand to the interface
		
		this.pane.add(dealer.getHand().getHandDisplay(), JLayeredPane.DEFAULT_LAYER);	// Add the dealer's hand to the interface
		
		this.refreshMoney(player, dealer);												// Refresh the money values in the interface
		
		this.refreshHandCount(player, dealer);											// Refresh the hand count values in the interface
	}
	public void newHandClicked () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void newHandClicked
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Handle the event when a new hand is clicked. 
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-16		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.newHandButton.setVisible(false);			// Hide the New Hand Button
		
		this.betField.setVisible(false);				// Hide the bet Text Field
		
		this.betTextMessage.setVisible(false);			// Hide the bet Text Message
	}
	public void resetHand () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void restHand
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Resets the interface for a new Hand.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.showLabels();											// Show the information labels
						
		this.refreshHandCount(BlackJack.player, BlackJack.dealer);	// Refresh the hand count information

		this.refreshMoney(BlackJack.player, BlackJack.dealer);		// Refresh the money balance information
		
		this.betField.setText("");									// Show the bet text field
		
		this.betField.setVisible(true);								// Show the bet text field
		
		this.betTextMessage.setVisible(true);						// Show the bet text message
	}
	public void showLabels () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showLabels
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the information labels on the interface and the bet button. Hide the other buttons.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.newHandButton.setVisible(false);		// Hide the New Hand Button
		
		this.hitButton.setVisible(false);			// Hide the Hit Button
		
		this.standButton.setVisible(false);			// Hide the Stand Button
		
		this.pot.setVisible(false);					// Hide the Pot
	}
	public void showNewHandButton () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showNewHandButton
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the New Hand Button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.newHandButton.setVisible(true);		// Show the New Hand Button
	}
	public void showHandWonMessage () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showHandWonMessage
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the message to the user when a hand has been won in modal layer.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.showModal(1, 1);						// Show the message that the player won the hand
	}
	
	public void showBustedMessage () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showBustedMessage
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the message to the user when a hand is busted in modal layer.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.showModal(2, 1);							// Show the message that the player busted
	}
	
	public void showHandLostMessage () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showHandLostMessage
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the message to the user when a hand has been lost in modal layer.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.showModal(3, 1);							// Show the message that the player lost the hand
	}
	public void showGameOverMessage (boolean playerWins) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showGameOverMessage
		//
		// Method parameters	:	boolean True if the player won the game
		//
		// Method return		:	void
		//
		// Synopsis				:   Shows the message when the game is over in modal layer.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.hideActionButtons();						// Hide the action buttons
		
		if(playerWins) {								// Check is the player won the game		
			
			this.showModal(4, -1);						// Show the message that the player won the game
		}else {
			this.showModal(5, -1);						// Show the message that the player lost the game
		}
	}
	public void hideActionButtons () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hideActionButtons
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Hides all the action buttons to avoid interaction fromt he user.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.hitButton.setVisible(false);			// Hide the Hit Button
		
		this.standButton.setVisible(false);			// Hide the Stand Button
	}
	public void hideContinueMessage () {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hideContinueMessage
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   Hides all the messages when a hand is over and the continue button.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.hideModal();			// Hide the modal
	}
	public void refreshHandCount (Player player, Player dealer) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void refreshHandCount
		//
		// Method parameters	:	Player The player
		//							Player The dealer's hand
		//
		// Method return		:	void
		//
		// Synopsis				:   This method updates the information in the player's and dealer's hand count.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
														// Update the player's hand count
		((JLabel)this.playerHandCount.getComponent(0)).setText("Player hand count: " + player.getHand().countHand());
		
														// Update the dealer's hand count
		((JLabel)this.dealerHandCount.getComponent(0)).setText("Dealer hand count: " + dealer.getHand().countHand());
	}
	public void refreshMoney (Player player, Player dealer) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void refreshMoney
		//
		// Method parameters	:	Player The player
		//							Player The dealer's hand
		//
		// Method return		:	void
		//
		// Synopsis				:   This method updates the information in the player's and dealer's hand count.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
														// Update the player's money
		((JLabel)this.playersMoney.getComponent(0)).setText("Player balance: $" + player.getMoney());
		
														// Update the dealer's money
		((JLabel)this.dealersMoney.getComponent(0)).setText("Player balance: $" + dealer.getMoney());
	}
	public void setBet (int potAmount) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setBet
		//
		// Method parameters	:	int The pot amount
		//
		// Method return		:	void
		//
		// Synopsis				:   This method updates the pot information and the interface elements accordingly.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		((JLabel)pot.getComponent(0)).setText("Pot: $ " + potAmount);	// Update the pot amount
		
		this.pot.setVisible(true);										// Show the post label
		
		this.hitButton.setVisible(true);								// Show the Hit Button
		
		this.standButton.setVisible(true);								// Show the Hand Button
	}
	public JFrame getFrame() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	JFrame getFrame
		//
		// Method parameters	:	void
		//
		// Method return		:	JFrame The interface's frame
		//
		// Synopsis				:   This method Returns the interface's frame
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.frame;									// Return this object's frame
	}
	public JTextField getBetField() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	JTextField getBetField
		//
		// Method parameters	:	void
		//
		// Method return		:	JTextField The interface's text field for the bet
		//
		// Synopsis				:   This method Returns the interface's bet text field.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		return this.betField;								// Return this object's text field
	}
	public void setBetField(String message) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void setBetField
		//
		// Method parameters	:	String the 
		//
		// Method return		:	void
		//
		// Synopsis				:   This method Returns the interface's bet text field.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		((JLabel)this.betTextMessage.getComponent(0)).setText(message);		// Set the bet text message
	}
	
	public void showModal(int message, int action) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showModal
		//
		// Method parameters	:	int The modal's Message position in the list.
		//							int The modal's button position in the list.
		//
		// Method return		:	void
		//
		// Synopsis				:   This method Shows a modal given a message and action button position.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		switch(message) {								// Switch over the message
		case 0:
		case 1:
		case 2:
		case 3:											// Set the bounds for the small messages
			this.modal.setBounds((900-BlackJackInterface.titleSize.width-10)/2, 140, BlackJackInterface.titleSize.width + 20, BlackJackInterface.titleSize.height + 100);
			break;
		case 4:
		case 5:											// Set the bounds for the big messages
			this.modal.setBounds(0, 200, 900, BlackJackInterface.bigTitleSize.height);
			break;
		}
		this.modal.removeAll();							// Remove the modal components
		
		this.modal.add(this.messageList[message]);		// Add the message to the modal
		
		if(action != -1) {								// Check if the modal must have a button
			
			this.modal.add(this.buttonList[action]);	// Add the button to the modal
		}
		
		this.modal.setVisible(true);					// Show the modal
		
		this.frame.pack();								// Pack the frame
		
		this.frame.repaint();							// Refresh the frame
	}
	
	public void hideModal() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hideModal
		//
		// Method parameters	:	void
		//
		// Method return		:	void
		//
		// Synopsis				:   This method hides the modal.
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-03-18		D. Urdapilleta			Initial setup
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		this.modal.setVisible(false);					// Hide the modal
	}
}