import java.util.ArrayList;

public class NoNullArrayList<T> extends ArrayList<T>{
  public NoNullArrayList(int capacity){
    super(capacity);
  }
  public NoNullArrayList(){
    super();
  }
  public void add(int index, T value){
    if (value == null){
      throw new IllegalArgumentException("Cannot add null!");
    } else{
      super.add(index, value);
    }
  }
  public boolean add(T value){
    if (value == null){
      throw new IllegalArgumentException("Cannot add null!");
    } else{
      super.add(value);
      return true;
    }
  }
  public T set(int index, T value){
    if (value == null){
      throw new IllegalArgumentException("Cannot add null!");
    } else{
      T replaced = this.get(index);
      super.set(index, value);
      return replaced;
    }
  }
}
