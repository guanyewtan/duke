package Processes;

import java.util.ArrayList;

public class TaskList {
    
    public static class Task {
        protected String type;
        protected String description;
        protected String isDone;
        protected String date = "";
        
        public Task(String type, String isDone, String description) {
            this.type = type;
            this.description = description;
            this.isDone = isDone;
        }
    
        public Task(String type, String isDone, String description, String date) {
            this.type = type;
            this.isDone = isDone;
            this.description = description;
            this.date = date;
        }
        
        
        public String toString() {
            if (type.equals("T")) {
                return (isDone + " " + description);
            }
            else {
                return type.equals("E") ? (isDone + " " + description + " (at: " + date + ")") : (isDone + " " + description + " (by: " + date + ")");
            }
        }
    }
    
    private ArrayList<Task> tasklist = new ArrayList<Task>();
    
    public TaskList () {
    }
    
    public TaskList (String content) throws DukeException {
        String[] lines = content.split(System.getProperty("line.separator"));
        for (String i : lines) {
            String[] word = i.split("|");
            if (word[0].equals("T")) {
                Task newTask = new Task(word[0], word[1], word[2]);
                tasklist.add(newTask);
            }
            else {
                Task newTask = new Task(word[0], word[1], word[2], word[3]);
                tasklist.add(newTask);
            }
        }
    }
    
    public void add (String type, String description, String date) {
        Task newTask = new Task(type, "[✗]", description, date);
        tasklist.add(newTask);
    }
    
    public int size() {
        return tasklist.size();
    }
    
    public TaskList.Task last() {
        return tasklist.get(tasklist.size() - 1);
    }
    
    public TaskList.Task get (int number) {
        return tasklist.get(number - 1);
    }
    
    public void done (int number) {
        tasklist.get(number - 1).isDone = "[✓]";
    }
    
    public void delete (int i) {
        tasklist.remove(i - 1);
    }
}
