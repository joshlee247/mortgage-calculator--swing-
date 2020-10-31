//File name: JCalcFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class JCalcFrame extends JFrame implements ActionListener
{
  FlowLayout flow = new FlowLayout();
  JLabel title = new JLabel("Mortgage Calculator");

  //creates button to enter farenheit value
  JLabel principal = new JLabel("Mortgage principal");
  JLabel rate = new JLabel("Interest rate (%)");
  JLabel term = new JLabel("Mortgage term (years)");

  //user input text field
  JTextField userP = new JTextField("100000",3);
  JTextField userR = new JTextField("3.92",3);
  //JTextField userT = new JTextField();

  String T[] = {"10","15","20","25","30","40"};
  JComboBox userT = new JComboBox(T);

  JButton calcButton = new JButton("Calculate");
  
  JButton exitButton = new JButton("Exit");
  JButton reset = new JButton("Reset");

  JLabel result = new JLabel("The total is: ");
  JLabel sum = new JLabel("  ");

  //creates the general look of the UI
  public JCalcFrame()
  {
    Container con = getContentPane();
    Box outer = Box.createVerticalBox();
    // Title
    Box row0 = Box.createHorizontalBox();
    // Entry Fields
    Box row1 = Box.createHorizontalBox();
    Box col1 = Box.createVerticalBox();
    Box col2 = Box.createVerticalBox();
    Box col3 = Box.createVerticalBox();

    // Total
    Box row2 = Box.createHorizontalBox();
    Box col4 = Box.createVerticalBox();
    Box col5 = Box.createVerticalBox();
    Box col6 = Box.createVerticalBox();
    Box row3 = Box.createHorizontalBox();
    Box row4 = Box.createHorizontalBox();

    con.setLayout(flow);
    //creates heading title 22pt font
    title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
    title.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));

    //creates boxes to organize the layout
    con.add(outer);
    outer.add(row0);
    //adds title
    row0.add(title);

    //adds row1 to outside container
    outer.add(row1);

    //adds 3 columns to row1
    row1.add(col1);
    row1.add(col2);
    row1.add(col3);

    //margin spacing
    col1.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
    col2.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
    
    //adds input title and text field to col1
    principal.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
    principal.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
    col1.add(principal);
    userP.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    userP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    col1.add(userP);

    //adds input title and text field to col2
    rate.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
    rate.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
    col2.add(rate);
    userR.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));    
    userR.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    col2.add(userR);

    //adds input title and text field to col3
    term.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
    term.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
    col3.add(term);
    //makes the dropdown menu transparent
    userT.setEditable(true);
    JTextField boxField = (JTextField)userT.getEditor().getEditorComponent();
    boxField.setBorder(BorderFactory.createEmptyBorder());
    userT.setBackground(new Color(0,0,0,0));
    userT.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    userT.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));   
    //adds dropdown 
    col3.add(userT);

    //adds spacing and other components
    row2.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    outer.add(row2);
    row2.add(col4);
    row2.add(col5);
    row2.add(col6);
    
    //adds spacing and calcButton
    sum.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
    row3.add(calcButton);

    //displays total monthly Mortgage
    col6.add(result);
    sum.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
    col6.add(sum);

    //displays exit and reset button
    outer.add(row3);
    outer.add(row4);
    row4.add(exitButton);
    row4.add(reset);  

    calcButton.addActionListener(this);
    exitButton.addActionListener(this);
    reset.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
     Object source = e.getSource();
     if(source == calcButton)
     {
        String pattern = "###,###.##";
        DecimalFormat df = new DecimalFormat(pattern);

        String num1 = userP.getText();
        String num2 = userR.getText();
        String num3 = userT.getSelectedItem().toString();

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double n3 = Double.parseDouble(num3);

        //calculates Farenheit to Celsius
        n2 = n2/1200;
        n3 = n3*12;
        double total = (n1 * n2) / (1 - Math.pow(1+n2,-n3));
 
        //converts total to string
        String output = "$" + df.format(total);

        if((n1 < 0) || (n2 < 0) || (n3 < 0)) {
          output = "Invalid values. Try again";
        }
        sum.setText(output);
      }
      else
      if(source == reset)
      {
        sum.setText("");
        userP.setText("");
        userR.setText("");
      }
      else
          {
            // if the user clicks on the Exit button (source is Exit button)
            System.exit(0);
          }
   }// end actionPerformed
}// end JCalcFrame

