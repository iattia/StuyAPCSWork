public abstract class Tile {
    public String name;
    public int position;

    public Tile(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public abstract void landOn(Player p);
}