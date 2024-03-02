package org.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();


        map.put("key_1", "value_1");
        map.put("key_2", "value_2");
        map.put("key_3", "value_3");

        map2.put("key_1", "new_value_1");
        map2.put("key_4", "value_4");
        map2.put("key_5", "value_5");

        System.out.println(map.getOrDefault("key_1", "default_value_1"));
        System.out.println(map.getOrDefault("key_6", "default_value_6"));


//        map.putAll(map2);
//        for (String s : map.keySet()) {
//            System.out.println(map.get(s));
//        }
//
//        for (Map.Entry e : map.entrySet()) {
//            System.out.println(e.getKey() + " : " + e.getValue());
//        }


//        System.out.println(map.get("key_1"));
//        System.out.println(map.get("key_2"));
//        System.out.println(map.get("key_3"));

//        map.put("key_1", null);
//        System.out.println(map.get("key_1"));
//        System.out.println(map.get("key_4"));
//        map.put(null, "a");
//        System.out.println(map.get(null));
//
//        for (String s : map.keySet()) {
//            System.out.println(s);
//        }
//
//        map.replace("key_5", "value_5");
//        System.out.println(map.get("key_5"));
//        System.out.println(map.remove("key_1"));
//        System.out.println(map.get("key_1"));
//        System.out.println(map.remove("key_2", "value_3"));
//        System.out.println(map.get("key_2"));

//        System.out.println(map.containsKey("key_3"));
//        System.out.println(map.containsKey("key_4"));


    }
}
