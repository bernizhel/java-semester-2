package ru.vsuet.matrices.interfaces;

public interface Matrix<N extends Number> {
    void fill();

    N getSumAboveMainDiagonal();

    N getProductOfMainDiagonal();

    N getNegativeSumBelowMainDiagonal();
}
