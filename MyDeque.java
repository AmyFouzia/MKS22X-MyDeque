import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = initialCapacity;
  }

  public int size(){
    return size;
  }

  @SuppressWarnings("unchecked")
  private void resize(){
		E[] track = data;

		if (data.length == 0)
			data = (E[])new Object[(track.length + 1 )* 2];
		else
			data = (E[])new Object[(track.length * 2)];

		for (int i = 0; i < track.length; i++) {
			data[i] = track[i];
		}
  }

  public String toString(){
    String res = "";

    for(int i = 0; i < data.length; i++){
      res += data[i];
      if (i != size() - 1){
        res += ", ";
      }
    }
    return res;
  }

  public void addFirst(E element){
    if(element == null) throw new NullPointerException();

  }

  public void addLast(E element){
    if(element == null) throw new NullPointerException();

    if (data.length == size())
			resize();
			data[size()] = element;
			size ++;

  }

  public E removeFirst(){
    if(data[0] == null) throw new NullPointerException();

		E track = data[0];
		for (int i = 0; i < data.length-1; i++) {
			data[i] = data[i+1]; //remove!!!
		}
		size--;

    return track;
  }

  public E removeLast(){
    return data[end];
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

/*  public void main(String[] args){
    MyDeque test = new MyDeque();
    System.out.println(MyDeque.toString());
  }*/
  public static void main(String[] args){
    MyDeque deque = new MyDeque<>();
      for(int i = 0; i < 10; i++){
        deque.addLast(i);
      }

      deque.removeFirst();
      System.out.println(deque.toString());
  }

}

/*
Add: (push / en-queue)
Get: return but NOT remove the element. (peek)
Remove: return AND remove the element. (pop / de-queue)

Size,Add, remove, and get should be O(1)
toString O(n) - format:  {a b c d }  / {}  /   {VALUE_VALUE2_VALUE3_}
(space after each value)

To create a generic array you need to create an array of Object, and
then cast it to E. This causes a warning, and you can use the
SuppressWarnings command to prevent it. This is an appropriate use of
the command because we need to instantiate an array of objects and cast it.
You would not use this in most other cases.

Suppress the warning in the constructor:

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

OR suppress the warning on the creation of the array, but you cannot directly
assign to the instance variable if you do this. (This would prevent the
accidental suppresion of additional warnings)

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }
*/
