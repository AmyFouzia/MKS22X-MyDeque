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

    if(size() == data.length) resize();

    if(size() != 0){

      if(start == 0){
        start = data.length - 1;
      }

      else {start--;}
    }

    data[start] = element;
    size++;
  }

  public void addLast(E element){
    if(element == null) throw new NullPointerException();

    if(size() == data.length) resize();

    if(size != 0){

      if(end == data.length - 1){
        end = 0;
      }
      else {end++;}
    }

    data[end] = element;
    size++;
  }

  public E removeFirst(){
    if(size() == 0) throw new NoSuchElementException();

		E track = data[start];
    data[start] = null;

    if(size() != 1){
      if(start == data.length - 1){
        start = 0;
      }
      else{start++;}
    }

		size--;
    return track;
  }

  public E removeLast(){
    if(size() == 0) throw new NoSuchElementException();

    E track = data[end];
    data[end] = null;

    if(size() != 1){
      if(end == 0){
        end = data.length - 1;
      }
      else {end--;}
      }
    }

    size--;
    return track;
  }

  public E getFirst(){
    if(size() == 0) throw new NoSuchElementException();
    return data[start];
  }

  public E getLast(){
    if(size() == 0) throw new NoSuchElementException();
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

      System.out.println(deque.removeFirst());
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
