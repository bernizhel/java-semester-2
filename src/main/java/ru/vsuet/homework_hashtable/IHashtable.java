package ru.vsuet.homework_hashtable;

import ru.vsuet.homework_hashtable.exceptions.KeyAlreadyExistsException;
import ru.vsuet.homework_hashtable.exceptions.NoSuchKeyException;

/**
 * Danil Kosenko's (bernizhel's) interface of a hash table that stores key value entries.
 * Actually you can consider it as an interface that extends {@code java.util.Map<K, V>} interface.
 * All implementations must correspond to the interface.
 *
 * @param <K> key type
 * @param <V> value type
 */
public interface IHashtable<K, V> {
    /**
     * Gets the value of the given key out of the Hashtable.
     *
     * @param key key of the key value entry you are looking for
     * @return found value that corresponds to the {@code key}
     * @throws NoSuchKeyException when hashtable does not have the {@code key}
     */
    V get(K key);

    /**
     * Puts the given {@code key} and {@code value} entry to the hashtable.
     *
     * @param key   key of the entry
     * @param value value of the entry
     * @throws KeyAlreadyExistsException when there is already a key present
     */
    void put(K key, V value);

    /**
     * Deletes the given {@code key} from the hashtable.
     *
     * @param key the key you want to delete
     * @throws NoSuchKeyException when there is no {@code key} to delete
     */
    void remove(K key);

    /**
     * Get the table's size.
     *
     * @return table's size
     */
    int size();

    /**
     * Entry is used to store key value entries inside a hashtable.
     *
     * @param <K> key type
     * @param <V> value type
     */
    interface Entry<K, V> {
        /**
         * Key's getter
         *
         * @return key
         */
        K getKey();

        /**
         * Value's getter
         *
         * @return value
         */
        V getValue();
    }
}
