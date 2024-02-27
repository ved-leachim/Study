package ch.authenticit.study.hashtable;

import java.util.LinkedList;

public class HashTable<K, V> {
    private final LinkedList<Entry<K, V>>[] entries;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        entries = new LinkedList[size];
    }

    public void put(K key, V value) {
        var entry = new Entry<>(key, value);
        var hash = hash(key);

        var slot = entries[hash];

        if (slot == null) {

            slot = new LinkedList<>();
            slot.add(entry);
            entries[hash] = slot;
        } else {
            handleCollision(entries[hash], entry);
        }
    }

    public V get(K key) {
        var hash = hash(key);

        if (entries[hash] == null)
            return null;

        var ll = entries[hash];
        for (Entry<K, V> kvEntry : ll) {
            if (kvEntry.key.equals(key))
                return kvEntry.value;
        }

        return null;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    private void handleCollision(LinkedList<Entry<K, V>> ll, Entry<K, V> newEntry) {
        for (Entry<K, V> kvEntry : ll) {
            if (kvEntry.key.equals(newEntry.key)) {
                kvEntry.setValue(newEntry.value);
                return;
            }
        }
        ll.add(newEntry);
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
