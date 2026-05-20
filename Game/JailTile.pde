public class JailTile extends Tile {
    public JailTile(String name, int position) {
        super(name, position);
    }
    @Override
    public void landOn(Player p) {
        System.out.println(p.name + " is just visiting jail.");
    }
}