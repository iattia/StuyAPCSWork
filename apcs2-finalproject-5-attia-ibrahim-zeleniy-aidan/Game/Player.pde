import java.util.ArrayList;
public class Player {
    public String name;
    public int money;
    public int position;
    public ArrayList<Property> ownedProperties;
    public color playerColor;
    private boolean bankrupt;
    public int consecutiveDoubles;
    public boolean inJail;
    public int jailTurnsTracked;
    public Player(String name, color playerColor) {
        this.name = name;
        this.playerColor = playerColor;
        this.money = 1500;
        this.position = 0;
        this.ownedProperties = new ArrayList<Property>();
        this.bankrupt = false;
        this.consecutiveDoubles = 0;
        this.inJail = false;
        this.jailTurnsTracked = 0;
    }
    public void move(int steps) {
        position += steps;
        if (position >= 40) {
            position = position % 40;
            if (position != 0) {
                money += 200;
                System.out.println(name + " collected $200 for passing GO.");
            }
        }
    }
    public void pay(int amount, Player p) {
        money -= amount;
        if (p != null) {
            p.money += amount;
        }
        setBankrupt();
    }
    public void pay(int amount) {
        money -= amount;
        setBankrupt();
    }
    public void buyProperty(Property p) {
        if (p.owner == null) {
            money -= p.price;
            ownedProperties.add(p);
            p.owner = this;
            System.out.println(name + " now owns " + p.name + ".");
            setBankrupt();
        }
    }
    public void setBankrupt() {
        if (money < 0) {
            bankrupt = true;
        }
    }
    public boolean getBankrupt() {
        return bankrupt;
    }
}