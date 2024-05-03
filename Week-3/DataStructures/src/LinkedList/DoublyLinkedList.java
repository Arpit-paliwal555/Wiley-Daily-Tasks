package LinkedList;

public class DoublyLinkedList {
        public Node head;
        public Node tail;
        public int size;
        DoublyLinkedList(Node head,Node tail){
            this.head = head;
            this.tail = tail;
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size = 2;

        }
        public void add(Node newNode){
            Node temp = this.tail;
            newNode.prev = temp;
            temp.next = newNode;
            this.tail = newNode;
            this.size++;
        }
        public void addFirst(Node newNode){
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            this.size++;
        }
        public void display(){
            Node temp = this.head;
            while (temp != null){
                System.out.println("["+temp.data+"]");
                temp = temp.next;
            }
        }

        public void removeEnd(){
            Node temp = this.head;
            while(temp.next.next != null)
                temp = temp.next;
            temp.next.prev = null;
            temp.next = null;
            this.size--;
        }

        public void removeFirst(){
            Node temp = this.head.next;
            this.head.next = null;
            temp.prev = null;
            this.head = temp;
            this.size--;
        }

        public void removeAtIndex(int index){
            Node temp = this.head;
            for(int i = 1; i < index; i++) {
                temp = temp.next;
            }
            if(temp == this.head){
                removeFirst();
            }else if(temp == this.tail) {
                removeEnd();
            }else{
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                this.size--;
            }
        }
        public void addAtIndex(int index, Node newNode){
            Node temp = this.head;
            if(index==this.size){
                System.out.println("Invalid Index: out of bounds!");
                return;
            }
            for(int i = 1;i < index;i++){
                temp = temp.next;
            }
            if(temp == this.head){
                addFirst(newNode);
            }else if(temp == this.tail) {
                addFirst(newNode);
            }else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }
}
