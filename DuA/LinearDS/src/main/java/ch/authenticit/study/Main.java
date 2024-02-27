package ch.authenticit.study;

import ch.authenticit.study.hashtable.HashTable;

public class Main {
    public static void main(String[] args) {
        var ht = new HashTable<Integer, String>(10);
        ht.put(5, "Hello");
        ht.put(6, "World");
        System.out.println(ht.get(5) + " " + ht.get(6));
        ht.put(1, "Test");
        ht.put(11, "Collision");
        System.out.println(ht.get(1) + " " + ht.get(11));
        ht.put(21, "Extended");
        System.out.println(ht.get(1) + " " + ht.get(11) + " " + ht.get(21));
        ht.put(21, "Replaced");
        System.out.println(ht.get(1) + " " + ht.get(11) + " " + ht.get(21));

        System.out.println("--------------------");

        var ht2 = new HashTable<String, String>(10);
        ht2.put("1", "Hello");
        ht2.put("2", "World");
        System.out.println(ht2.get("1") + " " + ht2.get("2"));
        ht2.put("1", "Test");
        ht2.put("11", "Collision");
        System.out.println(ht2.get("1") + " " + ht2.get("11"));
        ht2.put("21", "Extended");
        System.out.println(ht2.get("1") + " " + ht2.get("11") + " " + ht2.get("21"));
        ht2.put("21", "Replaced");
        System.out.println(ht2.get("1") + " " + ht2.get("11") + " " + ht2.get("21"));
    }
}
