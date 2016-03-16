package application;

import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
	JTextField t,m,s;
	JButton btn;
	Timer timer;
	
	public timecounter(){
		setLayout (new GridLayout(2,2,5,5));
		promptLabel = new JLabel ("Enter time:", SwingConstants.CENTER);
		add(promptLabel);
		
		t= new JTextField(2);
		add(t);
		

		m= new JTextField(2);
		add(m);
	

		s= new JTextField(2);
		add(s);
		
	btn = new JButton("Start timer");
	add(btn);
	
	timerLabel = new JLabel("", SwingConstants.CENTER);
	add(timerLabel);
	
	
	event e = new event();
	btn.addActionListener(e);
		
	}
	
	public class event implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e){
			int count = (int)(Double.parseDouble(t.getText()));
			int count1 = (int)(Double.parseDouble(m.getText()));
		int count2 = (int)(Double.parseDouble(s.getText()));
			
			
			timerLabel.setText("Time left: " + count +"h"+ count1 +"min"+ count2 +"sec");
			TimeClass t = new TimeClass(count);
			timer = new Timer(600000, (ActionListener) t);
			
			TimeClass m = new TimeClass(count1);
			timer = new Timer(60000, (ActionListener) m);
			
			TimeClass s = new TimeClass(count2);
			timer = new Timer(1000, (ActionListener) s);
			
			timer.start();
			
			
			
			

		
//			timerLabel.setText("Time left: " + count2 +"sec");
//			TimeClass s = new TimeClass(count2);
//			timer = new Timer(1000, (ActionListener) s);
//			timer.start();
//	
//			
			
			

		}
	}
	
	public  class TimeClass implements ActionListener {
		int counter;
		
		public TimeClass(int counter){
			this.counter = counter;
			
		}
		public void actionPerformed(ActionEvent tc){
			counter--;
			
			if(counter>=1){
				timerLabel.setText("Time left:" + counter + "sec"+ counter+ "h"+ counter+ "min");
			
				

		//	(counter>=1){
				//timerLabel.setText("Time left:" + counter+ "min");
//				
//				}else if(counter>=1){
//					timerLabel.setText("Time left:" + counter+ "sec");
//					
					}else{
				}
				
				
				
				
				
				
				
				
				
			// timer.stop();
			//	timerLabel.setText("Time is up!");
			//	Toolkit.getDefaultToolkit().beep();
				
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


