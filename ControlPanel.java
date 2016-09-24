// Assignment #: 12
//         Name: Vanessa Bedolla
//    StudentID: 1204125606
//      Lecture: 1
//  Description: The control panel creates the content for the applet, including two ball panels
// and a way to control them using buttons and sliders.


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel
 {
   private BallPanel ball1, ball2;
   private int width, height;
   private int DIAMETER = 30;
   private JButton upR, downR, leftR, rightR, stopR, upB, downB, leftB, rightB, stopB;
   private JLabel label1, label2;
   private JSlider slider1, slider2;
   private JPanel panel2, panel3, panel4, panel5,panel6,panel7, panel10, panel11;

  public ControlPanel(int width, int height)
   {
       this.width = width;
       this.height = height;

       int buttonH = 10; // approximate height of buttons

       //create two ball panels, one with red (background cyan), one with blue (background yellow)
       ball1 = new BallPanel(0, (height-buttonH)/4-DIAMETER/2, Color.red, Color.cyan);
       ball2 = new BallPanel(0, (height-buttonH)/4-DIAMETER/2, Color.blue, Color.yellow);
       
       //start button creation
       ButtonListener listener=new ButtonListener();
       upR=new JButton("Up Red");
       upR.addActionListener(listener);
       
       downR=new JButton("Down Red");
       downR.addActionListener(listener);
       
       leftR=new JButton("Left Red");
       leftR.addActionListener(listener);
       
       rightR=new JButton("Right Red");
       rightR.addActionListener(listener);
       
       stopR=new JButton("Stop Red");
       stopR.addActionListener(listener);
       
       upB=new JButton("Up Blue");
       upB.addActionListener(listener);
       
       downB=new JButton("Down Blue");
       downB.addActionListener(listener);
       
       leftB=new JButton("Left Blue");
       leftB.addActionListener(listener);
       
       rightB=new JButton("Right Blue");
       rightB.addActionListener(listener);
       
       stopB=new JButton("Stop Blue");
       stopB.addActionListener(listener);
       //end button creation
       
       slider1=new JSlider(JSlider.VERTICAL,0,50,20);
       slider1.setMajorTickSpacing(10);
       slider1.setMinorTickSpacing(1);
       slider1.setPaintTicks(true);
       slider1.setPaintLabels(true);
       slider1.addChangeListener(new SliderListener());
       
       slider2=new JSlider(JSlider.VERTICAL,0,50,20);
       slider2.setMajorTickSpacing(10);
       slider2.setMinorTickSpacing(1);
       slider2.setPaintTicks(true);
       slider2.setPaintLabels(true);
       slider2.addChangeListener(new SliderListener());
       
       
       //panel creation
       panel2=new JPanel();
       panel3=new JPanel();
       panel4=new JPanel();
       panel5=new JPanel();
       panel6=new JPanel();
       panel7=new JPanel();
       panel10=new JPanel();
       panel11=new JPanel();
       
       label1=new JLabel("Red Ball Delay");
       label2=new JLabel("Blue Ball Delay");
       
       //panel for red buttons
       panel2.setLayout(new GridLayout(5,1));
       panel2.add(upR);
       panel2.add(downR);
       panel2.add(leftR);
       panel2.add(rightR);
       panel2.add(stopR);
       
       //for blue buttons
       panel3.setLayout(new GridLayout(5,1));
       panel3.add(upB);
       panel3.add(downB);
       panel3.add(leftB);
       panel3.add(rightB);
       panel3.add(stopB);
       
       //for red slider and label
       panel10.setLayout(new BorderLayout());
       panel10.add(label1,BorderLayout.NORTH);
       panel10.add(slider1,BorderLayout.CENTER);
       
       //for blue slider and label
       panel11.setLayout(new BorderLayout());
       panel11.add(label2,BorderLayout.NORTH);
       panel11.add(slider2,BorderLayout.CENTER);
     
       //Blue control center
       panel4.setLayout(new GridLayout(1,2));
       panel4.add(panel2);
       panel4.add(panel10);
       
       //Red control center
       panel5.setLayout(new GridLayout(1,2));
       panel5.add(panel3);
       panel5.add(panel11);
       
       //Complete control center
       panel6.setLayout(new GridLayout(2,1));
       panel6.add(panel4);
       panel6.add(panel5);
       
       //for ball panels.
       panel7.setLayout(new GridLayout(2,1));
       panel7.add(ball1);
       panel7.add(ball2);
       
       //overall layout
       setLayout(new BorderLayout());
       add(panel6,BorderLayout.WEST);
       add(panel7,BorderLayout.CENTER);
       
       //set preferred size of this panel
       setPreferredSize(new Dimension(width,height));
    }


  private class ButtonListener implements ActionListener//Listens to buttons
   {
       public void actionPerformed(ActionEvent event)
        {
            Object action = event.getSource();
            if(action==upR)
            {
            	ball1.up();
            }
            if(action==downR)
            {
            	ball1.down();
            }
            if(action==leftR)
            {
            	ball1.left();
            }
            if(action==rightR)
            {
            	ball1.right();
            }
            if(action==stopR)
            {
            	ball1.suspend();
            }
            if(action==upB)
            {
            	ball2.up();
            }
            if(action==downB)
            {
            	ball2.down();
            }
            if(action==leftB)
            {
            	ball2.left();
            }
            if(action==rightB)
            {
            	ball2.right();
            }
            if(action==stopB)
            {
            	ball2.suspend();
            }
         }
     } //end of ButtonListener

  //SliderListener listens to the slider.
   private class SliderListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent event)
         {
            int delay=((JSlider)event.getSource()).getValue();//extracts selected value
            if(((JSlider)event.getSource()).equals(slider1))//sets delay for appropriate ball
            	ball1.setDelay(delay);
            else
            	ball2.setDelay(delay);
         }

     } //end of SliderListener

} //end of ControlPanel
