package com.company;
import java.util.Arrays;

public class MyHashMap implements MyMap {

    private static class HashMapEntry implements MyMap.Entry {
        private String key;
        private String value;
        private int hashCode;
        private HashMapEntry next;

        private HashMapEntry(String key, String value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private int size = 0;
    private HashMapEntry[] table = new HashMapEntry[16];
    private double loadFactor = 0.75;
    private double threshold = loadFactor * table.length;

    @Override
    public void myClear() {
        size = 0;
        table = new HashMapEntry[16];
    }

    @Override
    public boolean myIsEmpty() {
        return size == 0;
    }

    @Override
    public int mySize() {
        return size;
    }

    @Override
    public String myPut(String key, String value) {
        String result = putInternal(key, value);
        if (result == null) {
            size++;
        }
        if (size > threshold) {
            resize();
        }
        return result;
    }

    private String putInternal(String key, String value) {
        HashMapEntry newEntry = new HashMapEntry(key, value, key.hashCode());
        int position = newEntry.hashCode % table.length;
        if (table[position] != null) {
            // проверить что в цепочке такого еще нет
            HashMapEntry tmp = table[position];
            while (tmp != null) {
                if (tmp.key.equals(key)) {
                    // если нашли такой заменяем ему value и возвращаем старое
                    String oldValue = tmp.value;
                    tmp.value = value;
                    return oldValue;
                }
                tmp = tmp.next;
            }
            // return не сработал, значит такого еще нет
            newEntry.next = table[position];
        }
        table[position] = newEntry;
        return null;
    }

    private void resize() {
        Entry[] arr = toArray();
        table = new HashMapEntry[table.length * 2];
        threshold = loadFactor * table.length;
        for (Entry entry : arr) {
            putInternal(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean myContainsKey(String key) {

        return false;
    }

    @Override
    public String myGet(String key) {
        // TODO
        return null;
    }

    @Override
    public String myRemove(String key) {
        // TODO
        return null;
    }

    @Override
    public Entry[] toArray() {
        HashMapEntry[] result = new HashMapEntry[size];
        int index = 0;
        for (HashMapEntry tmp : table) {
            while (tmp != null) {
                result[index] = tmp;
                tmp = tmp.next;
                index++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}