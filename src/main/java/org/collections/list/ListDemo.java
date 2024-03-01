package org.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        List<String> aList2 = new ArrayList<>();
        List<String> lList = new LinkedList<>();

        aList.add("4");
        aList.add("3");
        aList.add("3");
        aList.add("3");
        aList.add("3");
        aList.add("3");
        aList.add("3");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("2");
        aList.add("1");
        aList.add("0");

        aList2.add("3");
        aList2.add("2");

        for (Object o : aList) {
            System.out.println(o);
        }

        System.out.println("Contains 3: " + aList.contains("3"));
        System.out.println("Contains 3,2: " + aList.containsAll(aList2));

        aList2.add("5");
        System.out.println("Contains 3,2,5: " + aList.containsAll(aList2));

//        aList.removeAll(aList2);
//        for (Object o : aList) {
//            System.out.println(o);
//        }

        System.out.println(aList.indexOf("2"));
        System.out.println(aList.lastIndexOf("2"));

        List<String> subList = aList.subList(3, 15);
    }

    public static void smth(List<String> sList) {

    }
}
