package Processes;


import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private String fullCommand;
    private String line = "____________________________________________________________\n";
    
    public Ui() {
    };
    
    public void showWelcome() {
        System.out.print(line + " Hello! I'm Duke\n" + " What can I do for you?\n" + line);
    }
    
    public void showLine() {
        System.out.print(line);
    }
    
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
    
    public String readCommand() {
        Scanner input = new Scanner(System.in);
        fullCommand = input.nextLine();
        return fullCommand;
    }
    
    public void addCommand(TaskList tasks) {
        System.out.print("Got it. I've added this task: \n" +
                tasks.last() + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.\n");
    }
    
    public void deleteCommand(TaskList tasks, int number) {
        System.out.print("Noted. I've removed this task:  \n" +
                tasks.getTask(number) + "\n" +
                "Now you have " + (tasks.size() - 1) + " tasks in the list.\n");
    }
    
    public void doneCommand(TaskList tasks, int number) {
        System.out.print("Nice! I've marked this task as done:   \n" +
                tasks.getTask(number) + "\n");
    }
    
    public void find(TaskList tasks, Storage storage, ArrayList<Integer> found) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 1; i <= found.size(); i += 1)
        {
            System.out.println(i + ". " + tasks.getTask(found.get(i - 1)));
        }
        
    }
    
    public void list(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); i += 1)
        {
            System.out.println(i + ". " + tasks.getTask(i));
        }
    }
    
    public void byeCommand() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }
    
    public void showLoadingError() {
        //Show message: error when loading file
    }
}
