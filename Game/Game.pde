int START_MENU = 0;
int CUSTOMIZATION = 1;
int PLAYING = 2;
int GAME_OVER = 3;
int state = START_MENU;
Board board;
ArrayList<Player> players;
Dice dice;
int currentTurn = 0;
boolean hasRolled = false;
boolean canRollAgain = false;
color[] selectedColors = { color(255, 0, 0), color(0, 180, 0), color(0, 0, 255), color(200, 0, 200) };
int selectedPlayerCount = 2;
String popupTitle = "";
String popupMessage = "";
boolean showPopup = false;
Property activePropertyPrompt = null;
ChanceTile activeChanceTilePrompt = null;
boolean wasMovedByCard = false;
void setup() {
    size(1000, 1000);
    board = new Board();
    dice = new Dice();
    players = new ArrayList<Player>();
}
void draw() {
    background(255);
    if (state == START_MENU) {
        drawStartMenu();
    } else if (state == CUSTOMIZATION) {
        drawCustomizationScreen();
    } else if (state == PLAYING) {
        runGameplayLoop();
    } else if (state == GAME_OVER) {
        drawGameOverScreen();
    }
}
void drawStartMenu() {
    fill(0);
    textSize(64);
    textAlign(CENTER, CENTER);
    text("MONOPOLY", width / 2, height / 3);
    textSize(24);
    text("Select Number of Players:", width / 2, height / 2 - 40);
    for (int i = 2; i <= 4; i++) {
        if (selectedPlayerCount == i) fill(180);
        else fill(230);
        stroke(0);
        rect(width / 2 - 150 + (i - 2) * 110, height / 2, 90, 50);
        fill(0);
        text(i + " P", width / 2 - 105 + (i - 2) * 110, height / 2 + 25);
    }
    fill(200);
    rect(width / 2 - 100, height / 2 + 100, 200, 50);
    fill(0);
    text("CONTINUE", width / 2, height / 2 + 125);
}
void drawCustomizationScreen() {
    fill(0);
    textSize(48);
    textAlign(CENTER, CENTER);
    text("PLAYER SETUP", width / 2, height / 6);

    textSize(20);
    text("Click a circle to customize player token colors:", width / 2, height / 4);

    color[] colorChoices = { color(255, 0, 0), color(0, 180, 0), color(0, 0, 255), color(200, 0, 200), color(255, 215, 0), color(0, 200, 200) };

    for (int i = 0; i < selectedPlayerCount; i++) {
        float rowY = height / 3 + (i * 80);

        // Label
        fill(0);
        textSize(22);
        textAlign(LEFT, CENTER);
        text("Player " + (i + 1) + ":", width / 4, rowY);

        // Color circles
        for (int c = 0; c < 6; c++) {
            float cx = width / 2 - 50 + (c * 40);

            // Highlight if this is the selected color
            if (selectedColors[i] == colorChoices[c]) {
                stroke(0);
                strokeWeight(4);
            } else {
                stroke(150);
                strokeWeight(1);
            }

            fill(colorChoices[c]);
            ellipse(cx, rowY, 24, 24);
        }
    }

    // Reset stroke settings
    stroke(0);
    strokeWeight(2);

    // START GAME button
    fill(200);
    rect(width / 2 - 100, height * 3 / 4, 200, 50);
    fill(0);
    textSize(24);
    textAlign(CENTER, CENTER);
    text("START GAME", width / 2, height * 3 / 4 + 25);
}
void runGameplayLoop() {
    for (int i = players.size() - 1; i >= 0; i--) {
        if (players.get(i).getBankrupt()) {
            boolean wasCurrentTurn = (currentTurn == i);
            for (Property prop : players.get(i).ownedProperties) {
                prop.owner = null;
            }
            players.remove(i);
            if (wasCurrentTurn) {
                hasRolled = false;
                canRollAgain = false;
                if (currentTurn >= players.size()) {
                    currentTurn = 0;
                }
            } else if (currentTurn > i) {
                currentTurn--;
            }
        }
    }
    if (players.size() <= 1) {
        state = GAME_OVER;
        return;
    }
    board.draw(players, currentTurn);
    board.drawPlayers(players);
    drawActionPanel();

    // Draw current roll in the center of the board
    if (hasRolled) {
        float boardSize = min(width, height) * 0.95;
        float startX = (width - boardSize) / 2;
        float startY = (height - boardSize) / 2 - 175;
        fill(0);
        textSize(18);
        textAlign(CENTER, CENTER);
        text("Rolled: " + dice.die1 + " & " + dice.die2 + " (Total: " + (dice.die1 + dice.die2) + ")", startX + boardSize / 2, startY + boardSize * 0.52);
        if (dice.die1 == dice.die2 && canRollAgain) {
            fill(180, 0, 0);
            text("DOUBLES! Press [E] to start your extra turn!", startX + boardSize / 2, startY + boardSize * 0.55);
        }
    }
    
    if (showPopup) {
        drawPopupOverlay();
    }
}
void drawActionPanel() {
    float boardSize = min(width, height) * 0.95;
    float cornerSize = boardSize * 0.13;
    float startX = (width - boardSize) / 2;
    float startY = (height - boardSize) / 2 + 110;
    fill(245);
    stroke(0);
    rect(startX + cornerSize + 30, startY + cornerSize + 430, boardSize - 2 * cornerSize - 60, 120);
    fill(0);
    textSize(16);
    textAlign(LEFT, TOP);
    text("CONTROLS:", startX + cornerSize + 50, startY + cornerSize + 445);
    text("[SPACEBAR] - Roll Dice", startX + cornerSize + 50, startY + cornerSize + 470);
    text("[E] - End Active Player Turn", startX + cornerSize + 50, startY + cornerSize + 495);
}
void drawPopupOverlay() {
    fill(255);
    stroke(0);
    strokeWeight(3);
    rect(width / 2 - 225, height / 2 - 125, 450, 250);
    strokeWeight(2);
    fill(0);
    textSize(24);
    textAlign(CENTER, CENTER);
    text(popupTitle, width / 2, height / 2 - 80);
    textSize(16);
    text(popupMessage, width / 2 - 190, height / 2 - 40, 380, 100);
    if (activePropertyPrompt != null) {
        fill(200);
        rect(width / 2 - 140, height / 2 + 50, 100, 40);
        rect(width / 2 + 40, height / 2 + 50, 100, 40);
        fill(0);
        textSize(16);
        text("BUY", width / 2 - 90, height / 2 + 70);
        text("PASS", width / 2 + 90, height / 2 + 70);
    } else {
        fill(200);
        rect(width / 2 - 60, height / 2 + 50, 120, 40);
        fill(0);
        textSize(16);
        text("OK", width / 2, height / 2 + 70);
    }
}
void drawGameOverScreen() {
    fill(0);
    textSize(64);
    textAlign(CENTER, CENTER);
    text("GAME OVER", width / 2, height / 3);
    textSize(32);
    if (players.size() == 1) {
        text(players.get(0).name + " IS VICTORIOUS!", width / 2, height / 2);
    } else {
        text("NO SURVIVING CAPITALISTS", width / 2, height / 2);
    }
    textSize(20);
    fill(100);
    text("Press [R] to return to Start Menu", width / 2, height * 2 / 3);
}
void triggerPopup(String title, String msg) {
    popupTitle = title;
    popupMessage = msg;
    showPopup = true;
    activePropertyPrompt = null;
}
void triggerPropertyPurchase(Property prop) {
    popupTitle = "Purchase Property?";
    popupMessage = prop.name + " [" + prop.colorGroup + "] is available for $" + prop.price + ".\nRent starts at $" + prop.rent + ".";
    showPopup = true;
    activePropertyPrompt = prop;
}
void mousePressed() {
    if (state == START_MENU) {
        for (int i = 2; i <= 4; i++) {
            if (mouseX >= width / 2 - 150 + (i - 2) * 110 && mouseX <= width / 2 - 60 + (i - 2) * 110 &&
                mouseY >= height / 2 && mouseY <= height / 2 + 50) {
                selectedPlayerCount = i;
            }
        }
        if (mouseX >= width / 2 - 100 && mouseX <= width / 2 + 100 &&
            mouseY >= height / 2 + 100 && mouseY <= height / 2 + 100 + 50) {
            state = CUSTOMIZATION;
        }
    } else if (state == CUSTOMIZATION) {
        color[] colorChoices = { color(255, 0, 0), color(0, 180, 0), color(0, 0, 255), color(200, 0, 200), color(255, 215, 0), color(0, 200, 200) };
        for (int i = 0; i < selectedPlayerCount; i++) {
            float rowY = height / 3 + (i * 80);
            for (int c = 0; c < 6; c++) {
                float cx = width / 2 - 50 + (c * 40);
                if (dist(mouseX, mouseY, cx, rowY) < 15) {
                    selectedColors[i] = colorChoices[c];
                }
            }
        }
        if (mouseX >= width / 2 - 100 && mouseX <= width / 2 + 100 &&
            mouseY >= height * 3 / 4 && mouseY <= height * 3 / 4 + 50) {
            for (int i = 0; i < selectedPlayerCount; i++) {
                players.add(new Player("Player " + (i + 1), selectedColors[i]));
            }
            state = PLAYING;
        }
    } else if (state == PLAYING && showPopup) {
        if (activePropertyPrompt != null) {
            if (mouseX >= width / 2 - 140 && mouseX <= width / 2 - 40 &&
                mouseY >= height / 2 + 50 && mouseY <= height / 2 + 90) {
                Player p = players.get(currentTurn);
                if (p.money >= activePropertyPrompt.price) {
                    p.buyProperty(activePropertyPrompt);
                    showPopup = false;
                    activePropertyPrompt = null;
                }
            } else if (mouseX >= width / 2 + 40 && mouseX <= width / 2 + 140 &&
                     mouseY >= height / 2 + 50 && mouseY <= height / 2 + 90) {
                showPopup = false;
                activePropertyPrompt = null;
            }
        } else {
            if (mouseX >= width / 2 - 60 && mouseX <= width / 2 + 60 &&
                mouseY >= height / 2 + 50 && mouseY <= height / 2 + 90) {
                showPopup = false;
                if (wasMovedByCard) {
                    wasMovedByCard = false;
                    Player p = players.get(currentTurn);
                    Tile t = board.tiles[p.position];
                    if (t instanceof Property && ((Property) t).owner == null) {
                        triggerPropertyPurchase((Property) t);
                    } else {
                        t.landOn(p);
                    }
                }
                if (activeChanceTilePrompt != null) {
                    activeChanceTilePrompt = null;
                }
            }
        }
    }
}
void keyPressed() {
    if (state == GAME_OVER) {
        if (key == 'r' || key == 'R') {
            resetGame();
        }
        return;
    }
    if (state != PLAYING || showPopup) return;
    Player p = players.get(currentTurn);
    if (key == ' ' && !hasRolled) {
        int roll = dice.roll();
        boolean isDoubleRolled = (dice.die1 == dice.die2);
        hasRolled = true;
        if (p.inJail) {
            p.jailTurnsTracked++;
            canRollAgain = false;
            if (isDoubleRolled) {
                p.inJail = false;
                p.consecutiveDoubles = 0;
                triggerPopup("Escape!", p.name + " rolled doubles (" + dice.die1 + "s) to break out of Jail and rolled " + roll + "!");
                p.move(roll);
                wasMovedByCard = true;
                return;
            } else if (p.jailTurnsTracked >= 3) {
                p.pay(50);
                p.inJail = false;
                triggerPopup("Jail Fine Paid", p.name + " did not roll doubles on turn 3 in Jail. Paid $50 fine, escaped, and rolled " + roll + "!");
                p.move(roll);
                wasMovedByCard = true;
                return;
            } else {
                triggerPopup("Still in Jail", p.name + " rolled " + dice.die1 + " and " + dice.die2 + ".\nNo doubles. Still in jail!");
                return;
            }
        }
        if (isDoubleRolled) {
            p.consecutiveDoubles++;
            if (p.consecutiveDoubles == 3) {
                p.position = 10;
                p.inJail = true;
                p.jailTurnsTracked = 0;
                p.consecutiveDoubles = 0;
                triggerPopup("Go to Jail", p.name + " rolled doubles 3 times in a row! Sent directly to Jail.");
                canRollAgain = false;
                return;
            }
            p.move(roll);
            if (p.position == 30) {
                p.position = 10;
                p.inJail = true;
                p.jailTurnsTracked = 0;
                p.consecutiveDoubles = 0;
                triggerPopup("Go to Jail", p.name + " landed on Go to Jail! Sent directly to Jail.");
                canRollAgain = false;
                return;
            }
            Tile t = board.tiles[p.position];
            if (t instanceof Property && ((Property) t).owner == null) {
                triggerPropertyPurchase((Property) t);
            } else {
                t.landOn(p);
            }
            canRollAgain = true;
        } else {
            p.consecutiveDoubles = 0;
            p.move(roll);
            if (p.position == 30) {
                p.position = 10;
                p.inJail = true;
                p.jailTurnsTracked = 0;
                triggerPopup("Go to Jail", p.name + " landed on Go to Jail! Sent directly to Jail.");
                canRollAgain = false;
                return;
            }
            Tile t = board.tiles[p.position];
            if (t instanceof Property && ((Property) t).owner == null) {
                triggerPropertyPurchase((Property) t);
            } else {
                t.landOn(p);
            }
            canRollAgain = false;
        }
    }
    if (key == 'e' || key == 'E') {
        if (hasRolled) {
            if (p.inJail) {
                canRollAgain = false;
            }
            if (canRollAgain) {
                hasRolled = false;
                canRollAgain = false;
            } else {
                if (!p.inJail) p.consecutiveDoubles = 0;
                currentTurn = (currentTurn + 1) % players.size();
                hasRolled = false;
                canRollAgain = false;
            }
        }
    }
}
void resetGame() {
    players.clear();
    currentTurn = 0;
    hasRolled = false;
    canRollAgain = false;
    selectedColors[0] = color(255, 0, 0);
    selectedColors[1] = color(0, 180, 0);
    selectedColors[2] = color(0, 0, 255);
    selectedColors[3] = color(200, 0, 200);
    selectedPlayerCount = 2;
    showPopup = false;
    wasMovedByCard = false;
    activePropertyPrompt = null;
    activeChanceTilePrompt = null;
    for (Tile t : board.tiles) {
        if (t instanceof Property) {
            ((Property) t).owner = null;
        }
    }
    state = START_MENU;
}
