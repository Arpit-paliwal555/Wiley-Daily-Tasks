package LinkedList;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail = new Node(2);
        DoublyLinkedList dlist = new DoublyLinkedList(head,tail);
        dlist.add(new Node(3));
        dlist.add(new Node(4));
        dlist.add(new Node(5));
        dlist.add(new Node(6));
        dlist.addFirst(new Node(0));
        dlist.display();
        System.out.println("-------------------------");



        dlist.add(new Node(7));
        dlist.add(new Node(8));
        dlist.removeEnd();
        dlist.removeFirst();
        dlist.display();
        System.out.println("-------------------------");

        dlist.removeAtIndex(5);//do not enter the tail or head index
        dlist.display();
        dlist.addAtIndex(6,new Node(9));// do not enter the tail or head index;
        dlist.display();
    }
}
