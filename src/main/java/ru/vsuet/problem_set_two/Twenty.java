package ru.vsuet.problem_set_two;

public class Twenty {
    public static void main(String[] args) {
        int m = 5; // высота массива
        int n = 4; // ширина массива

        int[][] array = new int[m][n]; // создаем массив

        // заполняем массив
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ring = Math.min(Math.min(i, j), Math.min(m - i - 1, n - j - 1));
                array[i][j] = ring + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
