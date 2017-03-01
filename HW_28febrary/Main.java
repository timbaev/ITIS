package HW_28febrary;

public class Main {

    public static void main(String args[]) {
        Stack<String> stackString = new Stack<>();
        Queue<Integer> integerQueue = new Queue<>();

        stackString.add("ITIS");
        stackString.add("Hello world");
        stackString.add("Test");

        System.out.println("pop stack: " + stackString.pop());
        System.out.println("peek stack: " + stackString.peek());
        System.out.println("size stack: " + stackString.size());

        System.out.println("---------------------------------");

        integerQueue.add(5);
        integerQueue.add(10);
        integerQueue.add(35);

        System.out.println("pop queue: " + integerQueue.pop());
        System.out.println("peek queue: " + integerQueue.peek());
        System.out.println("size queue: " + integerQueue.size());
    }
}
