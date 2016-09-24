// Assignment #: 12
//         Name: Vanessa Bedolla
//    StudentID: 1204125606
//      Lecture: 1
//  Description: The Assignment 12 class creates a control panel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet
 {
  private final int WIDTH = 450;
  private final int HEIGHT = 340;

  public void init()
   {
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
 }
