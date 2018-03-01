package fb.glassdoor;

import java.awt.Point;
import java.util.HashMap;

public class MaxPointsLine {
	
    public int maxPoints(Point[] points) {
        if(points.length <= 1) return points.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
            int vertical = 0, same = 1, currMax = 0;
            for(int j = i + 1; j < points.length; j++){
                // 统计相同的点
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same++;
                    continue;
                }
                if(points[i].x == points[j].x){
                    vertical++;
                    continue;
                }
                double slope = ((double)points[j].y - (double)points[i].y) / ((double)points[j].x - (double)points[i].x);

                if(slope * slope == 0) slope = 0;
                lines.put(slope, lines.containsKey(slope) ? lines.get(slope) + 1 : 1);
                currMax = Math.max(currMax, lines.get(slope)); 
            }
            //  The maximum number of points on the line passing through this point, we choose the larger of the infinite and normal slopes, and add the same number of points
            currMax = Math.max(vertical, currMax) + same;
            max = Math.max(currMax, max);
        }
        return max;
    }
}
	
