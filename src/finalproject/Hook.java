package finalproject;

import javax.swing.JLabel;

public class Hook extends JLabel {
	private int X,Y;
	private int width , height;
	/*public Hook(int x,int y,int width,int height)
	{
		this.X = x;
		this.Y = y;
		this.width = width;
		this.height = height;
	}*/
	public int  getX()
	{
		return X;
	}
	public  int  getY() {
		return Y;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	
}
