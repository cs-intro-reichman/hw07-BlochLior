/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.setTitle("Sierpinski 2025");
		StdDraw.setCanvasSize();
		StdDraw.setScale(-0.1, 1.1);
		double x1 = 0;
		double x2 = 1;
		double x3 = 0.5;
		double y1 = 0;
		double y2 = 0;
		double y3 = 1;
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);
		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) return;
		double m12x = (x1 + x2) / 2.0;
		double m23x = (x2 + x3) / 2.0;
		double m31x = (x3 + x1) / 2.0;
		double m12y = (y1 + y2) / 2.0;
		double m23y = (y2 + y3) / 2.0;
		double m31y = (y3 + y1) / 2.0;
		
		StdDraw.line(m12x, m12y, m23x, m23y);
		StdDraw.line(m23x, m23y, m31x, m31y);
		StdDraw.line(m31x, m31y, m12x, m12y);
		sierpinski(n - 1, x1, m31x, m12x, y1, m31y, m12y);
		sierpinski(n - 1, x2, m12x, m23x, y2, m12y, m23y);
		sierpinski(n - 1, x3, m31x, m23x, y3, m31y, m23y);
	}
	
}
