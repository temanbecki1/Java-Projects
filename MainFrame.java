import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;


/*Author : Teman Beck
*Date : August 18th, 2021
*This class extends our GUI class and adds all relative Java Swing components to the GUI
*/

public class MainFrame extends JFrame {
    final static boolean shouldFill = true;
    private String inputExpression;                                                                             //declare string variable to intake enterExpressionTxt field
    private boolean found = false;
    

    public MainFrame(String title){
        super(title);

        //set layout manager
        setLayout(new GridBagLayout());                                                                         //sets our layout to utilize GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();                                                      //creates our GridBagConstraints object

        //create Swing components
        JLabel enterExpressionLabel = new JLabel("Enter Expression");                                           //creates our Enter Expression label
        JLabel resultFieldLabel = new JLabel("Result");                                                         //creates label for result text field

        JTextField enterExpressionTxt = new JTextField("");                                                     //creates our text field to enter our Expression
        JTextField resultFieldTxt = new JTextField("");                                                         //creates our result text field. This will not be editable by user

        JButton prefixToPostfixBtn = new JButton("Prefix to Postfix");                                          //creates button to prompt conversion from prefix to postfix 
        JButton postfixToPrefixBtn = new JButton("Postfix to Prefix");                                          //create button to prompt conversion from postfix to prefix

        //Set the result field to uneditable.
        resultFieldTxt.setEditable(false);                                                                      //sets the result field to display result only
          
        //add Swing components to content pane
        //row one includes 1 label and 1 text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.35;                                                                                     //we give small spacing between our rows on the y axis 
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(enterExpressionLabel, gbc);                                                                    //adds the enterExpression Label to the GridBagConstraints object gbc

        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(enterExpressionTxt, gbc);                                                                      //adds the enterExpressionTxt field to the GridBagConstraints object



        //row two includes two buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,7,0,0);                                                                       //middle padding padding
        this.add(prefixToPostfixBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth =1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(postfixToPrefixBtn, gbc);

        //row three includes one label and one text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(resultFieldLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(resultFieldTxt, gbc);
        
        
        prefixToPostfixBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Takes input field expression and converts it to postfix   
                setInputExpression(enterExpressionTxt.getText());                                               //calls the setInputExpressionTxt method button event

                char lastCharacter = inputExpression.charAt(inputExpression.length()-1);
                char firstCharacter= inputExpression.charAt(0);
               
                switch(firstCharacter){
                    case '+':
                    case '-':
                    case '/':
                    case '*':
                    
                    System.out.println("lastCharacter is :" + lastCharacter);

                    if(lastCharacter == '+' || lastCharacter == '-' || lastCharacter == '*' || lastCharacter == '/') {
                        //This is where JOptionpane goes with ending in operator
                        JOptionPane.showMessageDialog(null, "Invalid syntax. Expression ended with an operator.",               //JOptionPane popup
                         "Last Character Syntax", JOptionPane.ERROR_MESSAGE);
                    } else {
                        extracted();                                                                                            //sets boolean found to true
                    }
                    break;

                    default:

                    JOptionPane.showMessageDialog(null, "Invalid syntax. Expression Started with an operand.",                  //JOptionPane popup
                         "Last Character Syntax", JOptionPane.ERROR_MESSAGE);
                    break;
                }
               

                if (found){ 
                    System.out.println("Beginning of found, its vaule is :" + found);
                    Conversion conversion = new Conversion();                           //calls new instance of conversion           
            
                    conversion.preToPost(conversion.removeSpace(inputExpression));      //calls method to convert to postfix expression
                
                    String operands = conversion.getResult();                           //create and initialize operands to getResult method in conversion class
                                      
                    resultFieldTxt.setText(operands);                                   //sets JTextfield to operand string 

                    reset();

                    System.out.println(" The value of found is now :" + found);

                }
            }            
        });


        postfixToPrefixBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Takes input field expression and converts it to prefix
                setInputExpression(enterExpressionTxt.getText());                       //calls the setInputExpressionTxt method when button is clicked

                char lastCharacter = inputExpression.charAt(inputExpression.length()-1);
                char firstCharacter= inputExpression.charAt(0);
                char secondCharacter= inputExpression.charAt(1);
                
                switch(lastCharacter){
                    case '+':
                    case '-':
                    case '/':
                    case '*':

                    if(firstCharacter == '+'|| firstCharacter =='-' || firstCharacter =='*' || firstCharacter =='/' &&
                    secondCharacter == '+'|| secondCharacter =='-' || secondCharacter =='*' || secondCharacter =='/' ){
                        JOptionPane.showMessageDialog(null, "Invalid syntax. First 2 elements are not operands.",                  //JOptionPane popup
                        "Last Character Syntax", JOptionPane.ERROR_MESSAGE);

                    } else {
                        extracted();
                        
                    }
                        break;

                        default : 
                        JOptionPane.showMessageDialog(null, "Invalid syntax. Expression Ended with an operand.",                  //JOptionPane popup
                        "Last Character Syntax", JOptionPane.ERROR_MESSAGE);
                        break;


                }   

                if (found){
                    Conversion conversion = new Conversion();                           //calls new instance of conversion

                    conversion.postToPre(conversion.removeSpace(inputExpression));      //calls method to convert to prefix expression
                
                    String operands = conversion.getResult();                           //create and initialize operands to getResult method in conversion class
                                      
                    resultFieldTxt.setText(operands);                                   //sets JTextfield to operand string 
                }             
            }
        });
    }

    private boolean extracted() {                                                       //sets found to true
        return found = true;
    }

    private boolean reset() {                                                           //sets found to false
        return found = false;
    }
    //set setter method to obtain enterExpressionTxt from input
    public void setInputExpression(String newExpression){
        this.inputExpression = newExpression;                                           //assigns inputExpression from passed in String 
    } 
}
