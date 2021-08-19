import java.util.Stack;

public class Conversion {
    String exp;                                                             //creates locale variable to copy user input from conversion button action
    Stack<String> stack1;                                                   //creates empty stack
    

    public Conversion(){

    }

    public Conversion(String expression){
        this.exp = expression;

    }

    public void testInput(String expression){
        this.exp = expression;
       
        System.out.println("The input is " + exp);

        if(exp.length() >=0){                                               //test to see if length is greater than zero
            System.out.println("The length of input is " + exp.length());
        }
    }
    

    
    
}
