/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) 
            return intervals;
        
        Comparator<Interval> compare = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start) return i1.end - i2.end;
                else return i1.start - i2.start;
            }
        };
        
        Collections.sort(intervals, compare);
        
        List<Interval> ret = new ArrayList<Interval>();
        ret.add(intervals.get(0));
        
        for(int i = 1; i < intervals.size(); i++){
            if(ret.get(ret.size() - 1).end >= intervals.get(i).start){
                ret.get(ret.size() - 1).end = Math.max(intervals.get(i).end, ret.get(ret.size() - 1).end);
            }
            else
                ret.add(intervals.get(i));
        }
        return ret;
    }
}
