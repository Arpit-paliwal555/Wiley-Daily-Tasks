import java.util.*;

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
        System.out.println("Completing task: "+tsk.taskName);
        stack.push(tsk);
        System.out.println("First pending task done!");
    }

    void displayCompletedTask(){

        for (Task tsk: stack) {
            System.out.println("Last completed Task:");
            System.out.println(tsk.taskName);
        }
    }
    public static void main(String[] args) {

        Task t1 = new Task("gym","go to the gym","1 hour");
        Task t2 = new Task("code","do coding","3 hour");
        Task t3 = new Task("read","read books","1 hour");
        Main mn = new Main();

        mn.addNewTask(t1);
        mn.addNewTask(t2);
        mn.addNewTask(t2);

        Scanner sc = new Scanner(System.in);
        System.out.println("complete all tasks(y/n):");
        String ans = sc.nextLine();
        if(ans.equals("y")){
            while (!mn.todoQueue.isEmpty()){
                mn.processTasks();
            }
            System.out.println("All tasks marked completed!");
        }

        System.out.println("show complete all tasks(y/n):");
        String ans2 = sc.nextLine();
        if(ans2.equals("y")){
            mn.displayCompletedTask();
        }



        mn.displayCompletedTask();
    }
}