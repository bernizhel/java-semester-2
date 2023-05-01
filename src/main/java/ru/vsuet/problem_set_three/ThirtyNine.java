package ru.vsuet.problem_set_three;

import java.util.Arrays;

public class ThirtyNine {
    public int getNextPermutation(int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c - '0').toArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
        Arrays.sort(digits, i + 1, digits.length);
        int nextPermutation = Integer.parseInt(Arrays.toString(digits)
                .replaceAll("[\\[\\]\\,\\s]", ""));
        return (nextPermutation > num) ? nextPermutation : -1;
    }
}
