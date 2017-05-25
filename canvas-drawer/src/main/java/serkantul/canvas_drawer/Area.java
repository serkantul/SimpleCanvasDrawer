/**
 * 
 */
package serkantul.canvas_drawer;

import java.util.BitSet;

/**
 * @author serkantul
 *
 */
public class Area {

	/**
	 * 
	 */
	// Any 2D array can be implemented using 1D array. Take an example of 2D
	// array of m rows and n columns. In that case, size of equivalent 1D array
	// would be m*n. 2D[i, j] would be equivalent of 1D[i*n + j]. Here i is row
	// index and j is column index.
	private BitSet areaBits;
	private int width, height;

	public Area(int x1, int y1, int x2, int y2) {
		this.width = Math.abs(x2 - x1) + 1;
		this.height = Math.abs(y2 - y1) + 1; 
		int size = width * height;
		areaBits = new BitSet(size);
	}

	public void putPixel(int x, int y) {
		areaBits.set(height * y + x);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void paint() {
		for(int i = 0; i < areaBits.length(); i++) {
			if (i % width == 0) {
				System.out.println();
			}
			if (areaBits.get(i)) {
				System.out.print("x");
			} else {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	

}
