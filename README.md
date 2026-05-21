[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/7tNcVdHc)
# APCS2 Final Project
## Group Info
**The Processing Capitalists**
Aidan Zeleniy and Ibrahim Attia

## Project Description
We created a game in Processing similar to Monopoly, which features a full 40-tile board, a multiplayer feature on the same device, limited player customization, renditions of existing rules, and unique rules to the game itself. This includes a rent multiplier based on the number of properties in a set. This also includes a unique instant-bankrupt rule for any player who falls below $0, pushing players away from unnecessarily risky plays.

To play, select the number of players you would like to play with, ranging from 2 to 4 players. From there, you can select custom colors for each player. Once you start, players will roll their dice and try to balance their game in properties and balance. Once a player goes below $0, they instantly lose and are out of the game. The last player remaining wins.

## Video Presentation
[Link to Video Presentation](ADD_WHEN_DONE)

## Compiling and Running
1. Download and install Processing.
2. Clone this project repository.
3. Open the `Game.pde` file located in the `Game` folder using Processing.
4. Press the Run button to start the application.

## Usage and Controls
The game utilizes both mouse and keyboard inputs to navigate the interface and play the game.

**Menus and Interactivity:**
* **Mouse Click:** Use the mouse to select the number of players and choose player token colors.
* **Popups:** When landing on an unowned property, click "BUY" to purchase it or "PASS" to decline. Click "OK" to dismiss informational popups like Chance or Community Chest cards.

**Game Controls:**
* **Spacebar:** Roll the dice for the current active player.
* **E:** End the current player's turn and pass to the next player.
* **R:** Return to the Start Menu from the Game Over screen.

## Major Bugs and Known Issues
* **Text Readability:** The board text for certain properties are a bit small and could be difficult to read.
* **Popups Overlapping:** Having many interactions in a single turn (such as resolving a chance card that moves you to an unowned property) can cause multiple popup screens to overlap visually.