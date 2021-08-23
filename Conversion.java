import java.util.Stack;

/*Author : Teman Beck
*Date : August 18th, 2021
*This class implements a stack to traverse expression.
*This class then handle all logical conversions and offers methods to retrieve converted expression
*/

public class Conversion {
    String exp;                                                                                                 //creates locale variable to copy user input from conversion button action
    Stack<String> operandStack = new Stack<String>();                                                           //creates empty stack
    
    public Conversion(){                                                                                        //default constructor

    }

    public Conversion(String expression){                                                                       //conversion constructor 
        this.exp = expression;                                                                                  //assigns the value passed in via expression to exp
    }

    public String getResult(){                                                                                  //method to return result
        return operandStack.peek();
    }

    public void preToPost(String expression){
        this.exp = expression;
       
        if(exp.length() >=0){                                                                                   //test to see if length is greater than zero

    //this is where I will add a getSource method or something. This is the prefix to postfix completed algorithm
            for(int i = exp.length()-1; i>=0; i--){                                                             //traverse expression string backwards instead of creating additional stacks

                switch(exp.charAt(i)){                                                                          //compares index i to specified cases
                    case '*':                       
                    case '/':
                    case '+':
                    case '-':

                    //if statement to check if stack is empty or if stack has less that 2 elements
                    if (operandStack.empty() || operandStack.size() < 2){

                        operandStack.push(Character.toString(exp.charAt(i)));

                        break;   
                    } else {
                    String stackBuilder1 = "";                                                                  //creates local variable to hold pop value
                    String stackBuilder2 = "";                                                                  //creates local variable to hold pop value
                    stackBuilder1 = operandStack.pop();                                                         //holds pop value
                    stackBuilder2 = operandStack.pop();                                                         //holds pop value

                    String completeString = stackBuilder1 + " " + stackBuilder2 + " " + exp.charAt(i);          //builds a string to add to stack

                    operandStack.push(completeString);                                                          //pushes new string onto stack

                    break;
                    }

                    default :                                                                                   //case for all other operand inputs

                    String operand = Character.toString(exp.charAt(i)) ;                                        //converts char to string and assigns to operand

                    operandStack.push((operand + " "));                                                         //pushes string to stack    

                    break;
                }
            }
        } 
    }

    public void postToPre(String expression){
        this.exp = expression;
       
        if(exp.length() >=0){                                                                                   //test length of expression for zero
            for(int i = 0; i < exp.length(); i++){

                switch(exp.charAt(i)){                                                                          //compares index i to specified cases
                    case '*':
                    case '/':
                    case '+':
                    case '-':
    
                    
                    if (operandStack.empty() || operandStack.size() < 2){

                        operandStack.push(Character.toString(exp.charAt(i)));

                        break;   
                    } else {
                        String stackBuilder1 = "";                                                              //creates local variable to hold pop value
                    String stackBuilder2 = "";                                                                  //creates local variable to hold pop value
    
                    stackBuilder1 = operandStack.pop();                                                         //holds pop value
                    stackBuilder2 = operandStack.pop();                                                         //holds pop value
    
                    String completeString = exp.charAt(i) + " " +  stackBuilder2 + " " + stackBuilder1;         //builds a string to add to stack
    
                    operandStack.push(completeString);                                                          //pushes new string onto stack
    
                    break;
                    }

                    default : 

                    String operand = Character.toString(exp.charAt(i)) ;                                        //converts char at index i to string object

                    operandStack.push((operand + " "));                                                         //pushes string to stack            

                    break;
                }
            }
        }                                                                   
    }


    public String removeSpace(String expression){                                                                //method to remove white spaces from textfield input        
    
        exp = expression.replaceAll("\\s","");                                                                  //specifies what to remove
        return exp;
    }     
}
            


