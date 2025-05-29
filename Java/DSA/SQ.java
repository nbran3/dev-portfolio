import java.util.*;

public class SQ {

    public static void main(String[] args) {

        // Stacks
        Stack<String> stack = new Stack<>();

        stack.push("Pizza");
        stack.push("Apple");
        stack.push("Ice Cream");
        stack.push("Chicken");
        stack.push("Steak");

        System.out.println(stack.search("Pizza"));

        stack.pop();

        System.out.println(stack.peek());

        stack.stream().sorted().forEach(food -> System.out.println(food));


        // Queues
        Queue<String> queue = new LinkedList<>();

        queue.offer("Tom");
        queue.offer("Tim");
        queue.offer("Jane");
        queue.offer("Sally");

        System.out.println(queue.peek());
        System.out.println(queue.poll());

        System.out.println(queue.contains("Jane"));
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        queue.stream().sorted().forEach(name -> System.out.println(name));

        // Priority Queues

        Queue<Double> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        pQueue.offer(58.2);
        pQueue.offer(82.2);
        pQueue.offer(76.2);
        pQueue.offer(39.2);

        while(!pQueue.isEmpty()){
            System.out.println(pQueue.poll());
        }



    }

}
