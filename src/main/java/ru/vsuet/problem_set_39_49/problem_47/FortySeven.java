package ru.vsuet.problem_set_39_49.problem_47;

import java.util.ArrayList;
import java.util.List;

public class FortySeven {
    public static List<Integer> snail(int[][] array) {
        List<Integer> result = new ArrayList<>();
        int topRow = 0, bottomRow = array.length - 1;
        int leftCol = 0, rightCol = array[0].length - 1;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            // Вывод верхней строки
            for (int col = leftCol; col <= rightCol; col++) {
                result.add(array[topRow][col]);
            }
            topRow++;

            // Вывод правого столбца
            for (int row = topRow; row <= bottomRow; row++) {
                result.add(array[row][rightCol]);
            }
            rightCol--;

            // Вывод нижней строки
            if (topRow <= bottomRow) {
                for (int col = rightCol; col >= leftCol; col--) {
                    result.add(array[bottomRow][col]);
                }
                bottomRow--;
            }

            // Вывод левого столбца
            if (leftCol <= rightCol) {
                for (int row = bottomRow; row >= topRow; row--) {
                    result.add(array[row][leftCol]);
                }
                leftCol++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result1 = snail(array1);
        System.out.println(result1);  // Вывод: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] array2 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<Integer> result2 = snail(array2);
        System.out.println(result2);  // Вывод: [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
