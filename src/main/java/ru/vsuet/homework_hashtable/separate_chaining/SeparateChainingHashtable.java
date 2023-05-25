package ru.vsuet.homework_hashtable.separate_chaining;

import ru.vsuet.homework_hashtable.IHashtable;
import ru.vsuet.homework_hashtable.exceptions.KeyAlreadyExistsException;
import ru.vsuet.homework_hashtable.exceptions.NoSuchKeyException;
import ru.vsuet.homework_hashtable.hashing_algorithm.HashingAlgorithm;
import ru.vsuet.homework_hashtable.hashtable_size_generator.HashtableSizeGenerator;
import ru.vsuet.homework_linked_list.doubly_linked.DoublyLinkedList;

import java.util.Arrays;
import java.util.Objects;

/**
 * IHashtable implementation using separate chaining technique to deal with collisions.
 *
 * @param <K>
 * @param <V>
 */
public class SeparateChainingHashtable<K, V> implements IHashtable<K, V> {
    /**
     * Default load factor used if no load factor specified on a hashtable creation.
     */
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    /**
     * Default capacity for every new hashtable created without specified size.
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 5;

    /**
     * The percentage which the hashtable to use when deciding on the rehashing.
     * Uses default load factor of a hashtable if not specified.
     *
     * @see SeparateChainingHashtable#DEFAULT_LOAD_FACTOR
     */
    private final double loadFactor;

    /**
     * HashtableSizeGenerator instance that will generate next size of the hashtable on every {@code rehash}.
     *
     * @see HashtableSizeGenerator
     * @see SeparateChainingHashtable#rehash()
     */
    private final HashtableSizeGenerator hashtableSizeGenerator;

    /**
     * Elements (entries) of the hashtable.
     */
    private DoublyLinkedList<Entry<K, V>>[] table;

    /**
     * The number of entries inside the hashtable.
     */
    private int elementsCount;

    /**
     * Creates a new hash table with the specified initial values.
     *
     * @param initialCapacity first capacity of the hashtable
     * @param loadFactor      load factor of the hash table
     * @throws IllegalArgumentException if the given {@code initialCapacity} or {@code loadFactor} are not valid
     */
    @SuppressWarnings("unchecked")
    public SeparateChainingHashtable(int initialCapacity, double loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);
        }

        if (loadFactor <= 0 || Double.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);
        }

        initialCapacity = initialCapacity == 0 ? initialCapacity + 1 : initialCapacity;
        this.table = new DoublyLinkedList[initialCapacity];
        this.loadFactor = loadFactor;
        this.hashtableSizeGenerator = new HashtableSizeGenerator(initialCapacity);

        for (int index = 0; index < table.length; index++) {
            table[index] = new DoublyLinkedList<>();
        }
    }

    /**
     * Creates a new hash table with the specified initial capacity and default (0.75) load factor.
     *
     * @param initialCapacity initial capacity of the hash table
     * @see SeparateChainingHashtable#DEFAULT_LOAD_FACTOR
     */
    public SeparateChainingHashtable(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Creates a new hash table with the default (5) initial capacity and the default (0.75) load factor.
     *
     * @see SeparateChainingHashtable#DEFAULT_INITIAL_CAPACITY
     * @see SeparateChainingHashtable#DEFAULT_LOAD_FACTOR
     */
    public SeparateChainingHashtable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Gets a value mapped to the {@code key} specified.
     *
     * @param key key of the key value entry you are looking for
     * @return value of the {@code key}
     * @throws NoSuchKeyException if the {@code key} has not been found
     */
    public V get(K key) {
        int index = getIndex(key, table.length);
        for (Entry<K, V> entry : table[index]) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
        }

        throw new NoSuchKeyException("No such a key: " + key);
    }

    /**
     * Puts the key value entry inside the hashtable.
     *
     * @param key   key of the entry
     * @param value value of the entry
     * @throws KeyAlreadyExistsException if there is already the {@code key} value entry
     */
    public void put(K key, V value) {
        if (elementsCount >= getThreshold()) {
            rehash();
        }

        int index = getIndex(key, table.length);
        for (Entry<K, V> entry : table[index]) {
            if (Objects.equals(entry.getKey(), key)) {
                throw new KeyAlreadyExistsException("Key already exists: " + key);
            }
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        table[index].add(newEntry);
        elementsCount++;
    }

    /**
     * Removes key value entry from the hashtable.
     *
     * @param key the key you want to delete
     * @throws NoSuchKeyException if there is no such a {@code key} to delete
     */
    public void remove(K key) {
        int index = getIndex(key, table.length);

        for (Entry<K, V> entry : table[index]) {
            if (Objects.equals(entry.getKey(), key)) {
                table[index].remove(entry);
                elementsCount--;
                return;
            }
        }

        throw new NoSuchKeyException("No such key: " + key);
    }

    /**
     * Get table's elements count.
     *
     * @return {@inheritDoc}
     */
    public int size() {
        return elementsCount;
    }

    /**
     * Calculates index the key value entry will be put based on the {@code key}
     *
     * @param key key of the key value entry
     * @return index to put the key value entry into
     */
    private int getIndex(K key, int tableLength) {
        int hashCode = Math.abs(HashingAlgorithm.hashCode(key));
        return hashCode % tableLength;
    }

    /**
     * Calculates number of element upon reaching to rehash the hashtable.
     *
     * @return threshold of elements
     * @see SeparateChainingHashtable#rehash()
     */
    private int getThreshold() {
        return (int) (table.length * loadFactor);
    }

    /**
     * Makes the hashtable bigger when {@code count} reaches {@code getThreshold()}.
     *
     * @see SeparateChainingHashtable#elementsCount
     * @see SeparateChainingHashtable#getThreshold()
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        int newSize = hashtableSizeGenerator.getNext();
        DoublyLinkedList<Entry<K, V>>[] newTable = new DoublyLinkedList[newSize];
        for (int index = 0; index < newTable.length; index++) {
            newTable[index] = new DoublyLinkedList<>();
        }

        for (DoublyLinkedList<Entry<K, V>> entries : table) {
            for (Entry<K, V> entry : entries) {
                int newIndex = getIndex(entry.getKey(), newTable.length);
                newTable[newIndex].add(entry);
            }
        }

        this.table = newTable;
    }

    /**
     * Stores key value pairs.
     *
     * @param key   key to store
     * @param value value to store
     * @param <K>   {@inheritDoc}
     * @param <V>   {@inheritDoc}
     */
    private record Entry<K, V>(K key, V value) implements IHashtable.Entry<K, V> {
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            // equivalent to `other.getClass() != getClass()`
            if (!(other instanceof Entry<?, ?> entry)) {
                return false;
            }

            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    @Override
    public String toString() {
        return "SeparateChainingHashtable{" +
                "loadFactor=" + loadFactor +
                ", hashtableSizeGenerator=" + hashtableSizeGenerator +
                ", table=" + Arrays.toString(table) +
                ", elementsCount=" + elementsCount +
                '}';
    }
}
