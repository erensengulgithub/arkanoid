import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LevelMenu{
	
	public LevelMenu() {
		JFrame LevelSelection = new JFrame();
		JButton lvl1 = new JButton("Level 1");
		JButton lvl2 = new JButton("Level 2");
		JButton lvl3 = new JButton("Level 3");
		
		ImageIcon backgroundImage = new ImageIcon("background.jpg");
		JLabel label = new JLabel();
		backgroundImage = new ImageIcon("background.jpg");
		
		label = new JLabel(backgroundImage);
		label.setSize(490, 800);
		
		lvl1.setBounds(160, 170, 170, 100);
		lvl2.setBounds(160, 320, 170, 100);
		lvl3.setBounds(160, 470, 170, 100);
		
		
		LevelSelection.add(lvl1);
		LevelSelection.add(lvl2);
		LevelSelection.add(lvl3);
		LevelSelection.add(label);
		
		//Button Functionallity
		lvl1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Level1 lvl1=new Level1();
				lvl1.createGameplay();
				LevelSelection.dispose();
			}
		});
		
		lvl2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Level2 lvl2=new Level2();
				lvl2.createGameplay();
				LevelSelection.dispose();	
			}
		});
		
		lvl3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Level3 lvl3=new Level3();
				lvl3.createGameplay();
				LevelSelection.dispose();	
			}
		});
		
		
		
		LevelSelection.setBounds(700, 150, 500, 800);
		LevelSelection.setLayout(null);
		LevelSelection.setVisible(true);
		LevelSelection.setResizable(false);
		LevelSelection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
