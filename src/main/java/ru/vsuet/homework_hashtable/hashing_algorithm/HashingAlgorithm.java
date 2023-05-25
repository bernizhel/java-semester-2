package ru.vsuet.homework_hashtable.hashing_algorithm;

/**
 * HashingAlgorithm class has only one static method that can take various types of objects and calculate their hashes.
 * It aims to use such hash functions that will have minimal collision rate when using in hash tables.
 *
 * @see ru.vsuet.homework_hashtable.IHashtable
 */
public class HashingAlgorithm {
    public static <K> int hashCode(K object) {
        if (object instanceof Number) {
            return ((Number) object).intValue();
        }

        if (object instanceof String) {
            return ((String) object).chars().reduce(0, (accumulator, nextCharacter) -> accumulator + (nextCharacter << 5 - nextCharacter));
        }

        return object.hashCode();
    }
}
