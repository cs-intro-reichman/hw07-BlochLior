/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		//curve(Integer.parseInt(args[0]),
		//	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		// I decided only to draw on the base case,
		// then the erasure isn't required and it works more smoothly
		// since the drawing only happens when reaching base,
		// and as such no additional lines are being drawn that need to be
		// erased. 
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		double x3 = (2 * x1 + x2) / 3.0;
		double y3 = (2 * y1 + y2) / 3.0;
		double x5 = (x1 + 2 * x2) / 3.0;
		double y5 = (y1 + 2 * y2) / 3.0;
		double x4 = (Math.sqrt(3) / 2.0) * (y3 - y5) + 0.5 * (x3 + x5);
		double y4 = (Math.sqrt(3) / 2.0) * (x5 - x3) + 0.5 * (y3 + y5);
		
		// StdDraw.setPenColor(StdDraw.WHITE);
		// StdDraw.line(x3, y3, x5, y5);
		// StdDraw.setPenColor(StdDraw.BLACK);
		// StdDraw.line(x3, y3, x4, y4);
		// StdDraw.line(x4, y4, x5, y5);
		curve(n - 1, x1, y1, x3, y3);
		curve(n - 1, x3, y3, x4, y4);
		curve(n - 1, x4, y4, x5, y5);
		curve(n - 1, x5, y5, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		StdDraw.setCanvasSize(800, 800);
		
		StdDraw.setXscale(-0.1, 1.1);
		StdDraw.setYscale(-0.1, 1.1);

		StdDraw.setPenRadius(0.002);
		
		double x1 = 0.1; 
		double y1 = 0.82; 
		
		double x2 = 0.9; 
		double y2 = 0.82; 
		
		double side = x2 - x1;
		double height = side * Math.sqrt(3) / 2.0;
		
		double x3 = 0.5; 
		double y3 = y1 - height; 

		curve(n, x1, y1, x2, y2); // Curve 1: Top edge (Left to Right)
		curve(n, x2, y2, x3, y3); // Curve 2: Right diagonal (Down)
		curve(n, x3, y3, x1, y1); // Curve 3: Left diagonal (Up)
	}
}
