/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class NumberOfAirplanesInTheSky {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        List<Wrapper> planes = new ArrayList<Wrapper>();
        for (Interval interval: airplanes) {
            planes.add(new Wrapper(interval.start, 1));
            planes.add(new Wrapper(interval.end, 0));
        }
        Collections.sort(planes, new Comparator<Wrapper>() {
           @Override
           public int compare(Wrapper w1, Wrapper w2) {
               if (w1.time == w2.time) {
                   return w1.flag - w2.flag;
               }
               return w1.time - w2.time;
           }
        });
        int max = 0;
        int cur = 0;
        for (Wrapper w: planes) {
            if (w.flag == 1) {
                cur += 1;
            } else {
                cur -= 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
    
    private class Wrapper {
        public int time;
        public int flag;
        
        public Wrapper(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}

