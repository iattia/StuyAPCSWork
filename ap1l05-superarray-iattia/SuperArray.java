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
      throw new IndexOutOfBoundsException("Index is either negative or less than size. Received: "+index);
    }
    return data[index];
  }
  public String set(int index, String newVal){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index is either negative or less than size. Received: "+index);
    }
    String replaced = data[index];
    data[index] = newVal;
    return replaced;
  }
  /* Phase 3 */
  public SuperArray(int initialCapacity){
    if (initialCapacity < 0){
      throw new IllegalArgumentException("Initial capacity is negative. Received: "+initialCapacity);
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
  /* Phase 4 */
  public int indexOf(String target) {
    if (target == null) {
      for (int i = 0; i < size; i++) {
        if (data[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = 0; i < size; i++) {
        if (target.equals(data[i])) { 
          return i;
        }
      }
    }
    return -1;
  }
  public int lastIndexOf(String target) {
    if (target == null) {
      for (int i = size - 1; i >= 0; i--) {
        if (data[i] == null) {
          return i;
        }
      }
    } else {
      for (int i = size - 1; i >= 0; i--) {
        if (target.equals(data[i])) {
          return i;
        }
      }
    }
    return -1;
  }
  public void add(int index,String value){
    if (index < 0 || index > size){
      throw new IndexOutOfBoundsException("Index is either negative or less than size. Received: "+index);
    }
    if (size==data.length){
      resize();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = value;
    size++;
  }
  public String remove(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException("Index is either negative or less than size. Received: "+index);
    }
    String removedElement = data[index];
    for (int i=index;i<size-1;i++){
      data[i] = data[i+1];
    }
    size--;
    return removedElement;
  }
  public boolean remove(String target) {
    int index = this.indexOf(target);  
    if (index == -1) {
      return false;
    } else {
      this.remove(index);
      return true;
    }
  }
}
