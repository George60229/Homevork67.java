package com.company;
public interface MySet {

        boolean myAdd(String e); // Returns true if this set did not already contain the specified element

        void myClear();

        boolean myContains(String o);

        boolean myIsEmpty();

        boolean MyRemove(String o); // Returns true if this set contained the specified element

        int MySize();

        String[] toArray();

}