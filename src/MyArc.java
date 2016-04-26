import java.awt.*;
import java.io.Serializable;

// super spiffy arc
public class MyArc implements DrawingObject, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// critical vars for a rectangle
    int sizeX, sizeY, originX, originY, startAngle, arcAngle;
    // future use
    int lastX, lastY;
    // bounding box (needed for move)
    Rectangle bounds = new Rectangle();
	
    MyArc(){
    	sizeX = sizeY = originX = originY = startAngle = arcAngle = 0;
    	setBounds( bounds );
    }
    
    MyArc( int oX, int oY, int sX, int sY){
    	sizeX = sX;
        sizeY = sY;
        originX = oX;
        originY = oY;
        setBounds( bounds );
        
        System.out.println( "Made arc: @" + oX + ", " + oY + "; " + sX + " x " + sY );
    }
	
    /**
     * The arc is drawn backwards from the end point (where the user clicks) to the start point (the point at the edge of the drawing pane
     * that is horizontal to the end point)
     */
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.draw(bounds);
        g2d.setColor( Color.BLACK );
		g.drawArc( sizeX, sizeY, originX, originY * 2, startAngle, arcAngle ); // draw arc!!
		
		System.out.println( "Redrawing arc @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
	}

	@Override
	public void start(Point p) {
		originX = p.x;
        originY = p.y;
        lastX = p.x;
        lastY = p.y;
        startAngle = 0;
        arcAngle = 180;
	}

	@Override
	public void drag(Point p) {
		sizeX = p.x - originX;
        sizeY = p.y - originY;
        //originX = p.x;
        //originY = p.y;
        setBounds( bounds );
        
        // note to Isabelle...just ignore...
        // for cool dragging stuff, make origin start point and calculate angle to point from start
		
	}

	@Override
	public void move(Point p) {
		sizeX = sizeX - (originX - p.x);
		sizeY = sizeY - (originY - p.y);
		sizeX = p.x;
	    sizeY = p.y;
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

	@Override
	public void getColor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color c) {
		// TODO Auto-generated method stub
		
	}

//	public void resizeArc(Point p){
//		lastX = originX - (sizeX - p.x);
//		lastY = originY - (sizeY - p.y);
//		originX = p.x;
//	    originY = p.y;
//	    setBounds( bounds );
//	}
//	
}
