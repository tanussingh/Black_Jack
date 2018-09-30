- IDE Used to build the project:- IntelliJ IDEA CE, language - java
- Directions to Run:- Quickest methodology is to compile all the codes in any linux interface by running javac *.java then running the Main class. 

- Examples of Running output are attached to the project.

- Algorithm's used to build the Black Jack Game:- 
	. Due to the lack of time, the game is designed in a simple manner. 
	. There is a class of card that has the following attributes - cardType, cardValue, cardUse, and cardPoint
	. An array called deck of type card is used to hold all the cards.
	. This deck is originally filled with values to initialize all characteristics of a deck - 52 cards -> 13 of each Heart, Club, Diamond and Spade
	. Now the official Gameboard is initiated and the game begins between one single player and the virtual dealer. 
		. The user first gets their chance on the game
		. once user finishes their turn, dealer gets a chance
		. score is displayed after each individual round

	- Different Cases that were considered while designing the game
		. What if either user plays a perfect 21 in the first 2 cards or subsequent cards
		. what if either player exceeds 21 at any point in the game
		. what if either player quits
		. Most edge cases were taken into account
		
- Additional Features that I would have loved to implement:-
	. It would have been nice to have a stack for the cards so they can be placed in a true random order without needing to generate a new card every time.
	. It would have been nice to have multiple players being able to play at once
	. Another improvement would be to build a GUI interface for the game to run in. 