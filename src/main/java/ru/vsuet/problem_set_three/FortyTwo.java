package ru.vsuet.problem_set_three;

public class FortyTwo {
    public static int countIntervals(int[][] intervals) {
        int count = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int end = intervals[i][1];
            int startNext = intervals[i + 1][0];
            count += startNext - end - 1;
        }
        return count;
    }
}
