import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyCircle implements DrawingObject{
	
	int originX, originY, sizeX, sizeY;
	int lastX, lastY;
    Rectangle bounds = new Rectangle();
    
    public MyCircle(){
    	sizeX = sizeY = originX = originY = 0;
        setBounds( bounds );
    }
    
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2d = (Graphics2D)g;
	        
	     g2d.setColor( Color.BLACK );
	     g2d.drawOval( originX, originY, sizeX, sizeY );
	        
	     System.out.println( "Redrawing circle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}
	
	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
	}

	@Override
	public void drag(Point p) {
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        setBounds( bounds );
	}

	@Override
	public void move(Point p) {
        originX = p.x;
        originY = p.y;
        setBounds( bounds );
	}

	@Override
	public void setBounds(Rectangle b) {
		 b.setBounds( originX, originY, sizeX, sizeY );
	}

	@Override
	public boolean contains(Point p) {
		return bounds.contains(p);
	}

}