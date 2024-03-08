package org.collections.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("=========================");
        try {
            Map<String, String> map = new HashMap<>();
            map.put("a", "a");
            HashSet<String> set = new HashSet<>();
            set.add("a");
            set.add("b");
            set.add("c");
            smth(set);
            step1(null);
            smth(map);
        } catch (Throwable t) {
            System.out.println("Oops!");
            throw new MyException("This is my message");
        } finally {
            System.out.println("this code is executed always!");
        }
        System.out.println("=========================");
    }

    public static void smth(Object o) throws IOException {
        System.out.println(((HashSet<String>) o).size());
    }

    public static void step1(String s) {
        step2(s);
    }

    public static void step2(String s) {
        step3(s);
    }

    public static void step3(String s) {
        try {
            step4(s);
        } catch (FileNotFoundException e) {
            System.out.println("step 3 ends this madness");
        }
    }

    public static void step4(String s) throws FileNotFoundException {
        step5(s);
    }

    public static void step5(String s) throws FileNotFoundException {
        step6(s);
    }

    public static void step6(String s) throws FileNotFoundException {
        step7(s);
    }

    public static void step7(String s) throws FileNotFoundException {
        step8(s);
    }

    public static void step8(String s) throws FileNotFoundException {
//        FileReader fileReader = new FileReader(new File("asdasd"));
        System.out.println(s.length());
    }
}
