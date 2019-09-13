package Processes;

import java.util.ArrayList;

/**
 * Handle the array that stores the task details.
 */
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
        if (content.equals(""))
        {
            throw new DukeException("No content");
        }
        String[] lines = content.split(System.getProperty("line.separator"));
        for (String i : lines) {
            String[] word = i.split("\\|");
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
    
    /**
     * Add a task to the tasklist array.
     *
     * @param type The type of task to be added. Either a Todo, Event, or Deadline.
     * @param description The description of the task to be added.
     * @param date The date associated with an Event or Deadline.
     */
    public void add (String type, String description, String date) {
        Task newTask = new Task(type, "[✗]", description, date);
        tasklist.add(newTask);
    }
    
    /**
     * Returns the size of the tasklist.
     * @return An integer equal the number of elements in the tasklist.
     */
    public int size() {
        return tasklist.size();
    }
    
    /**
     * This method returns the last element in the tasklist.
     * @return The index of the last element in the tasklist.
     */
    public TaskList.Task last() {
        return tasklist.get(tasklist.size() - 1);
    }
    
    /**
     * Returns the toString of a task in the tasklist.
     *
     * @param number The number of the task to be returned.
     * @return The toString of the task.
     */
    public TaskList.Task getTask (int number) {
        return tasklist.get(number - 1);
    }
    
    /**
     * Changes the task to a "done" state.
     *
     * @param number The number of the task to be set as "done".
     */
    public void done (int number) {
        tasklist.get(number - 1).isDone = "[✓]";
    }
    
    /**
     * Delete a task.
     *
     * @param i The number of the task to be deleted.
     */
    public void delete (int i) {
        tasklist.remove(i - 1);
    }
}
