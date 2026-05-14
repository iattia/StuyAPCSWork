public abstract class Tile {
    public String name;
    public int position;
    
    public Tile(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    // Abstract method to be defined by subclasses for specific tile interactions
    public abstract void landOn(Player p);
}