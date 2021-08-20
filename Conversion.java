import java.util.Stack;

public class Conversion {
    String exp;                                                             //creates locale variable to copy user input from conversion button action
    String reverseString = "";
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
            System.out.println("There are a total of  " + exp.length() + " index in this String");

            for(int i = exp.length()-1; i>=0; i--){
                //reverseString = reverseString + exp.charAt(i);

                //char testIndex = exp.charAt(i);

                switch(exp.charAt(i)){
                    case '*':
                    case '/':
                    case '+':
                    case '-':

                    System.out.println("Character at index " + i + " is a " + exp.charAt(i));
                    break;

                    default : 

                    System.out.println("Character at index " + i + " is an operand. ");                 

                    break;


                }

            }
        }

        //System.out.println("testing reverse :" + reverseString);
        
    }

    // public String getResult(){
    //     return reverseString;
    // }
    

    
    
}
