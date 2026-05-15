public class Board {
    public Tile[] tiles;

    public Board() {
        tiles = new Tile[40];

        tiles[0] = new GoTile("Go", 0);

        tiles[1] = new Property("Scheme", 1, 60, 2, "Brown");
        tiles[2] = new Tile("Community Chest", 2) { public void landOn(Player p) {} };
        tiles[3] = new Property("Dr. Racket", 3, 60, 4, "Brown");
        tiles[4] = new Tile("Income Tax", 4) { public void landOn(Player p) {} };
        tiles[5] = new Tile("Server 1", 5) { public void landOn(Player p) {} };
        tiles[6] = new Property("HTML World", 6, 100, 6, "Light Blue");
        tiles[7] = new Tile("Chance", 7) { public void landOn(Player p) {} };
        tiles[8] = new Property("CSS Court", 8, 100, 6, "Light Blue");
        tiles[9] = new Property("Python Place", 9, 120, 8, "Light Blue");

        tiles[10] = new JailTile("Just Visiting / In Jail", 10);
        tiles[11] = new Property("Int International", 11, 140, 10, "Pink");
        tiles[12] = new Tile("Stack Overflow", 12) { public void landOn(Player p) {} };
        tiles[13] = new Property("String Street", 13, 140, 10, "Pink");
        tiles[14] = new Property("Boolean Boulevard", 14, 160, 12, "Pink");
        tiles[15] = new Tile("Server 2", 15) { public void landOn(Player p) {} };
        tiles[16] = new Property("Array Avenue", 16, 180, 14, "Orange");
        tiles[17] = new Tile("Community Chest", 17) { public void landOn(Player p) {} };
        tiles[18] = new Property("ArrayList Avenue", 18, 180, 14, "Orange");
        tiles[19] = new Property("LinkedList Living", 19, 200, 16, "Orange");

        tiles[20] = new FreeParkingTile("Free Parking", 20);
        tiles[21] = new Property("HashMap Highway", 21, 220, 18, "Red");
        tiles[22] = new Tile("Chance", 22) { public void landOn(Player p) {} };
        tiles[23] = new Property("HashSet Haven", 23, 220, 18, "Red");
        tiles[24] = new Property("TreeMap Terrace", 24, 240, 20, "Red");
        tiles[25] = new Tile("Server 3", 25) { public void landOn(Player p) {} };
        tiles[26] = new Property("Bubble Sort Boulevard", 26, 260, 22, "Yellow");
        tiles[27] = new Property("Selection Sort Street", 27, 260, 22, "Yellow");
        tiles[28] = new Tile("GitHub Repo", 28) { public void landOn(Player p) {} };
        tiles[29] = new Property("Insertion Sort International", 29, 280, 24, "Yellow");

        tiles[30] = new Tile("Go To Jail", 30) { public void landOn(Player p) {} };
        tiles[31] = new Property("Quick Sort Quizzes", 31, 300, 26, "Green");
        tiles[32] = new Property("Merge Sort Motel", 32, 300, 26, "Green");
        tiles[33] = new Tile("Community Chest", 33) { public void landOn(Player p) {} };
        tiles[34] = new Property("Heap Sort Haven", 34, 320, 28, "Green");
        tiles[35] = new Tile("Server 4", 35) { public void landOn(Player p) {} };
        tiles[36] = new Tile("Chance", 36) { public void landOn(Player p) {} };
        tiles[37] = new Property("Breadth First Search Boulevard", 37, 350, 35, "Dark Blue");
        tiles[38] = new Tile("Luxury Tax", 38) { public void landOn(Player p) {} };
        tiles[39] = new Property("Depth First Search Disaster", 39, 400, 50, "Dark Blue");
    }

    public void draw() {
        float boardSize = min(width, height) * 0.95; 
        float cornerSize = boardSize * 0.13; 
        float tileSize = (boardSize - 2 * cornerSize) / 9.0; 
        float startX = (width - boardSize) / 2;
        float startY = (height - boardSize) / 2;
        fill(240, 255, 240); 
        rect(startX + cornerSize, startY + cornerSize, boardSize - 2 * cornerSize, boardSize - 2 * cornerSize);       
        fill(0);
        textSize(64);
        textAlign(CENTER, CENTER);
        text("MONOPOLY", startX + (boardSize / 2), startY + (boardSize / 2));
        for (int i = 0; i < 40; i++) {
            float x = 0, y = 0, w = 0, h = 0;
            if (i == 0) { 
                x = startX + boardSize - cornerSize; 
                y = startY + boardSize - cornerSize; 
                w = cornerSize; h = cornerSize;
            } else if (i > 0 && i < 10) { 
                x = startX + boardSize - cornerSize - (i * tileSize); 
                y = startY + boardSize - cornerSize; 
                w = tileSize; h = cornerSize;
            } else if (i == 10) { 
                x = startX; 
                y = startY + boardSize - cornerSize; 
                w = cornerSize; h = cornerSize;
            } else if (i > 10 && i < 20) { 
                x = startX; 
                y = startY + boardSize - cornerSize - ((i - 10) * tileSize); 
                w = cornerSize; h = tileSize;
            } else if (i == 20) { 
                x = startX; 
                y = startY; 
                w = cornerSize; h = cornerSize;
            } else if (i > 20 && i < 30) { 
                x = startX + cornerSize + ((i - 20) * tileSize) - tileSize; 
                y = startY; 
                w = tileSize; h = cornerSize;
            } else if (i == 30) { 
                x = startX + boardSize - cornerSize; 
                y = startY; 
                w = cornerSize; h = cornerSize;
            } else if (i > 30 && i < 40) { 
                x = startX + boardSize - cornerSize; 
                y = startY + cornerSize + ((i - 30) * tileSize) - tileSize; 
                w = cornerSize; h = tileSize;
            }
            stroke(0);
            strokeWeight(2);
            fill(255);
            rect(x, y, w, h);
            fill(0);
            textSize(12);
            textAlign(CENTER, CENTER);
            text(tiles[i].name, x + 2, y + 2, w - 4, h - 4);
        }
    }

    public Tile getTile(int pos) {
        return tiles[pos % 40]; 
    }
}