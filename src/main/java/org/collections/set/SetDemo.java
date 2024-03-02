package org.collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        System.out.println(set.size());

        for (String s : set) {
            System.out.println(s);
        }
    }
}
