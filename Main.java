import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) throws Exception {
		JFrame frame=new JFrame();
		FileReader reader = new FileReader("Scores.txt");
		
		JButton nG = new JButton("New Game");
		JButton opt = new JButton("Options");
		JButton scr = new JButton("Scores");
		JButton help = new JButton("Help");
		JButton abt = new JButton("About");
		JButton exit = new JButton("Exit");
		
		JTextField helpText = new JTextField("You have to break all bricks to pass levels", 10);
		JTextField aboutText = new JTextField("Eren Þengül 20200702059 eren.sengul@std.yeditepe.edu.tr", 10);
		
		ImageIcon backgroundImage = new ImageIcon("background.jpg");
		JLabel label = new JLabel();
		backgroundImage = new ImageIcon("background.jpg");
		
		label = new JLabel(backgroundImage);
		label.setSize(490, 800);

		nG.setBounds(160, 70, 160, 80);
		opt.setBounds(160, 170, 160, 80);
		scr.setBounds(160, 270, 160, 80);
		help.setBounds(160, 370, 160, 80);
		abt.setBounds(160, 470, 160, 80);
		exit.setBounds(160, 570, 160, 80);
		
		frame.add(nG);
		frame.add(opt);
		frame.add(scr);
		frame.add(help);
		frame.add(abt);
		frame.add(exit);
		frame.add(label);
		
		nG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new LevelMenu();
				frame.dispose();
				
			}
		});
		
		opt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		
		scr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int ch = 0;
			    
			    String tmp = "";
			    do {
			      try {
					ch = reader.read();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			      if (ch != -1) 
			        tmp += (char)ch;
			      System.out.print((char)ch);
			    } while (ch != -1);
			    try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			  }
		});
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, helpText.getText(),null ,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		abt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, aboutText.getText(),null ,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
        frame.setBounds(700, 150, 500, 800);
		frame.setTitle("Arkanoid");		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}