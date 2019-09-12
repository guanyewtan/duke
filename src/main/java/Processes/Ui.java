package Processes;


import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class deals with all the user input and system output.
 */
public class Ui {
    private String fullCommand;
    private String line = "____________________________________________________________\n";
    
    public Ui() {
    };
    
    /**
     * This method displays the welcome message.
     */
    public void showWelcome() {
        System.out.print(line + " Hello! I'm Duke\n" + " What can I do for you?\n" + line);
    }
    
    /**
     * This method prints a bloody long line.
     */
    public void showLine() {
        System.out.print(line);
    }
    
    /**
     * This method is currently not in use.
     * @param errorMessage
     */
    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }
    
    /**
     * This method reads in the user command.
     *
     * @return A string of the user command.
     */
    public String readCommand() {
        Scanner input = new Scanner(System.in);
        fullCommand = input.nextLine();
        return fullCommand;
    }
    
    /**
     * This method prints a message when a task is added.
     *
     * @param tasks The user's tasks.
     */
    public void addCommand(TaskList tasks) {
        System.out.print("Got it. I've added this task: \n" +
                tasks.last() + "\n" +
                "Now you have " + tasks.size() + " tasks in the list.\n");
    }
    
    /**
     * This method prints a message when a task is deleted.
     *
     * @param tasks The user's tasks.
     * @param number The number of the task to be deleted.
     */
    public void deleteCommand(TaskList tasks, int number) {
        System.out.print("Noted. I've removed this task:  \n" +
                tasks.getTask(number) + "\n" +
                "Now you have " + (tasks.size() - 1) + " tasks in the list.\n");
    }
    
    /**
     * This method prints a message when the "done" command is run,
     *
     * @param tasks The user's tasks.
     * @param number The number of the task to be marked as done.
     */
    public void doneCommand(TaskList tasks, int number) {
        System.out.print("Nice! I've marked this task as done:   \n" +
                tasks.getTask(number) + "\n");
    }
    
    /**
     * This method prints the tasks that contain the word that the user wants to search for.
     *
     * @param tasks The user's tasks.
     * @param storage The object that handles the text document.
     * @param found The array containing the number of the tasks that have the user's word.
     */
    public void find(TaskList tasks, Storage storage, ArrayList<Integer> found) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 1; i <= found.size(); i += 1)
        {
            System.out.println(i + ". " + tasks.getTask(found.get(i - 1)));
        }
        
    }
    
    /**
     * This method prints all the tasks in tasklist.
     *
     * @param tasks The user's tasks.
     */
    public void list(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= tasks.size(); i += 1)
        {
            System.out.println(i + ". " + tasks.getTask(i));
        }
    }
    
    /**
     * This method prints a sad message when the user has got to go :(
     */
    public void byeCommand() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }
    
    /**
     * This method is currently not in use.
     */
    public void showLoadingError() {
        //Show message: error when loading file
    }
}
