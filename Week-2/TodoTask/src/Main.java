import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Task{
    String taskName;
    String description;
    String duration;
    String status = "Pending";

    public Task(String taskName, String description, String duration) {
        this.taskName = taskName;
        this.description = description;
        this.duration = duration;
    }
    public void changeStatus(String status){
        this.status = status;
    }

}
public class Main {
    Queue<Task> todoQueue = new LinkedList<>();
    Stack<Task> stack = new Stack<>();
    void addNewTask(Task task){
        todoQueue.add(task);
        System.out.println("task added");
    }

    void processTasks(){
        if(todoQueue.isEmpty()) {
            System.out.println("No tasks in the que!");
            return;
        }
        Task tsk = todoQueue.poll();
        //assert tsk != null;
        tsk.changeStatus("Completed");
        stack.push(tsk);
        System.out.println("First pending task done!");
    }

    void displayCompletedTask(){
        System.out.println("Last completed Task:");
        Task tsk = stack.peek();
        System.out.println(tsk.taskName);
    }
    public static void main(String[] args) {

        Task t1 = new Task("gym","go to the gym","1 hour");
        Task t2 = new Task("code","do coding","3 hour");
        Task t3 = new Task("read","read books","1 hour");
        Main mn = new Main();

        mn.addNewTask(t1);
        mn.addNewTask(t2);
        mn.addNewTask(t2);

        mn.processTasks();
        mn.processTasks();

        mn.displayCompletedTask();
    }
}