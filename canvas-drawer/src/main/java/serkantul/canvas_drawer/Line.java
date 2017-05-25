package serkantul.canvas_drawer;

class Line implements Shape {

	private int x1, x2, y1, y2;
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see serkantul.canvas_drawer.Area#draw() Uses DDA alghorithm to draw a
	 * line, see https://www.tutorialspoint.com/computer_graphics/
	 * line_generation_algorithm.htm for details.
	 */
	public void draw(Area area) {
		// NOT her zaman kucuk olan y noktasindan basla
		// Based on the calculated difference, you need to identify
		// the number of steps to put pixel. If dx > dy, then you need more
		// steps in x coordinate; otherwise in y coordinate.
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		int steps;
		if (dx > dy) {
			steps = dx;
		} else {
			steps = dy;
		}

		// Calculate the increment in x coordinate and y coordinate.
		int Xincrement = dx / steps;
		int Yincrement = dy / steps;

		int x = 0, y = 0;
		for (int v = 0; v < steps; v++) {
			area.putPixel(x, y);
			x = x + Xincrement;
			y = y + Yincrement;
		}
	}
}
