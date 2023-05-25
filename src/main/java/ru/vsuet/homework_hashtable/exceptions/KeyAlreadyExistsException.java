package ru.vsuet.homework_hashtable.exceptions;

/**
 * The exception is used to express key's existence in the IHashtable when putting the exact same key.
 *
 * @see ru.vsuet.homework_hashtable.IHashtable
 */
public class KeyAlreadyExistsException extends RuntimeException {
    public KeyAlreadyExistsException(String message) {
        super(message);
    }
}
