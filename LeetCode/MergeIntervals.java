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
        List<Interval> res = new LinkedList<Interval>();
        if (intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (overlap(intervals.get(i), intervals.get(i + 1))) {
                Interval cur = mergeTwoInterval(intervals.get(i), intervals.get(i + 1));
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i, cur);
                i--;
            } else {
                res.add(intervals.get(i));
            }
        }
        res.add(intervals.get(intervals.size() - 1));
        return res;
    }
    
    public boolean overlap(Interval a, Interval b) {
        if (a.start > b.end || b.start > a.end) {
            return false;
        } else {
            return true;
        }
    }
    
    public Interval mergeTwoInterval(Interval a, Interval b) {
        return new Interval(a.start, Math.max(a.end, b.end));
    }
}
