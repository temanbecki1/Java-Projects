import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


/* This class extends our JFrame from GUI class and adds all relative Java Swing components to the GUI
*/

public class MainFrame extends JFrame {
    final static boolean shouldFill = true;


    public MainFrame(String title){
        super(title);

        //set layout manager
        setLayout(new GridBagLayout());                                     //sets our layout to utilize GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();                  //creates our GridBagConstraints object



        //create Swing components
        JLabel enterExpressionLabel = new JLabel("Enter Expression");       //creates our Enter Expression label
        JLabel resultFieldLabel = new JLabel("Result");                     //creates label for result text field

        JTextField enterExpressionTxt = new JTextField("");                 //creates our text field to enter our Expression
        JTextField resultFieldTxt = new JTextField("");                     //creates our result text field. This will not be editable by user

        JButton prefixToPostfixBtn = new JButton("Prefix to Postfix");      //creates button to prompt conversion from prefix to postfix 
        JButton postfixToPrefixBtn = new JButton("Postfix to Prefix");      //create button to prompt conversion from postfix to prefix

        //Set the result field to uneditable.

        resultFieldTxt.setEditable(false);                                  //sets the result field to display result only


        //add Swing components to content pane
        //row one includes 1 label and 1 text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.35;                                                 //we give small spacing between our rows on the y axis 
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(enterExpressionLabel, gbc);                                //adds the enterExpression Label to the GridBagConstraints object gbc

        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(enterExpressionTxt, gbc);                                  //adds the enterExpressionTxt field to the GridBagConstraints object



        //row two includes two buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,7,0,0);                                  //middle padding padding
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


        



        


    }
    
}