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
  JTextField userP = new JTextField("$",3);
  JTextField userR = new JTextField("3.92",3);
  //JTextField userT = new JTextField();

  String T[] = {"10","15","20","25","30","40"};
  JComboBox userT = new JComboBox(T);

  JButton calcButton = new JButton("Calculate");
  
  JButton exitButton = new JButton("Exit");
  JButton reset = new JButton("Reset");

  JLabel blankSpaces1 = new JLabel("         ");
  JLabel blankSpaces2 = new JLabel("         ");
  JLabel result = new JLabel("The total is: ");
  JLabel sum = new JLabel("");

  public JCalcFrame()
  {
    //creates the general look of the UI
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
    title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
    con.add(outer);
    outer.add(row0);
    row0.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
    row0.add(title);

    outer.add(row1);
    row1.add(col1);
    row1.add(col2);
    row1.add(col3);
    
    col1.add(principal);
    col1.add(userP);


    col2.add(rate);
    col2.add(userR);

    col3.add(term);
    //userT.setBounds(50,50,90,20);
    col3.add(userT);

    //col6.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
    outer.add(row2);
    row2.add(col4);
    row2.add(col5);
    row2.add(col6);
    
    row3.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
    row3.add(calcButton);
  
    //con.add(blankSpaces1);

    col6.add(result);
    sum.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
    col6.add(sum);

    //con.add(blankSpaces2);

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
        //userT.setText("");
      }
      else
          {
            // if the user clicks on the Exit button (source is Exit button)
            System.exit(0);
          }
   }// end actionPerformed
}// end JCalcFrame

