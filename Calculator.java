public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //push vals onto a stack to access two top values at a time

      String[] data = s.split(" "); //less lines than using a scanner oOf
      MyDeque<Double> stack = new MyDeque<>();

      for(int i = 0; i < data.length; i++){

        //adding
        if(data[i].equals("+")){
          Double last = stack.removeLast();
          Double last2 = stack.removeLast();
          stack.addLast(last + last2);
        }

        //subtracting
        else if(data[i].equals("-")){
          Double last = stack.removeLast();
          Double last2 = stack.removeLast();
          stack.addLast(last2 - last);
        }

        //multiplication
        else if(data[i].equals("*")){
          Double last = stack.removeLast();
          Double last2 = stack.removeLast();
          stack.addLast(last * last2);
        }

        //division
        else if(data[i].equals("/")){
          Double last = stack.removeLast();
          Double last2 = stack.removeLast();
          stack.addLast(last2 / last);
        }

        //mod
        else if(data[i].equals("%")){
          Double last = stack.removeLast();
          Double last2 = stack.removeLast();
          stack.addLast(last2 % last);
        }

        else{
          stack.addLast(Double.valueOf(data[i]));
        }

      }
      return stack.getFirst();
    }
}

/*
Write the eval(String) method, that will correctly evaluate a post-fix expression.
eval("10 2.0 +") is 12.0
eval("11 3 - 4 + 2.5 *") is 30.0
eval("8 2 + 99 9 - * 2 + 9 -") is 893.0
eval("1 2 3 4 5 + * - -") is 26.0
The order is left to right just like scheme : "3 2 -" is 1

1. Convert your string into tokens. (A list of values and operators)
1b. Test this by printing each one!
2. Instead of printing each one, decide what to do with them...
*/
