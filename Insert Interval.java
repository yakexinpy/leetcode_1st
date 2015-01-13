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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if(intervals == null){
            ret.add(newInterval);
            return ret;
        }
        
        Interval temp = null;
        int i = 0;
        for(; i < intervals.size(); i++){
            temp = intervals.get(i);
            if(temp.start <= newInterval.start && temp.end >= newInterval.end){
                newInterval = temp;
            }
            else if(temp.start <= newInterval.start && temp.end >= newInterval.start){
                newInterval.start = temp.start;
                if(temp.end > newInterval.end)
                    newInterval.end = temp.end;
            }
            else if(temp.start <= newInterval.end && temp.end >= newInterval.end){
                newInterval.end = temp.end;
            }
            else if(temp.start > newInterval.end){
                ret.add(newInterval);
                break;
            }
            else if(temp.start >= newInterval.start && temp.end <= newInterval.end){
                continue;
            }
            else{
                ret.add(temp);
            }
        }
        if(i >= intervals.size())
            ret.add(newInterval);
        
        while(i < intervals.size()){
            ret.add(intervals.get(i++));
        }
        return ret;
    }
}
