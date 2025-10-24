public class SuperArray{
  private int size, length;
  private String[] data = new String[10];
  public SuperArray(){
    length = 10;
    data = new String[length];
    size = 0;
  }
  public int size(){
    return size;
  }
  public boolean add(String value) {
    if (size >= data.length) {
      resize();
    }
    data[size] = value;
    size++;
    return true;
  }
  public String toString(){
    String arrString = "[";
    if (size == 0){
      return "[]";
    }
    for (int i=0;i<size;i++){
      arrString += data[i] + ", ";
    }
    arrString = arrString.substring(0,arrString.length()-2);
    return arrString+"]";
  }
  /* Phase 2 */
  public String get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException(
        System.out.println()
      )
    }
    return data[index];
  }
  public String set(int index, String newVal){
    if (index < 0 || index >= size){
      System.out.println("Error");
      return null;
    }
    String replaced = data[index];
    data[index] = newVal;
    return replaced;
  }
  /* Phase 3 */
  public SuperArray(int initialCapacity){
    if (initialCapacity < 0){
      System.out.println("Error");
      initialCapacity = 10;
    }
    data = new String[initialCapacity];
    size = 0;
  }
  private void resize() {
    int newLength = 2 * data.length + 1;
    String[] newData = new String[newLength];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  /* Test for private methods (resize) */
  public static void main(String[] args) {
    SuperArray sup = new SuperArray();
    for (int i = 1; i <= 15; i++) {
      sup.add("Item" + i);
    }
    System.out.println(sup);
    System.out.println("Size: " + sup.size());
    System.out.println("Internal array length: " + sup.data.length);
  }
}
