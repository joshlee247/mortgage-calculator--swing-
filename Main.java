/*
program name: Mortgage Calculator.java
programmer: Josh Lee
date: 10/29/20
version: 1.3
Creates a program in Java Swing to compute your monthly mortgage with a seamless UI.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
  class Main {
    public static void main(String[] args)
    {
      //initializes cFrame as an object of JCalcFrame
      JCalcFrame cFrame = new JCalcFrame();
      cFrame.getContentPane().setBackground(Color.WHITE);
      cFrame.setTitle("Mortgage Calculator");
      cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //sets size of cFrame window
      cFrame.setSize(600,300);

      //aligns all components to center
      //cFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 10));
      cFrame.setVisible(true);
    }
  }
