public class ChanceTile extends Tile {
    private String[] chanceOptions = new String[]{"test"};
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
