import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class MyArc implements DrawingObject{

	 // critical vars for a rectangle
    int sizeX, sizeY, originX, originY, width, length;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
	
    MyArc(){
    	sizeX = sizeY = originX = originY = width = length = 0;
    	setBounds( bounds );
    }
	
	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void start(Point p) {
		
	}

	@Override
	public void drag(Point p) {

		
	}

	@Override
	public void move(Point p) {

		
	}

	@Override
	public void setBounds(Rectangle b) {

		
	}

	@Override
	public boolean contains(Point p) {

		return false;
	}

}