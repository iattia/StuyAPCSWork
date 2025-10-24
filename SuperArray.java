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
  public boolean add(String value){
    if (size<length){
      data[size] = value;
      size++;
      return true;
    }
    return false;
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
      System.out.println("Error");
      return null;
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
}
