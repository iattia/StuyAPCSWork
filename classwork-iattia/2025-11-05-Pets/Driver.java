//Ethan Chang & Ibrahim Attia
/* Q1:  When we made the change to override getName, the new getName took precedent over the old getName, but we were still able to call the old (superclass) getName to actually modify the new (subclass) getName. More generally, the subclass methods take precedent over the superclass methods.
Q2: The third attempt of initialization results in an error because the bird constructor does not have enough information from the arguments in animal. Bird is-A animal, but animal is not is-a bird. There will be missing information which results in an error. */
public class Driver{
  public static void main(String[] args){
    Animal a1 = new Animal("bark", 3, "Larry");
    a1.speak();

    Bird b1 = new Bird("chirp", 7, "Henry", 6, "black");
    b1.speak();

    Animal a2 = new Animal("bark", 3, "Larry");
    Bird b2 = new Bird("chirp", 7, "Henry", 6, "black");
    //Bird b3 = new Animal("bark", 3, "Larry");
    Animal a3 = new Bird("chirp", 7, "Henry", 6, "black");

    a2.speak();
    b2.speak();
    a3.speak();
  }
}