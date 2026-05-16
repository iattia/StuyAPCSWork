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
    public void landOn(Player p) {
        if (this.owner == null) {
            System.out.println(p.name + " landed on unowned " + this.name + " ($" + this.price + ")");
        } else if (this.owner != p) {
            int amountOwed = calculateRent();
            //p.pay(amountOwed);
            //this.owner.addBalance(amountOwed);
            System.out.println(p.name + " paid $" + amountOwed + " rent to " + this.owner.name);
        }
    }
    public int calculateRent() {
        return this.rent;
    }
}
