package serkantul.canvas_drawer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.google.common.base.Splitter;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		printHelp();
		Canvas canvas = null;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			try {
				String inputLine = sc.nextLine();
				Iterator<String> tokens = Splitter.on(' ').omitEmptyStrings().trimResults().split(inputLine).iterator();
				String type = tokens.next();
				if (type.equalsIgnoreCase("C")) {
					// User creates a new canvas
					int width = Integer.parseInt(tokens.next());
					int height = Integer.parseInt(tokens.next());
					canvas = new Canvas(width, height);
					printHelp();
				} else if (type.equalsIgnoreCase("L")) {
					int x1 = Integer.parseInt(tokens.next());
					int y1 = Integer.parseInt(tokens.next());
					int x2 = Integer.parseInt(tokens.next());
					int y2 = Integer.parseInt(tokens.next());
					if(canvas != null) {
						Line line = new Line(x1, y1, x2, y2);
						canvas.addShape(line);
						canvas.paint();
						printHelp();
					} else {
						printErrorMessage();
					}

				} else if (type.equalsIgnoreCase("R")) {
					int x1 = Integer.parseInt(tokens.next());
					int y1 = Integer.parseInt(tokens.next());
					int x2 = Integer.parseInt(tokens.next());
					int y2 = Integer.parseInt(tokens.next());
				} else if (type.equalsIgnoreCase("B")) {
					int x1 = Integer.parseInt(tokens.next());
					int y1 = Integer.parseInt(tokens.next());
					String c = tokens.next();
				} else if (type.equalsIgnoreCase("Q")) {
					break;
				} else {
					printErrorMessage();
				}
			} catch (NoSuchElementException nse) {
				printErrorMessage();
			} catch (NumberFormatException nfe) {
				printErrorMessage();
			}
		}
		sc.close();
	}

	private static void printErrorMessage() {
		System.out.println("Error");
		printHelp();
	}

	public static void printHelp() {
		System.out.print("Please enter your input:");
	}
}
