package cci.ch8;

//import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import helpers.*;

/**
 * 
 * @author basila
 * 
 * <br> Problem Statement :
 * 
 * Imagine a robot sitting on the upper left corner of the grid with
 * r rows and c columns. The robot can only move into two directions,
 * right and down, but certain cells are "off limit" such that the robot
 * cannot step on them. Design an algorithm to find a path for the robot
 * from the top left to the bottom right.
 * 
 * <br>
 *
 */

public class RobotGrid {
	public static ArrayList<Point> getPath(boolean[][] maze) {
		/* If invalid maze, return null */
		if(maze == null || maze.length == 0) return null;
		
		/* create path */
		ArrayList<Point> path = new ArrayList<>();
		
		/* Find the path, give maze, row, col and path to inner function.
		 * If exists, return that path else return null */
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}
		return null;
	}

	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		/* If it's a invalid row or column or cell is off limit,
		 * return false, because no path exists */
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		
		/* Check if we are standing at origin */
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there is a path from start to here, add my location */
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		return false;
	}
	
	//OPTIMIZED SOLUTION MEMOIZATION
	public static ArrayList<Point> getPathO(boolean[][] maze) {
		/* If invalid maze, return null */
		if (maze == null || maze.length == 0) return null;
		
		/* Define path and failed points. Failed points are the one, 
		 * where no calculation is needed, i.e we have already see them */
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> failedPoints = new HashSet<>();
		
		if (getPathO(maze, maze.length, maze[0].length, path, failedPoints)) {
			return path;
		}
		return null;
	}

	private static boolean getPathO(boolean[][] maze, int row, int col, ArrayList<Point> path,
			HashSet<Point> failedPoints) {
		/* If it's a invalid row or column or cell is off limit,
		 * return false, because no path exists */
		if (row < 0 || col < 0 || !maze[row][col]) {
			return false;
		}
		
		/* Find the current point and check if we have already visited it 
		 * and it is an offset point */
		Point p = new Point(row, col);
		if (failedPoints.contains(p)) {
			return false;
		}
		
		/* Check if we are at origin */
		boolean isAtOrigin = (row == 0) && (col == 0);
		/* If there is a path from start to here, add my location */
		if (isAtOrigin || getPathO(maze, row, col - 1, path, failedPoints) || getPathO(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		/* If not, cache the result */
		failedPoints.add(p);
		return false;
	}
	
	public static class Point {

		/* Variables to hold position of row and column */
		public int row, column;

		/**
		 * Constructor 
		 * 
		 * @param row
		 * @param column
		 */
		public Point (int row, int column) {
			this.row = row;
			this.column = column;
		}

		@Override
		public String toString() {
			return "(" + row + "," + column + ")";
		}

	}
	
	public static void main(String[] args) {
		int size = 6;
		boolean[][] maze = AssortedMethods.randomBooleanMatrix(size, size, 70);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}		
	}
}
