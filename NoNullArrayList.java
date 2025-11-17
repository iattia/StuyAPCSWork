import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T>{
  public NoNullArrayList(int capacity){
    super.ArrayList(capacity);
  }
  public void add(int index, T value){
    this.add(value);
  }
  public boolean add(T value){
    if (value != null){
      throw (IllegalArgumentException);
    } else{
      this.add(whereToPlace(), value);
      return true;
    }
  }
  public int whereToPlace(T value){
    for (int i=0;i<this.size();i++){
      if (value.compareTo(this.getValue(i))>0){
        return i+1;
      }
    }
  }
}
