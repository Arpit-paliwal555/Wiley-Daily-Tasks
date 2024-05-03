package Queue;

import java.util.ArrayList;

public class CustomQue<T> {
    private ArrayList<T> list;
    CustomQue(){
        list = new ArrayList<>();
    }
    public boolean offer(T item){
        list.add(item);
        return true;
    }
    public  T remove(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }
    public static void main(String[] args) {
        CustomQue<Integer> queue1 = new CustomQue<>();
        CustomQue<String> queue2 = new CustomQue<>();

        queue1.offer(1);
        queue1.offer(2);
        queue2.offer("one");
        queue2.offer("two");

        System.out.println("removed element: " + queue1.remove());
        System.out.println("peeked element: " + queue1.peek());
        System.out.println("queue size: " + queue1.size());

        System.out.println("removed element: " + queue2.remove());
        System.out.println("peeked element: " + queue2.peek());
        System.out.println("queue size: " + queue2.size());
    }
}
