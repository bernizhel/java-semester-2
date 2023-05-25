package ru.vsuet.homework_hashtable.exceptions;

/**
 * The exception is used to express key's absence in the IHashtable when searching for it.
 *
 * @see ru.vsuet.homework_hashtable.IHashtable
 */
public class NoSuchKeyException extends RuntimeException {
    public NoSuchKeyException(String message) {
        super(message);
    }
}
