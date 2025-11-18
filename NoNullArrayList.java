import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T>{
  public NoNullArrayList(int capacity){
    super(capacity);
  }
  public NoNullArrayList(){
    super();
  }
  public void add(int index, T value){
    this.add(value);
  }
  public boolean add(T value){
    if (value != null){
      throw new IllegalArgumentException("Cannot add null!");
    } else{
      this.add(this.whereToPlace(value), value);
      return true;
    }
  }
  public int whereToPlace(T value){
    if (value == null){
      return 0;
    } else{
      return this.size()-1;
    }
  }
}
