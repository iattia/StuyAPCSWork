public class SuperArray{
  private int size, length;
  private String[] data = new String[];
  public SuperArray(){
    length = 10;
    data = new String[length];
    size = 0;
  }
  public int size(){
    return this.size;
  }
  public boolean add(String value){
    if (this.size<this.length){
      this[size+1] = value;
      return true;
    }
    return false;
  }
  public String toString(){
    String arrString = "[";
    if (this.size == 0){
      return "[]";
    }
    for (int i=0;i<this.size;i++){
      arrString += this[i] + ", ";
    }
    arrString = arrString.substring(0,arrString.length()-2);
    return arrString
  }
}
