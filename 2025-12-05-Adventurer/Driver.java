public class Driver {
    public static void main(String[] args) {

        Adventurer w1 = new Witch("Harry");
        Adventurer w2 = new Witch("Selene", 60, 80);

        System.out.println("=== Initial Stats ===");
        System.out.println(w1);
        System.out.println(w2);
        System.out.println();

        System.out.println("=== Harry attacks Selene ===");
        System.out.println(w1.attack(w2));
        System.out.println(w2);
        System.out.println();

        System.out.println("=== Selene heals Harry ===");
        System.out.println(w2.support(w1));
        System.out.println(w1);
        System.out.println();

        System.out.println("=== Harry heals herself ===");
        System.out.println(w1.support());
        System.out.println(w1);
        System.out.println();

        System.out.println("=== Selene uses special attack on Harry ===");
        System.out.println(w2.specialAttack(w1));
        System.out.println(w2);
        System.out.println(w1);
        System.out.println();

        System.out.println("=== Draining Selene’s mana ===");
        w2.setSpecial(10);
        System.out.println(w2.specialAttack(w1)); // should fail
        System.out.println(w2);
        System.out.println();

        System.out.println("=== Restoring Selene’s mana ===");
        int restored = w2.restoreSpecial(50);
        System.out.println("Mana restored: " + restored);
        System.out.println(w2);
    }
}
