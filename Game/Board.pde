public class Board {
    public Tile[] tiles;

    public Board() {
        tiles = new Tile[40];
        tiles[0] = new GoTile("Go", 0);
        tiles[1] = new Property("Scheme", 1, 60, 2, "Brown");
        tiles[2] = new Tile("Community Chest", 2) { public void landOn(Player p) {} };
        tiles[3] = new Property("Dr. Racket", 3, 60, 4, "Brown");
        tiles[4] = new Tile("Income Tax", 4) {
          public void landOn(Player p) {
            p.money -= 200;
            System.out.println(p.name + " paid $200 Income Tax.");
          }
        };
        tiles[5] = new Property("Server 1", 5, 200, 25, "Server") {
          public int calculateRent() {
            int serversOwned = 0;
            for (Property prop : owner.ownedProperties) {
              if (prop.colorGroup.equals("Server")) {
                serversOwned++;
              }
            }
            return (int) (25 * Math.pow(2, serversOwned - 1));
          }
        };
        tiles[6] = new Property("HTML World", 6, 100, 6, "Light Blue");
        tiles[7] = new Tile("Chance", 7) { public void landOn(Player p) {} };
        tiles[8] = new Property("CSS Court", 8, 100, 6, "Light Blue");
        tiles[9] = new Property("Python Place", 9, 120, 8, "Light Blue");
        tiles[10] = new JailTile("Just Visiting / In Jail", 10);
        tiles[11] = new Property("Int International", 11, 140, 10, "Pink");
        tiles[12] = new Tile("Stack Overflow", 12) { public void landOn(Player p) {} };
        tiles[13] = new Property("Double Downtown", 13, 140, 10, "Pink");
        tiles[14] = new Property("Boolean Boulevard", 14, 160, 12, "Pink");
        tiles[15] = new Property("Server 2", 5, 200, 25, "Server") {
          public int calculateRent() {
            int serversOwned = 0;
            for (Property prop : owner.ownedProperties) {
              if (prop.colorGroup.equals("Server")) {
                serversOwned++;
              }
            }
            return (int) (25 * Math.pow(2, serversOwned - 1));
          }
        };
        tiles[16] = new Property("Array Avenue", 16, 180, 14, "Orange");
        tiles[17] = new Tile("Community Chest", 17) { public void landOn(Player p) {} };
        tiles[18] = new Property("ArrayList Avenue", 18, 180, 14, "Orange");
        tiles[19] = new Property("LinkedList Living", 19, 200, 16, "Orange");
        tiles[20] = new FreeParkingTile("Free Parking", 20);
        tiles[21] = new Property("HashMap Highway", 21, 220, 18, "Red");
        tiles[22] = new Tile("Chance", 22) { public void landOn(Player p) {} };
        tiles[23] = new Property("HashSet Haven", 23, 220, 18, "Red");
        tiles[24] = new Property("TreeMap Terrace", 24, 240, 20, "Red");
        tiles[25] = new Property("Server 3", 5, 200, 25, "Server") {
          public int calculateRent() {
            int serversOwned = 0;
            for (Property prop : owner.ownedProperties) {
              if (prop.colorGroup.equals("Server")) {
                serversOwned++;
              }
            }
            return (int) (25 * Math.pow(2, serversOwned - 1));
          }
        };
        tiles[26] = new Property("Bubble Sort Boulevard", 26, 260, 22, "Yellow");
        tiles[27] = new Property("Selection Sort Street", 27, 260, 22, "Yellow");
        tiles[28] = new Tile("GitHub Repo", 28) { public void landOn(Player p) {} };
        tiles[29] = new Property("Insertion Sort International", 29, 280, 24, "Yellow");
        tiles[30] = new Tile("Go To Jail", 30) { public void landOn(Player p) {} };
        tiles[31] = new Property("Quick Sort Quizzes", 31, 300, 26, "Green");
        tiles[32] = new Property("Merge Sort Motel", 32, 300, 26, "Green");
        tiles[33] = new Tile("Community Chest", 33) { public void landOn(Player p) {} };
        tiles[34] = new Property("Heap Sort Haven", 34, 320, 28, "Green");
        tiles[35] = new Property("Server 4", 5, 200, 25, "Server") {
          public int calculateRent() {
            int serversOwned = 0;
            for (Property prop : owner.ownedProperties) {
              if (prop.colorGroup.equals("Server")) {
                serversOwned++;
              }
            }
            return (int) (25 * Math.pow(2, serversOwned - 1));
          }
        };
        tiles[36] = new Tile("Chance", 36) { public void landOn(Player p) {} };
        tiles[37] = new Property("Breadth First Search Boulevard", 37, 350, 35, "Dark Blue");
        tiles[38] = new Tile("Luxury Tax", 38) {
          public void landOn(Player p) {
            p.money -= 100;
            System.out.println(p.name + " paid $100 Luxury Tax.");
          }
        };
        tiles[39] = new Property("Depth First Search Disaster", 39, 400, 50, "Dark Blue");
    }

    public float[] getTilePosition(int index) {
        float boardSize = min(width, height) * 0.95;
        float cornerSize = boardSize * 0.13;
        float tileSize = (boardSize - 2 * cornerSize) / 9.0;
        float startX = (width - boardSize) / 2;
        float startY = (height - boardSize) / 2;
        float x = 0, y = 0, w = 0, h = 0;

        if (index == 0) {
            x = startX + boardSize - cornerSize; y = startY + boardSize - cornerSize;
            w = cornerSize; h = cornerSize;
        } else if (index < 10) {
            x = startX + boardSize - cornerSize - (index * tileSize); y = startY + boardSize - cornerSize;
            w = tileSize; h = cornerSize;
        } else if (index == 10) {
            x = startX; y = startY + boardSize - cornerSize;
            w = cornerSize; h = cornerSize;
        } else if (index < 20) {
            x = startX; y = startY + boardSize - cornerSize - ((index - 10) * tileSize);
            w = cornerSize; h = tileSize;
        } else if (index == 20) {
            x = startX; y = startY;
            w = cornerSize; h = cornerSize;
        } else if (index < 30) {
            x = startX + cornerSize + ((index - 20) * tileSize) - tileSize; y = startY;
            w = tileSize; h = cornerSize;
        } else if (index == 30) {
            x = startX + boardSize - cornerSize; y = startY;
            w = cornerSize; h = cornerSize;
        } else {
            x = startX + boardSize - cornerSize; y = startY + cornerSize + ((index - 30) * tileSize) - tileSize;
            w = cornerSize; h = tileSize;
        }

        return new float[]{x, y, w, h};
    }

    public void draw(ArrayList<players>, int currentTurn) {
        float boardSize = min(width, height) * 0.95;
        float cornerSize = boardSize * 0.13;
        float startX = (width - boardSize) / 2;
        float startY = (height - boardSize) / 2;
        fill(255);
        rect(startX + cornerSize, startY + cornerSize, boardSize - 2 * cornerSize, boardSize - 2 * cornerSize);
        fill(0);
        textSize(64);
        textAlign(CENTER, CENTER);
        text("MONOPOLY", startX + (boardSize / 2), startY + (boardSize / 2));
        textAlign(LEFT, TOP);
        textSize(24);
        textAlign(LEFT, TOP);
        textSize(24);
        for (int i = 0; i < players.size(); i++) {
         fill(players.get(i).playerColor);
         text(players.get(i).name + ": $" + players.get(i).money, startX + cornerSize + 40, startY + cornerSize + 20 + (i * 35));
         if (i == currentTurn) {
           fill(players.get(i).playerColor);
           ellipse(startX + cornerSize + 25, startY + cornerSize + 32 + (i * 35), 12, 12);
          }
        }
        fill(0);
        textSize(28);
        text("Current Turn: " + players[currentTurn].name, startX + cornerSize + 40, startY + cornerSize + 180);
        for (int i = 0; i < 40; i++) {
            float[] t = getTilePosition(i);
            float x = t[0];
            float y = t[1];
            float w = t[2];
            float h = t[3];
            stroke(0);
            strokeWeight(2);
            fill(235);
            rect(x, y, w, h);
            float textX = x + 2;
            float textY = y + 2;
            float textW = w - 4;
            float textH = h - 4;
            if (tiles[i] instanceof Property) {
                Property p = (Property) tiles[i];
                fill(getColor(p.colorGroup));
                float bandRatio = 0.22;
                if (i > 0 && i < 10) {
                    rect(x, y, w, h * bandRatio);
                    textY += h * bandRatio;
                    textH -= h * bandRatio;
                } else if (i > 10 && i < 20) {
                    rect(x + w - (w * bandRatio), y, w * bandRatio, h);
                    textW -= w * bandRatio;
                } else if (i > 20 && i < 30) {
                    rect(x, y + h - (h * bandRatio), w, h * bandRatio);
                    textH -= h * bandRatio;
                } else if (i > 30 && i < 40) {
                    rect(x, y, w * bandRatio, h);
                    textX += w * bandRatio;
                    textW -= w * bandRatio;
                }
            }
            fill(0);
            textSize(10);
            textAlign(CENTER, CENTER);
            text(tiles[i].name, textX, textY, textW, textH);
        }
    }

    public void drawPlayers(ArrayList<Player> players) {
        int[][] offsets = {{-8, -8}, {8, -8}, {-8, 8}, {8, 8}};
        for (int i = 0; i < players.length; i++) {
            float[] t = getTilePosition(players[i].position);
            float cx = t[0] + t[2] / 2 + offsets[i][0];
            float cy = t[1] + t[3] / 2 + offsets[i][1];
            fill(players[i].playerColor);
            noStroke();
            ellipse(cx, cy, 16, 16);
        }
    }
    public int getColor(String group) {
        if (group.equals("Brown")) return color(139, 69, 19);
        if (group.equals("Light Blue")) return color(173, 216, 230);
        if (group.equals("Pink")) return color(255, 0, 255);
        if (group.equals("Orange")) return color(255, 165, 0);
        if (group.equals("Red")) return color(255, 0, 0);
        if (group.equals("Yellow")) return color(255, 255, 0);
        if (group.equals("Green")) return color(34, 139, 34);
        if (group.equals("Dark Blue")) return color(30, 144, 255);
        return color(255);
    }
    public Tile getTile(int pos) {
        return tiles[pos % 40];
    }
}
