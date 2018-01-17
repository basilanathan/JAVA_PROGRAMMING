package algosJava;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Implement the "paint fill" function that one might see on many 
 * image editing programs. That is given a screen (represented by
 * a 2-D array of colors), a point, and a new color, fill the 
 * surrounding area until the color changes the original color.
 * 
 * </br>
 * 
 * DFS on a graph. At each pixel, we are searching outwards to each surrounding pixel. we stop
 * once we've fully traversed all the surrounding pixels of this color
 *
 */

public class PaintFill {
	
	/* Values of possible colors */
	public enum Color { While, Black, Red, Yello, Green, Blue}
	
	//	 * Method to paint fill the screen with new color 
	public static boolean paintFill(Color[][] screen, int r, int c, Color color) {
		/* If the point to start with is already of same color, return false */
		if (screen[r][c] == color) {
			return false;
		}
		/* Else paint the screen */
		return paintFill(screen, r, c, screen[r][c], color);
	}
	
	//Method to paint the screen with new color
	private static boolean paintFill(Color[][] screen, int r, int c, Color oldColor, Color newColor) {
		/* If we have reached out of the screen, stop */
		if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
			return false;
		}
		/* Check if the point has old color, if yes, start painting */
		if (screen[r][c] == oldColor) {
			/* Paint the point with new color */
			screen[r][c] = newColor;
			/* Paint Up */
			paintFill(screen, r - 1, c, oldColor, newColor);
			/* Paint Down */
			paintFill(screen, r + 1, c, oldColor, newColor);
			/* Paint Left */
			paintFill(screen, r, c - 1, oldColor, newColor);
			/* Paint Right */
			paintFill(screen, r, c + 1, oldColor, newColor);
		}
		return true;
	}

}
