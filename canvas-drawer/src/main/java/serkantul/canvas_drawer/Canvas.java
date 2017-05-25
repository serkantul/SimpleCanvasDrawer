/**
 * 
 */
package serkantul.canvas_drawer;

import java.util.BitSet;

/**
 * @author serkantul A Canvas component represents a blank rectangular area of
 *         the screen onto which the application can draw or from which the
 *         application can trap input events from the user.
 */

public class Canvas {

	Area area;

	public Canvas(int width, int height) {
		area = new Area(0, 0, width, height);
	}

	public void addShape(Shape shape) {
		shape.draw(area);
	}

	public void paint() {
		area.paint();
	}
}
