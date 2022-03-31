package com.company;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// При наличии MyHashMap реализация тривиальная
public class MyHashSet implements MySet {


    private HashSet<String>MySets = new HashSet<>();
    // просто заглушка
    private String placeHolder = "";

    @Override
    public boolean myAdd(String e) {
        int code=(e.hashCode());
        MySets.add("code");
        return true;


    }

    @Override
    public void myClear() {
        MySets.clear();
    }

    @Override
    public boolean myContains(String o) {
        return MySets.contains(o);
    }

    @Override
    public boolean myIsEmpty() {
        return MySets.isEmpty();
    }

    @Override
    public boolean MyRemove(String o) {
        if(MySets.contains(o)) {
            MySets.remove(o);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int MySize() {
        return MySets.size();
    }

    @Override
    public String[] toArray() {

        String[] res=new String[MySets.size()];
        res[0]=MySets.toString();
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

}