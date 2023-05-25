package ru.vsuet.homework_hashtable.separate_chaining;

public class Main {
    public static void main(String[] args) {
        SeparateChainingHashtable<String, Integer> hashtable = new SeparateChainingHashtable<>();

        hashtable.put("a", 1);
        hashtable.put("b", 2);
        hashtable.put("c", 3);
        hashtable.put("d", 4);
        hashtable.put("e", 5);
        hashtable.put("f", 6);
        hashtable.put("g", 7);
        hashtable.put("h", 8);
        hashtable.put("k", 9);
        hashtable.put("l", 10);
        hashtable.put("m", 11);
        hashtable.put("n", 12);
        hashtable.put("o", 13);

        System.out.println(hashtable);
    }
}
