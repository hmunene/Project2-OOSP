package project2start;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class MainPanel extends ProductCollection {
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Product Collection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		
		MainFrame panel = new MainFrame();
		frame.getContentPane().add(panel);
		frame.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent w) {
			       panel.doWrite();
			    }
			});
			
			frame.pack();
			frame.setVisible(true);
			//frame.setResizable(resizable);
		}
	}
