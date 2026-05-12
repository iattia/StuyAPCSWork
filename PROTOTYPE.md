# Final Project Prototype

## Group Members:

Aidan Zeleniy and Ibrahim Attia

## Group Name:

**The Processing Capitalists**

## Brief Project Description:

We are creating a fully playable version of the board game Monopoly using Java and Processing. This project will allow two to four friends to play the game together on the same computer. We are building the entire game board from scratch and making sure all the classic rules work exactly as they do in real life. Players will take turns rolling dice, moving their tokens around the board, buying properties, and trying to bankrupt their opponents.

## Expanded Description:

**Critical features (MVP):**
* First, we will build the 40 spaces that make up the classic Monopoly board. We will arrange these spaces in a square around the edge of the game window so it looks just like the physical board. 
* We will create a menu system where players can choose how many people are playing before the game starts. 
* Once the game begins, we will have a working turn system. This means the game will know whose turn it is and will wait for that player to click a button to roll the dice. 
* When a player rolls the dice, their token will move forward the correct number of spaces. If they pass the Go space, they will collect their starting bonus.
* We will include a way for players to buy unowned properties they land on. The game will show them the price and ask if they want to make the purchase.
* If another player lands on a property that is already owned, the game will automatically subtract the rent from their money and give it to the owner. 
* We will have a section in the middle of the screen that always shows everyone's current money and whose turn it is. 
* Finally, if a player runs out of money, they will be eliminated from the game entirely. <br> <br>

**Nice to have features:**
* If we have extra time, we want to show the player tokens actually moving space by space along the board instead of just appearing at their new location. 
* We will include option for one player game where the user plays against a bot making random moves.
* We want to add a fun visual effect for rolling the dice, making the numbers scramble on the screen before stopping. 
* For the game rules, we want to add the ability to collect a full set of colors and build houses and hotels. This will make the game much more competitive because the rent will go up a lot. 
* We also want to include all the rules for going to jail. This includes getting sent to jail, waiting three turns, and trying to roll doubles to get out early. 
* Lastly, we want to make sure that when a player goes bankrupt, all their properties go back to being unowned so other people can buy them again. <br> <br>

# Project Screen Images



# Project Design and UML:

![UML Diagram](assets/UML.png)

The Game class acts as the central part of the game mechanics as it holds references to the Board, both Players and the Dice. Each turn, Game calls roll() on the Dice and then calls move() on the current Player with the result. Once the Player's position updates, Game calls getTile() on the Board to find out which Tile they landed on, then calls landOn() passing the Player in. 

From there, the specific Tile subclass handles the logic. For example, if it's a Property, it checks if there's an owner and either prompts a purchase or calls pay() on the Player to transfer rent. After every transaction, checkBankrupt() is called on the Player to see if they've gone below $0, and if so Game eliminates them. 

Board is purely responsible for storing the 40 Tile objects in order and rendering them visually, it holds no game logic itself.


# Development Stages / Pacing:



etc..
