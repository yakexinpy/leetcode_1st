/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
            return 0;
            
        int max = 0;
        HashMap<Double, Integer> hashmap = new HashMap<Double, Integer>();
        for(int i = 0; i < points.length; i++){
            hashmap.clear();
            Point p = points[i];
            int len = 0;
            double slope = 0;
            int duplicate = 1;
            for(int j = 0; j < points.length; j++){
                if(i == j)
                    continue;
                if(p.x == points[j].x && p.y == points[j].y){
                    duplicate++;
                    continue;
                }
                else if(p.x == points[j].x)
                    slope = Integer.MAX_VALUE;
                else{
                    slope = 1.0 * (p.y - points[j].y) / (p.x - points[j].x);
                }
                hashmap.put(slope, hashmap.containsKey(slope)? hashmap.get(slope) + 1 : 1);
            }
            if(hashmap.size() == 0)
                max = duplicate;
            for(double key : hashmap.keySet()){
                max = Math.max(max, duplicate + hashmap.get(key));
            }
        }
        return max;
    }
}
