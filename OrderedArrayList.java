public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
  public OrderedArrayList(int capacity){
    super(capacity);
  }
  public OrderedArrayList(){
    super();
  }
  private int whereToPlace(T value){
    if (value == null){
      return 0;
    }
    for (int i=0;i<this.size();i++){
      int comparison = value.compareTo(this.get(i));
      if (comparison < 0){
        return i;
      }
    }
    return this.size();
  }
  public boolean add(T value){
    try{
      super.add(this.whereToPlace(value), value);
      return true;
    } catch (IllegalArgumentException e){
      e.printStackTrace();
    }
    return false;
  }
  public void add(int index, T value){
    this.add(value);
  }
  public T set(int index, T value){
    T replaced = this.get(index);
    super.remove(index);
    this.add(value);
    return replaced;
  }
}
