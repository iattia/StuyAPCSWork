public class CommunityChestTile extends Tile {
    private String[] chestOptions = {
        "Passed the AP CSA Exam! Collect $100",
        "Advance to GO (Collect $200)",
        "Syntax Error in your homework! Pay $100 grade penalty fee",
        "Won first prize in the Stuyvesant Code Olympics! Collect $150",
        "Get Out of Jail Free card (Successfully resolved NullPointerException)",
        "Infinite Loop detected! Sent to Jail. Go directly to Jail, do not pass GO, do not collect $200",
        "Forgot to return a value in a method. Pay $50 fine",
        "Found a bug in the grading script! Collect $50",
        "Helped your classmates with recursion! Collect $10 from each player",
        "Bought a premium IDE license. Pay $50",
        "Optimized your search algorithm. Collect $100",
        "Coding bootcamp enrollment fee. Pay $150",
        "Consulting fee for tutoring. Collect $25",
        "Sold a custom sorting animation to the teacher. Collect $100",
        "AP Exam fee refund. Collect $20",
        "Bought textbooks for AP CSA. Pay $10"
    };

    public CommunityChestTile(String name, int position) {
        super(name, position);
    }

    @Override
    public void landOn(Player p) {
        int cardIndex = (int)(Math.random() * chestOptions.length);
        String cardText = chestOptions[cardIndex];
        System.out.println(p.name + " drew Community Chest: " + cardText);
        
        if (cardIndex == 0) {
            p.money += 100;
        } else if (cardIndex == 1) {
            p.position = 0;
            p.money += 200;
        } else if (cardIndex == 2) {
            p.pay(100);
        } else if (cardIndex == 3) {
            p.money += 150;
        } else if (cardIndex == 4) {
            System.out.println(p.name + " holds a Get Out of Jail Free card!");
        } else if (cardIndex == 5) {
            p.position = 10;
            p.inJail = true;
            p.jailTurnsTracked = 0;
        } else if (cardIndex == 6) {
            p.pay(50);
        } else if (cardIndex == 7) {
            p.money += 50;
        } else if (cardIndex == 8) {
            for (Player other : players) {
                if (other != p && !other.getBankrupt()) {
                    other.pay(10, p);
                }
            }
        } else if (cardIndex == 9) {
            p.pay(50);
        } else if (cardIndex == 10) {
            p.money += 100;
        } else if (cardIndex == 11) {
            p.pay(150);
        } else if (cardIndex == 12) {
            p.money += 25;
        } else if (cardIndex == 13) {
            p.money += 100;
        } else if (cardIndex == 14) {
            p.money += 20;
        } else if (cardIndex == 15) {
            p.pay(10);
        }
        
        if (cardIndex == 1 || cardIndex == 5) {
            wasMovedByCard = true;
        }
        
        triggerPopup("Community Chest", p.name + " drew:\n" + cardText);
    }
}