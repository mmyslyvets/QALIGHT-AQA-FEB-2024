package org.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    /**
     * linked list:
     *                                      !
     * [start-of-list]-[a]-[b]-....-[c]-[d]-[e]-[end-of-list]
     * [start-of-list]-[a]-[b]-....-[c]-[d]-[f]-[e]-[end-of-list]
     * array list:
     * [0:"a"],[1:"b"],[2:"f"],[2+1:"c"],.....,[999999999998+1:"d"],[999999999999+1:"e"]
     * @param args
     */

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
        String s = ((ArrayList<String>) sList).get(0);
        String s2 = ((LinkedList<String>) sList).get(0);
    }
}
