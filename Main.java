/*
program name: Mortgage Calculator.java
programmer: Josh Lee
date: 10/29/20
version: 1.3
Creates a program in Java Swing to calculate the temperature in Farenheit to Celsius
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
  class Main {
    public static void main(String[] args)
    {
      //initializes cFrame as an object of JCalcFrame
      JCalcFrame cFrame = new JCalcFrame();
      cFrame.setTitle("Farenheit to Celsius Calculator");
      cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //sets size of cFrame window
      cFrame.setSize(250,200);

      //aligns all components to center
      cFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
      cFrame.setVisible(true);
    }
  }
