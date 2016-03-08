/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
           @Override
           public int compare(Interval s, Interval t) {
               return Integer.compare(s.start, t.start);
           }
        });
        Set<Integer> rooms = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (rooms.contains(i)) {
                continue;
            }
            rooms.add(i);
            int preEnd = intervals[i].end;
            count += 1;
            for (int j = i + 1; j < intervals.length; j++) {
                if (!rooms.contains(j) && intervals[j].start >= preEnd) {
                    rooms.add(j);
                    preEnd = intervals[j].end;
                }
            }
        }
        return count;
    }
}
