package Processes;

public class TaskOld {
    protected String description;
    protected boolean isDone;
    protected String date;

    public TaskOld(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatus() {
        return (isDone ? "[✓] " : "[✗] "); //return tick or X symbols
    }

    public void done() {
        isDone = true;
    }

    public String toString() {
        return (this.getStatus() + description);
    }
}