package Stack;
class TempStack<T>{
    private T[] array;
    private int top;
    private int size;


    TempStack(int size){
        this.size = size;
        this.array = (T[]) new Object[size];
        this.top = -1;
    }
    public void push(T item){
        if(isFull()){
            System.err.println("Stack Overflow!");
            return ;
        }
        array[++top] = item;
    }
    public T pop(){
        if(isEmpty()){
            System.err.println("Stack Underflow!");
            return null;
        }
        return array[top--];
    }
    public boolean isFull(){
        return top==size-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
}

public class CustomStack {
    public static void main(String[] args)   {
        TempStack<String> stack1 = new TempStack<>(4);
        TempStack<Integer> stack2 = new TempStack<>(4);
        stack1.push("hi");
        stack2.push(1);
        stack1.push("hi2");
        stack2.push(12);

        System.out.println(stack1.pop());
        System.out.println(stack2.pop());

    }
}
