package ru.vsuet.homework_hashtable.hashing_algorithm;

/**
 * HashingAlgorithm class has only one static method that can take various types of objects and calculate their hashes.
 * It aims to use such hash functions that will have minimal collision rate when using in hash tables.
 *
 * @see ru.vsuet.homework_hashtable.IHashtable
 */
public class HashingAlgorithm {
    /**
     * Calculates object's hash by a custom algorithm.
     * Returns a random integer representing a hash.
     * It can return any number from {@code Integer.MIN_VALUE} to {@code Integer.MAX_VALUE}.
     *
     * @param object object you want to hash
     * @param <K>    object's type
     * @return object's hash represented as an integer.
     * @see Integer#MIN_VALUE
     * @see Integer#MAX_VALUE
     */
    public static <K> int hashCode(K object) {
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }

        if (object instanceof String) {
            return ((String) object).chars().reduce(0, (acc, nextChar) -> acc + (nextChar << 5 - nextChar));
        }

        return object.hashCode();
    }
}
