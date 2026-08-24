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
    super.add(this.whereToPlace(value), value);
    return true;
  }
  public void add(int index, T value){
    this.add(value);
  }
  public T set(int index, T value){
    T replaced = this.get(index);
    this.add(value);
    this.remove(index);
    return replaced;
  }
}
