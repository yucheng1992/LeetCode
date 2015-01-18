/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<Interval>();
        int i = 0;
        if (intervals.size() == 1){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
        @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        while (i < intervals.size()) {
            for (int j=i+1; j<i+2; j++) {
                if (j >= intervals.size()) {
                    merged.add(intervals.get(i));
                } else{
                    if (canMerge(intervals.get(i), intervals.get(j))) {
                        Interval newInterval = mergeIntervals(intervals.get(i), intervals.get(j));
                        intervals.add(i, newInterval);
                        intervals.remove(i+1);
                        intervals.remove(i+1);
                        i--;
                    } else {
                        merged.add(intervals.get(i));
                    }
                }
            }
            i++;
        }
        return merged;
    }
    
    public boolean canMerge(Interval a, Interval b) {
        if (a.end - b.start < 0 || b.end - a.start < 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public Interval mergeIntervals(Interval a, Interval b) {
        Interval target = new Interval();
        if (a.start < b.start) {
            target.start = a.start;
        } else {
            target.start = b.start;
        }
        if (a.end < b.end) {
            target.end = b.end;
        } else {
            target.end = a.end;
        }
        return target;
    }
}
