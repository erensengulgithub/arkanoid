import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BrickGenerator2{
	public Brick map[][];
	public int brickWidth;
	public int brickHeight;
	
	public BrickGenerator2 (int row, int col){
		map = new Brick[row][col];		
		for(int i = 0; i<map.length; i++){
			for(int j =0; j<map[0].length; j++){
				if(i==1) {
					map[i][j] = new Brick(1);
				}
				else
					map[i][j] = new Brick(0);
			}			
		}
		brickWidth = 540/col;
		brickHeight = 150/row;
	}	
	
	public void draw(Graphics2D g){
		for(int i = 0; i<map.length; i++){
			for(int j =0; j<map[0].length; j++){
				if(map[i][j] != null){
					if(i==1) {
						g.setColor(Color.orange);
						g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(10));
						g.setColor(Color.white);
						g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);	
					}
					else {
						g.setColor(Color.red);
						g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
						
						g.setStroke(new BasicStroke(10));
						g.setColor(Color.white);
						g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);	
					}
						
				}
			}
		}
	}
	
	public void setBrickValue(int row, int col){
		map[row][col] = null;
	}
}