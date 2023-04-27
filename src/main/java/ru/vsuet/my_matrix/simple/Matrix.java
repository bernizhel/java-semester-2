package ru.vsuet.my_matrix.simple;

public interface Matrix<N extends Number> {
    void fill();

    N getSumAboveMainDiagonal();

    N getProductOfMainDiagonal();

    N getNegativeSumBelowMainDiagonal();
}
