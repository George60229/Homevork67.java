package com.company;

public interface MyMap {

    interface Entry {
        String getKey();
        String getValue();
        void setValue(String value);
    }

    void myClear();

    boolean myContainsKey(String key);

    String myGet(String key);

    boolean myIsEmpty();

    String myRemove(String key); // Returns the value to which this map previously associated the key, or null

    String myPut(String key, String value); // Returns the previous value associated with key, or null

    int mySize();

    Entry[] toArray();

}