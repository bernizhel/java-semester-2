package ru.vsuet.my_matrix;

public interface Matrix<N extends Number> {
    void fill();

    N getSumAboveMainDiagonal();

    N getProductOfMainDiagonal();

    N getNegativeSumBelowMainDiagonal();
}
