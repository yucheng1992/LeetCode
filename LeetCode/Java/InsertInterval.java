/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        return merge(intervals, newInterval);
    }
    public List<Interval> merge(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i + 1).start) {
                intervals.add(i + 1, newInterval);
                break;
            }
            if (i == intervals.size() - 2) {
                if (newInterval.start >= intervals.get(intervals.size() - 1).start) {
                    intervals.add(intervals.size(), newInterval);
                } else {
                    intervals.add(0, newInterval);
                }
                break;
            }
        }
        if (intervals.size() == 1) {
            if (newInterval.start < intervals.get(0).start) {
                intervals.add(0, newInterval);
            } else {
                intervals.add(1, newInterval);
            }
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (canMerge(intervals.get(i), intervals.get(i + 1))) {
                Interval cur = mergeIntervals(intervals.get(i), intervals.get(i + 1));
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
    
    public boolean canMerge(Interval a, Interval b) {
        return !(a.end < b.start || b.end < a.start); 
    }
    
    public Interval mergeIntervals(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
}
