public class ChanceTile extends Tile {
    private String chance1 = "Advance to Depth First Search Disaster";
    private String chance2 = "Advance to Go (Collect $200)";
    private String chance3 = "Advance to TreeMap Terrace. If you pass Go, collect $200";
    private String chance4 = "Advance to Int International. If you pass Go, collect $200";
    private String chance5 = "Advance to the nearest Server. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled";
    private String chance6 = "Advance to the nearest Server. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled";
    private String chance7 = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown";
    private String chance8 = "Bank pays you dividend of $50";
    private String chance9 = "Get Out of Jail Free";
    private String chance10 = "Go Back 3 Spaces";
    private String chance11 = "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200";
    private String chance12 = "Make general repairs on all your property. For each house pay $25. For each hotel pay $100";
    private String chance12 = "Speeding fine $15";
    private String chance14 = "Take a trip to Server 1. If you pass Go, collect $200";
    private String chance15 = "You have been elected Chairman of the Board. Pay each player $50";
    private String chance16 = "Your building loan matures. Collect $150";
    private String[] chanceOptions = new String[]{chance1, chance2, chance3, chance4, chance5, chance6, chance7, chance8, chance9, chance10, chance11, chance12, chance13, chance14, chance15, chance16};
    public ChanceTile(String name, int position) {
        super(name, position);
    }

    @Override
    public void landOn(Player p) {
        // TODO: Handle logic for landing on chance
    }

    public String getChance() {
      return chanceOptions[(int)(Math.random() * chanceOptions.length)];
    }
}
