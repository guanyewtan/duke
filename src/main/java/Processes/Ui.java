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
        System.out.print(line +
                "Got it. I've added this task: \n" +
                tasks.last() +
                "Now you have" + tasks.size() + "tasks in the list.\n" +
                line);
    }
    
    public void deleteCommand(TaskList tasks, int number) {
        System.out.print(line +
                "Noted. I've removed this task:  \n" +
                tasks.get(number) +
                "Now you have" + tasks.size() + "tasks in the list.\n" +
                line);
    }
    
    public void doneCommand(TaskList tasks, int number) {
        System.out.print(line +
                "Nice! I've marked this task as done:   \n" +
                tasks.get(number) +
                line);
    }
    
    public void find(TaskList tasks, Storage storage, ArrayList<Integer> found) {
        System.out.println(line + "Here are the matching tasks in your list:");
        for (int i = 1; i <= found.size(); i += 1)
        {
            System.out.println(i + ". " + tasks.get(found.get(i - 1)));
        }
        System.out.println(line);
        
    }
    
    public void showLoadingError() {
        //Show message: error when loading file
    }
}
