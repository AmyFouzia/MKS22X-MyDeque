public class Driver{
  public static void main(String[] args){
    // MyDeque<Integer> deque1 = new MyDeque<>();
    // System.out.println(deque1);
    // deque1.addFirst(5);
    // deque1.addFirst(10);
    // System.out.println(deque1.size());
    // System.out.println(deque1);

    System.out.println(Calculator.eval("10 10 +"));//should be 20.0
    System.out.println(Calculator.eval("10 2.0 +"));//should be 12.0
    System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));//should be 30.0
    System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));//should be 893.0
    System.out.println(Calculator.eval("1 2 3 4 5 + * - -"));//should be 26.0
  }
}
