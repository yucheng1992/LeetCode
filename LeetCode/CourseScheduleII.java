public class CourseSechduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] preNum = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> set = graph.get(i);
            for (Integer course: set) {
                preNum[course]++;
            }
        }
        int[] res = new int[numCourses];
        int m = 0;
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (preNum[j] == 0) {
                    break;
                }
            }
            if (j == numCourses) {
                res = new int[0];
                return res;
            }
            res[m] = j;
            m++;
            preNum[j] = -1;
            HashSet<Integer> set = graph.get(j);
            for (Integer k: set) {
                preNum[k]--;
            }
        }
        return res;
    }
}
