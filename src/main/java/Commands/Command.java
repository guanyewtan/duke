package Commands;
import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;


public abstract class Command {
    boolean isExit = false;
    
    
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    
    
    public boolean isExit() {
        return isExit;
    }
}
