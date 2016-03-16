package application;

import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;



@SuppressWarnings("serial")
public class timecounter extends JFrame {

	JLabel promptLabel, timerLabel;
	int counter;
	JTextField m;
	JButton btn;
	Timer timer;
	
	public timecounter(){
		setLayout (new GridLayout(2,2,5,5));
		promptLabel = new JLabel ("Enter time:", SwingConstants.CENTER);
		add(promptLabel);
		
	
		
		m= new JTextField(2);
		add(m);
		
		
		
	
	btn = new JButton("Start timer");
	add(btn);
	
	timerLabel = new JLabel("", SwingConstants.CENTER);
	add(timerLabel);
	
	
	event e = new event();
	btn.addActionListener(e);
		
	}
	
	public class event implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e){
			int count = (int)(Double.parseDouble(m.getText()));
			
			
			timerLabel.setText("Time left: " + count +"min");
			
			
			TimeClass mm = new TimeClass(count);
			timer = new Timer(60000, (ActionListener)mm);
			
			timer.start();
			
		
		}
	}
	
	public  class TimeClass implements ActionListener {
		int counter;
		
		public TimeClass(int counter){
			this.counter = counter;
			
		}
		public void actionPerformed(ActionEvent tc){
			counter--;
			
			if(counter>=1  ){
				timerLabel.setText("Time left:" + counter+ "min" );
			
			
					}else{
			      timer.stop();
				
				timerLabel.setText("Time is up!");
				Toolkit.getDefaultToolkit().beep();
				
			}
			
		}
		
	}
	
	public static void main(String args[]){
		
		timecounter gui = new timecounter();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(250, 100);
		gui.setTitle("Timer Program");
		gui.setVisible(true);
		
		
		
	}
	
	}

 
 
 
 
