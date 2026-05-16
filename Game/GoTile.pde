public class GoTile extends Tile {
    public GoTile(String name, int position) {
        super(name, position);
    }

    @Override
    public void landOn(Player p) {
        p.money += 200;
    }
}