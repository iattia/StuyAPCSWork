public class ChanceTile extends Tile {
    private String[] chanceOptions = {
        "Advance to Depth First Search Disaster",
        "Advance to Go (Collect $200)",
        "Advance to Full Tree Terrace. If you pass Go, collect $200",
        "Advance to Int International. If you pass Go, collect $200",
        "Advance to the nearest Server.",
        "Advance to the nearest Server.",
        "Advance token to nearest Utility.",
        "Bank pays you dividend of $50",
        "Get Out of Jail Free",
        "Go Back 3 Spaces",
        "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200",
        "Make general repairs on all your property.",
        "Speeding fine $15",
        "Take a trip to Server 1. If you pass Go, collect $200",
        "You have been elected Chairman of the Board. Pay $50",
        "Your building loan matures. Collect $150"
    };
    public ChanceTile(String name, int position) {
        super(name, position);
    }
    @Override
    public void landOn(Player p) {
        int cardIndex = (int)(Math.random() * chanceOptions.length);
        String cardText = chanceOptions[cardIndex];
        System.out.println(p.name + " drew Chance: " + cardText);
        if (cardIndex == 0) {
            p.position = 39;
        } else if (cardIndex == 1) {
            p.position = 0;
            p.money += 200;
        } else if (cardIndex == 2) {
            if (p.position > 24) p.money += 200;
            p.position = 24;
        } else if (cardIndex == 3) {
            if (p.position > 11) p.money += 200;
            p.position = 11;
        } else if (cardIndex == 4 || cardIndex == 5) {
            if (p.position < 5) {
                p.position = 5;
            } else if (p.position < 15) {
                p.position = 15;
            } else if (p.position < 25) {
                p.position = 25;
            } else if (p.position < 35) {
                p.position = 35;
            } else {
                p.position = 5;
                p.money += 200;
            }
        } else if (cardIndex == 6) {
            if (p.position < 12) {
                p.position = 12;
            } else if (p.position < 28) {
                p.position = 28;
            } else {
                p.position = 12;
                p.money += 200;
            }
        } else if (cardIndex == 7) {
            p.money += 50;
        } else if (cardIndex == 8) {
            System.out.println(p.name + " holds a Get Out of Jail Free card!");
        } else if (cardIndex == 9) {
            p.position = (p.position - 3 + 40) % 40;
        } else if (cardIndex == 10) {
            p.position = 10;
            p.inJail = true;
            p.jailTurnsTracked = 0;
        } else if (cardIndex == 11) {
            int repairCost = p.ownedProperties.size() * 25;
            p.pay(repairCost);
            System.out.println(p.name + " paid $" + repairCost + " in repairs.");
        } else if (cardIndex == 12) {
            p.pay(15);
        } else if (cardIndex == 13) {
            if (p.position > 5) p.money += 200;
            p.position = 5;
        } else if (cardIndex == 14) {
            p.pay(50);
        } else if (cardIndex == 15) {
            p.money += 150;
        }
        
        if (cardIndex == 0 || cardIndex == 1 || cardIndex == 2 || cardIndex == 3 || cardIndex == 4 || 
            cardIndex == 5 || cardIndex == 6 || cardIndex == 9 || cardIndex == 10 || cardIndex == 13) {
            wasMovedByCard = true;
        }
        
        triggerPopup("Chance Card", p.name + " drew:\n" + cardText);
    }
}