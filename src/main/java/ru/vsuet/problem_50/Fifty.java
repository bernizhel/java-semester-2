package ru.vsuet.problem_50;

import java.io.*;
import java.util.*;

public class Fifty {
    private static final String HISTORY_FILE = "history.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Введите уравнение (или 'выход' для завершения): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("выход")) {
                running = false;
            } else {
                try {
                    double result = evaluateExpression(input);
                    System.out.println("Результат: " + result);
                    saveToHistory(input, result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }

    private static double evaluateExpression(String expression) {
        expression = expression.replace(" ", ""); // Удаляем пробелы из выражения

        // Вычисляем выражения в скобках
        while (expression.contains("(")) {
            int openingIndex = expression.lastIndexOf("(");
            int closingIndex = expression.indexOf(")", openingIndex);

            if (closingIndex == -1) {
                throw new IllegalArgumentException("Неправильное расположение скобок");
            }

            String subExpression = expression.substring(openingIndex + 1, closingIndex);
            double subResult = evaluateExpression(subExpression);

            expression = expression.substring(0, openingIndex) + subResult + expression.substring(closingIndex + 1);
        }

        // Вычисляем модуль числа
        while (expression.contains("|")) {
            int absIndex = expression.indexOf("|");
            int closingIndex = expression.lastIndexOf("|");

            if (closingIndex == -1) {
                throw new IllegalArgumentException("Неправильное расположение модульных скобок");
            }

            String subExpression = expression.substring(absIndex + 1, closingIndex);
            double subResult = evaluateExpression(subExpression);

            expression = expression.substring(0, absIndex) + Math.abs(subResult) + expression.substring(closingIndex + 1);
        }

        // Вычисляем возведение в степень
        while (expression.contains("^")) {
            int index = expression.indexOf("^");

            double leftOperand = getLeftOperand(expression, index);
            double rightOperand = getRightOperand(expression, index);

            double result = Math.pow(leftOperand, rightOperand);

            expression = replaceOperand(expression, index, result);
        }

        // Вычисляем деление, получение остатка и деление без остатка
        while (expression.contains("*") || expression.contains("/") || expression.contains("%")) {
            int index = expression.length() - 1;
            if (expression.contains("*") && expression.indexOf("*") < index) {
                index = expression.indexOf("*");
            }
            if (expression.contains("%") && expression.indexOf("%") < index) {
                index = expression.indexOf("%");
            }
            if (expression.contains("/") && expression.indexOf("/") < index) {
                index = expression.indexOf("/");
            }

            double leftOperand = getLeftOperand(expression, index);
            double rightOperand = getRightOperand(expression, index);

            double result = 0;

            if (expression.charAt(index) == '/') {
                result = leftOperand / rightOperand;
            } else if (expression.charAt(index) == '%') {
                result = leftOperand % rightOperand;
            } else {
                result = leftOperand * rightOperand;
            }

            expression = replaceOperand(expression, index, result);
        }

        // Вычисляем сложение и вычитание
        while (expression.contains("+") || expression.contains("-")) {
            int index = 0;

            if (expression.charAt(0) == '-') {
                index = expression.indexOf("-", 1);
            } else {
                index = expression.indexOf("+");
                if (index == -1) {
                    index = expression.indexOf("-");
                }
            }

            double leftOperand, rightOperand;
            try {
                leftOperand = getLeftOperand(expression, index);
            } catch (StringIndexOutOfBoundsException exception) {
                break;
            }
            rightOperand = getRightOperand(expression, index);

            double result = 0;

            if (expression.charAt(index) == '+') {
                result = leftOperand + rightOperand;
            } else if (expression.charAt(index) == '-') {
                result = leftOperand - rightOperand;
            }

            expression = replaceOperand(expression, index, result);
        }

        return Double.parseDouble(expression);
    }

    private static double getLeftOperand(String expression, int operatorIndex) {
        int start = getLeftOperandStartIndex(expression, operatorIndex);

        return Double.parseDouble(expression.substring(start, operatorIndex));
    }

    private static double getRightOperand(String expression, int operatorIndex) {
        int end = operatorIndex + 1;
        if (expression.charAt(end) == '-') {
            end++;
        }

        while (end < expression.length() && isOperandPart(expression.charAt(end))) {
            end++;
        }

        return Double.parseDouble(expression.substring(operatorIndex + 1, end));
    }

    private static boolean isOperandPart(char ch) {
        return Character.isDigit(ch) || ch == '.';
    }

    private static String replaceOperand(String expression, int operatorIndex, double result) {
        int start = getLeftOperandStartIndex(expression, operatorIndex);

        int end = operatorIndex + 1;
        if (expression.charAt(end) == '-') {
            end++;
        }
        while (end < expression.length() && isOperandPart(expression.charAt(end))) {
            end++;
        }

        return expression.substring(0, start) + result + expression.substring(end);
    }

    private static int getLeftOperandStartIndex(String expression, int operatorIndex) {
        int start = operatorIndex - 1;
        while (start >= 0 && isOperandPart(expression.charAt(start))) {
            start--;
        }
        boolean isThereSomethingBeforeMinus;
        char characterBeforeMinus;
        try {
            characterBeforeMinus = expression.charAt(start - 1);
            isThereSomethingBeforeMinus = true;
        } catch (Exception exception) {
            characterBeforeMinus = ' ';
            isThereSomethingBeforeMinus = false;
        }
        try {
            if (expression.charAt(start) == '-' && (!isThereSomethingBeforeMinus || !isOperandPart(characterBeforeMinus))) {
                start--;
            }
        } catch (StringIndexOutOfBoundsException ignored) {
        }
        start++;
        return start;
    }

    private static void saveToHistory(String expression, double result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.println(expression + " = " + result);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл истории: " + e.getMessage());
        }
    }
}
