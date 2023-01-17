import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class Level3 extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	private int score = 0;
	private int totalBricks = 27;
	private Timer timer;
	private int delay=8;
	private int paddleX = 310;
	private int ballposX = ThreadLocalRandom.current().nextInt(100, 500);
	private int ballposY = ThreadLocalRandom.current().nextInt(300, 350);
	private int ballXdir =  ThreadLocalRandom.current().nextInt(-2, 2);
	private int ballYdir = -3;
	private int lives=3;
	private JLabel usernameLabel;
	private JTextField usernameText;
	private JButton save;
	
	private BrickGenerator3 map;
	
	
	public void createGameplay() {
		JFrame frame = new JFrame();
		Level3 lvl3 = new Level3();
		frame.add(lvl3);
		frame.setBounds(600, 150, 710, 600);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Level3(){		
		map = new BrickGenerator3(3, 9);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}

	public void paint(Graphics g){    		
		g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
		
		map.draw((Graphics2D) g);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
			
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("Score: "+score, 10,30);
		
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("Level 3", 290,30);
		
		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD, 25));
		g.drawString("Lives: "+lives, 590,30);
		
		g.setColor(Color.green);
		g.fillRect(paddleX, 520, 100, 8);
		
		g.setColor(Color.black);
		g.fillOval(ballposX, ballposY, 20, 20);
	
		if(totalBricks <= 0){
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("You Won", 260,300);
             
			g.setColor(Color.RED);
			g.setFont(new Font("serif",Font.BOLD, 20));           
			g.drawString("Press (Enter) to Restart", 230,350);  
             
			play = false;
			ballXdir = 0;
	     	ballYdir = 0;
	     	g.setColor(Color.RED);
	     	g.setFont(new Font("serif",Font.BOLD, 30));
	     	g.drawString("Game Over, Scores: "+score, 190,300);
	     		
	     	g.setColor(Color.RED);
	     	g.setFont(new Font("serif",Font.BOLD, 20));           
	     	g.drawString("Press (Enter) to Restart", 230,350); 
	            
	     	JFrame usernameFrame = new JFrame("Save your score");
	     	usernameLabel = new JLabel("Username: ");
	     	usernameText = new JTextField();
	     	save = new JButton("Save");
	     	usernameLabel.setBounds(10,20,100,30);
	     	usernameText.setBounds(110,20,100,30);
	     	save.setBounds(220, 20, 100, 30);
	     	save.addActionListener(new ActionListener() {
	     		public void actionPerformed(ActionEvent e) {
	     			try {
	     				final FileWriter writer = new FileWriter("Scores.txt",true);
	     				String tmp = usernameText.getText()+" "+score+" "+ "Level3\n";
	     				writer.write(tmp);
	     				writer.close();
	     			} catch (IOException e1) {  	
	     				e1. printStackTrace();
	     			}
	    				}
	    			});
	     	usernameFrame.add(usernameLabel);
	     	usernameFrame.add(usernameText);
	     	usernameFrame.add(save);
	     	usernameFrame.setSize(400,100);
	     	usernameFrame.setLocation(800, 250);
	    	usernameFrame.setLayout(null);
	    	usernameFrame.setVisible(true);
		}
		
		if(ballposY > 570){
			if(lives ==1) {
				play = false;
				ballXdir = 0;
	     		ballYdir = 0;
	            g.setColor(Color.RED);
	            g.setFont(new Font("serif",Font.BOLD, 30));
	            g.drawString("Game Over, Scores: "+score, 190,300);
	             
	            g.setColor(Color.RED);
	            g.setFont(new Font("serif",Font.BOLD, 20));           
	            g.drawString("Press (Enter) to Restart", 230,350); 
	            
	            JFrame usernameFrame = new JFrame("Save your score");
	            usernameLabel = new JLabel("Username: ");
	            usernameText = new JTextField();
	            save = new JButton("Save");
	            usernameLabel.setBounds(10,20,100,30);
	            usernameText.setBounds(110,20,100,30);
	            save.setBounds(220, 20, 100, 30);
	            save.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent e) {
	    				try {
	    				      final FileWriter writer = new FileWriter("Scores.txt",true);
	    				      String tmp = usernameText.getText()+" "+score+" "+ "Level3\n";
	    				      writer.write(tmp);
	    				      writer.close();
	    				    } catch (IOException e1) {  	
	    				      e1. printStackTrace();
	    				    }
	    			}
	    		});
	            usernameFrame.add(usernameLabel);
	            usernameFrame.add(usernameText);
	            usernameFrame.add(save);
	            usernameFrame.setSize(400,100);
	            usernameFrame.setLocation(800, 250);
	    		usernameFrame.setLayout(null);
	    		usernameFrame.setVisible(true);   
			}
			else {
				play = true;
				ballposX = ThreadLocalRandom.current().nextInt(100, 500);
				ballposY = ThreadLocalRandom.current().nextInt(300, 350);
				ballXdir = ThreadLocalRandom.current().nextInt(-2, 2);
				ballYdir = -3;
				lives--;  
			}      
        }
		g.dispose();
	}	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){        
			if(paddleX >= 600)
			{
				paddleX = 600;
			}
			else
			{
				moveRight();
			}
        }
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT){          
			if(paddleX < 10)
			{
				paddleX = 10;
			}
			else
			{
				moveLeft();
			}
        }		
		if (e.getKeyCode() == KeyEvent.VK_ENTER){          
			if(!play)
			{
				play = true;
				ballposX = ThreadLocalRandom.current().nextInt(100, 500);
				ballposY = ThreadLocalRandom.current().nextInt(300, 350);
				ballXdir = ThreadLocalRandom.current().nextInt(-2, 2);
				ballYdir = -3;
				paddleX = 310;
				score = 0;
				totalBricks = 27;
				map = new BrickGenerator3(3, 9);
				lives=3;
				
				repaint();
			}
        }		
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public void moveRight(){
		play = true;
		paddleX+=20;	
	}
	
	public void moveLeft(){
		play = true;
		paddleX-=20;	 	
	}
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play){			
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(paddleX, 520, 30, 8))){
				ballYdir = -ballYdir;
				ballXdir = -2;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(paddleX + 70, 520, 30, 8))){
				ballYdir = -ballYdir;
				ballXdir = ballXdir + 1;
			}
			else if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(paddleX + 30, 520, 40, 8))){
				ballYdir = -ballYdir;
			}
					
			A: for(int i = 0; i<map.map.length; i++){
				for(int j =0; j<map.map[0].length; j++){				
					if(map.map[i][j] != null){
						int brickX = j * map.brickWidth + 80;
						int brickY = i * map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);					
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)){	
							if(map.map[i][j].health == 0) {
								if(i==0) {
									map.setBrickValue(i,j);
									score+=20;	
									totalBricks--;
								}
								else if(i == 1) {
									map.setBrickValue(i,j);
									score+=10;	
									totalBricks--;
								}
								else {
									map.setBrickValue(i,j);
									score+=5;	
									totalBricks--;
								}
							}
							else {
								map.map[i][j].health--;
							}
							
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width)	{
								ballXdir = -ballXdir;
							}
							else{
								ballYdir = -ballYdir;				
							}
							break A;
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if(ballposX < 0){
				ballXdir = -ballXdir;
			}
			if(ballposY < 0){
				ballYdir = -ballYdir;
			}
			if(ballposX > 670){
				ballXdir = -ballXdir;
			}		
			repaint();		
		}
	}
}