public class Property extends Tile {
    public int price;
    public int rent;
    public String colorGroup;
    public Player owner;
    public Property(String name, int position, int price, int rent, String colorGroup) {
        super(name, position);
        this.price = price;
        this.rent = rent;
        this.colorGroup = colorGroup;
        this.owner = null;
    }
    @Override
    public void landOn(Player p) {
        if (this.owner == null) {
            System.out.println(p.name + " landed on unowned " + this.name + ".");
        } else if (this.owner != p) {
            int amountOwed = calculateRent();
             p.pay(amountOwed, this.owner);
            //this.owner.addBalance(amountOwed);
            System.out.println(p.name + " paid $" + amountOwed + " rent to " + this.owner.name);
            triggerPopup("Rent Payment", p.name + " paid $" + amountOwed + " rent to " + this.owner.name + "!");
        }
    }
    public int calculateRent() {
        if (owner == null) return this.rent;
        if (colorGroup.equals("Server")) {
            int serversOwned = 0;
            for (Property prop : owner.ownedProperties) {
                if (prop.colorGroup.equals("Server")) {
                    serversOwned++;
                }
            }
            return (int) (25 * Math.pow(2, serversOwned - 1));
        }
        if (colorGroup.equals("Utility")) {
            int utilitiesOwned = 0;
            for (Property prop : owner.ownedProperties) {
                if (prop.colorGroup.equals("Utility")) {
                    utilitiesOwned++;
                }
            }
            int defaultRoll = 7;
            int lastRoll = defaultRoll;
            if (dice != null) {
                lastRoll = dice.die1 + dice.die2;
            }
            if (utilitiesOwned == 2) {
                return 10 * lastRoll;
            } else {
                return 4 * lastRoll;
            }
        }
        int totalInGroup = 0;
        int ownerHas = 0;
        if (colorGroup.equals("Brown") || colorGroup.equals("Dark Blue")) {
            totalInGroup = 2;
        } else {
            totalInGroup = 3;
        }
        for (Property prop : owner.ownedProperties) {
            if (prop.colorGroup.equals(this.colorGroup)) {
                ownerHas++;
            }
        }
        if (ownerHas == totalInGroup) {
            return this.rent * 2;
        }
        return this.rent;
    }
}