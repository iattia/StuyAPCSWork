public class FreeParkingTile extends Tile {
    int toCollect = 0;
    public FreeParkingTile(String name, int position) {
        super(name, position);
    }
    @Override
    public void landOn(Player p) {
        System.out.println(p.name + " rested at Free Parking.");
    }
}