//Lecture 1
//Assignment 12
//Description: The ball panel draws a ball that moves left to right or up and down, 
//that bounces when reaching the ends of the panel.
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class BallPanel extends JPanel
{
	private int x;
	private int y;
	private Color ballColor;
	private Color backColor;
	private Timer timer;
	private int delay;
	private int stepX;
	private int stepY;
	private final int CIRCLE_DIAMETER=20;
	
	public BallPanel(int num, int num2, Color color1, Color color2)//Constructor
	{
		x=num;
		y=num2;
		ballColor=color1;
		backColor=color2;
		delay=20;
		stepX=3;
		stepY=0;
		timer=new Timer(delay, new MovingBallListener());
		timer.start();
	}
	
	public void up()//ball goes up (y goes down)
	{
		stepY=-3;
		stepX=0;
		timer.start();
	}
	
	public void down()//ball goes down (y goes up)
	{
		stepY=3;
		stepX=0;
		timer.start();
	}
	
	public void left()//ball goes left, so x goes down
	{
		stepX=-3;
		stepY=0;
		timer.start();
	}
	
	public void right()//ball goes right, so x goes up
	{
		stepX=3;
		stepY=0;
		timer.start();
	}
	
	public void suspend()//timer stops sending events to listener
	{
		timer.stop();
	}
	
	public void setDelay(int delayNum)//calls timer's setDelay method
	{
		timer.setDelay(delayNum);
	}
	
	public void paintComponent(Graphics page)//where everything is painted
	{
		super.paintComponent(page);
		setBackground(backColor);
		page.setColor(ballColor);
		page.fillOval(x,y,CIRCLE_DIAMETER,CIRCLE_DIAMETER);
	}
	
	private class MovingBallListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			x=x+stepX;
			y=y+stepY;
			if (x>getSize().getWidth()-CIRCLE_DIAMETER&&stepY==0)//hits right wall
			{
				left();
			}
			
			if (x<0&&stepY==0)//hits left wall
			{
				right();
			}
			
			if (y<0&&stepX==0)//hits top
			{
				down();
			}
			
			if (y>getSize().getHeight()-CIRCLE_DIAMETER&&stepX==0)//hits bottom
			{
				up();
			}
			repaint();
			
		}
		
	}
}

