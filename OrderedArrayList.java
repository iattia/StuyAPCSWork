public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T>{
  public OrderedArrayList(int capacity){
    super(capacity);
  }
  public OrderedArrayList(){
    super();
  }
  public int whereToPlace(T value){
    if (value == null){
      return 0;
    }
    for (int i=0;i<this.size();i++){
      int comparison = value.compareTo(this.get(i));
      if (i == 0 && comparison < 0){
        return 0;
      }
      if (comparison>0){
        return i+1;
      }
    }
    return 0;
  }
}
