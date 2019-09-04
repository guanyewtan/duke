import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Duke {
    /**
     * To update: DukeException, Textfile update when starting build
     */
    
    public static void main(String[] args) throws IOException {
        String directory = "C:\\Users\\GY\\Downloads\\CS2113T\\duke\\data\\duke.txt";
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
        dateFormat.setLenient(false);
        String line = "____________________________________________________________\n";
        ArrayList<Task> tasklist = new ArrayList<Task>();
        
        System.out.println(line + " Hello! I'm Duke\n" + " What can I do for you?\n" + line);
        
        
        while (true) {
            String typing = input.nextLine();
            int indexOfSpace = typing.indexOf(" ");
            String instruction = (indexOfSpace != -1) ? typing.substring(0, indexOfSpace) : typing;
            
            
            
            if (instruction.equals("todo")) {
                if (indexOfSpace == -1) {
                    System.out.println(line + "☹ OOPS!!! The description of a todo cannot be empty.\n" + line);
                    continue;
                }
                String description = typing.substring(indexOfSpace + 1);
                Task t = new Todo(description);
                tasklist.add(t);
                System.out.println(line + "Got it. I've added this task: \n" + "  " + t);
                System.out.println("Now you have " + tasklist.size() + " task(s) in the list.\n" + line);
                
                try {
                    Editor p = new Editor("T", description);
                    p.addToFile();
                }
                catch (IOException e) {
                    System.out.println(line + "☹ OOPS!!! Something's wrong with the file!\n" + line);
                }
            }
            
            
            
            else if (instruction.equals("deadline")) {
                int indexOfSlash = typing.indexOf("/by");
                if (indexOfSlash == -1)
                {
                    System.out.println(line + "☹ OOPS!!! Please use /by\n" + line);
                    continue;
                }
                
                try {
                    String description = typing.substring(indexOfSpace + 1, indexOfSlash - 1);
                    String time = typing.substring(indexOfSlash + 4);
                    Date date = dateFormat.parse(typing.substring(indexOfSlash + 4));
                    
                    Task t = new Deadline(description, time);
                    tasklist.add(t);
                    System.out.println(line + "Got it. I've added this task: \n" + t);
                    System.out.println("Now you have " + tasklist.size() + " task(s) in the list.\n" + line);
                    Editor p = new Editor("D", description, time);
                    p.addToFile();
                }
                catch (StringIndexOutOfBoundsException e) {
                    System.out.println(line + "☹ OOPS!!! Please enter a valid deadline input.\n" + line);
                }
                catch (ParseException e) {
                    System.out.println(line + "☹ OOPS!!! Please enter a valid date! dd-MMM-yyyy HH:mm:ss \n" + line);
                }
                catch (IOException e) {
                    System.out.println(line + "☹ OOPS!!! Something's wrong with the file!\n" + line);
                }
            }
            
            
            
            else if (instruction.equals("event")) {
                int indexOfSlash = typing.indexOf("/at");
                if (indexOfSlash == -1)
                {
                    System.out.println(line + "☹ OOPS!!! Please use /at\n" + line);
                    continue;
                }
                
                try {
                    String description = typing.substring(indexOfSpace + 1, indexOfSlash - 1);
                    String time = typing.substring(indexOfSlash + 4);
                    Date date = dateFormat.parse(typing.substring(indexOfSlash + 4));
                    Task t = new Event(description, time);
                    tasklist.add(t);
                    System.out.println(line + "Got it. I've added this task: \n" + t);
                    System.out.println("Now you have " + tasklist.size() + " task(s) in the list.\n" + line);
                    Editor p = new Editor("E", description, time);
                    p.addToFile();
                }
                catch (StringIndexOutOfBoundsException e) {
                    System.out.println(line + "☹ OOPS!!! Please enter a valid event input.\n" + line);
                }
                catch (ParseException e) {
                    System.out.println(line + "☹ OOPS!!! Please enter a valid date! dd-MMM-yyyy HH:mm:ss \n" + line);
                }
                catch (IOException e) {
                    System.out.println(line + "☹ OOPS!!! Something's wrong with the file!\n" + line);
                }
            }
            
            
            
            else if (instruction.equals("done")) {
                try {
                    int temp = Integer.parseInt(typing.substring(5));
                    tasklist.get(temp - 1).done();
                    System.out.println(line + "Nice! I've marked this task as done: ");
                    System.out.println(tasklist.get(temp - 1) + "\n" + line);
                    Editor p = new Editor();
                    p.markAsDone(temp);
                }
                catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println(line + "Please enter a valid task!\n" + line);
                }
                catch (IOException e) {
                    System.out.println(line + "☹ OOPS!!! Something's wrong with the file!\n" + line);
                }
            }
            
            
            
            else if (instruction.equals("delete")) {
                try {
                    int temp = Integer.parseInt(typing.substring(7));
                    tasklist.remove(temp - 1);
                    System.out.println("Noted. I've removed this task:\n" + "  " + tasklist.get(temp - 1));
                    System.out.println("Now you have " + tasklist.size() + " task(s) in the list.\n" + line);
                    Editor p = new Editor();
                    p.remove(temp);
                }
                catch (NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println(line + "Please enter a valid task!\n" + line);
                }
                catch (IOException e) {
                    System.out.println(line + "☹ OOPS!!! Something's wrong with the file!\n" + line);
                }
            }
            
            
            
            else if (instruction.equals("clear"))
            {
                System.out.println(line + "List has been cleared!\n" + line);
                Editor p = new Editor();
                p.clear();
                tasklist.clear();
            }
            
            
            
            else if (instruction.equals("list")) {
                System.out.println(line + "Here are the tasks in your list: ");
                for (int i = 0; i < tasklist.size(); i += 1) {
                    System.out.print((i + 1) + ". ");
                    System.out.println(tasklist.get(i));
                }
                System.out.print(line);
            }
            
            

            else if (instruction.equals("find"))
            {
                Editor p = new Editor();
                ArrayList<Integer> found = p.find(typing.substring(5));

                System.out.println(line + "Here are the matching tasks in your list:");
                for (int i = 1; i <= found.size(); i += 1)
                {
                    System.out.println(i + ". " + tasklist.get(found.get(i - 1)));
                }
                System.out.println(line);
            }
            
            
            
            else if (instruction.equals("bye")) {
                break;
            }
            else {
                System.out.println(line + "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
            }
            
        }
        
        System.out.println(line + "Bye. Hope to see you again soon!\n" + line);
    }
}