package org.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

    /**Queue
     *                                           action_5
     *                                action_4 > action_4
     *                      action_3> action_3 > action_3
     *            action_2> action_2> action_2 > action_2
     * action_1 > action_1> action_1> action_1 > action_1
     * @param args
     */

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("f");

    }
}
