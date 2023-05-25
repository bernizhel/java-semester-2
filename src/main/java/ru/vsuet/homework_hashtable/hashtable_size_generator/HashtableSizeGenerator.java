package ru.vsuet.homework_hashtable.hashtable_size_generator;

import ru.vsuet.homework_hashtable.separate_chaining.SeparateChainingHashtable;

/**
 * HashtableSizeGenerator is used to calculate size of the hashtable array after every resize
 * and while initializing if no {@code initialCapacity} has been given.
 *
 * @see SeparateChainingHashtable#SeparateChainingHashtable(int)
 */
public class HashtableSizeGenerator {
    /**
     * Current size of the table that has been returned by the last {@code getNext()} method call.
     *
     * @see HashtableSizeGenerator#getNext()
     */
    private int currentSize;

    /**
     * Current power of two that has been passed after the last {@code getNext()} method call.
     *
     * @see HashtableSizeGenerator#getNext()
     */
    private int currentPowerOfTwo;

    public HashtableSizeGenerator(int initialCapacity) {
        this.currentSize = initialCapacity;
        this.currentPowerOfTwo = (int) (Math.log(initialCapacity) / Math.log(2));
    }

    /**
     * Get next table's size number that corresponds to the following conditions:
     * <ol>
     *     <li>It is a prime number.</li>
     *     <li>It is placed between powers of two ($2^(k-1)$ and 2^k, where k is {@code currentPowerOfTwo})</li>
     * </ol>
     *
     * @return next table's size
     * @see HashtableSizeGenerator#currentSize
     * @see HashtableSizeGenerator#currentPowerOfTwo
     */
    public int getNext() {
        int nextSize = (int) Math.pow(2, currentPowerOfTwo + 1) + 1;

        while (!isPrime(nextSize)) {
            nextSize++;
        }

        currentSize = nextSize;
        currentPowerOfTwo = (int) (Math.log(nextSize) / Math.log(2));
        return currentSize;
    }

    /**
     * Checks whether the {@code number} is a prime number.
     *
     * @param number number you want to check
     * @return {@code true} or {@code false}
     */
    private boolean isPrime(int number) {
        for (int divider = 2; divider < (int) Math.sqrt(number) + 2; divider++) {
            if (number % divider == 0) {
                return false;
            }
        }

        return true;
    }
}
