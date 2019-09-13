package Commands;
import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

/**
 * The abstract form of the different commands the user can enter.
 */
public abstract class Command {
    boolean isExit = false;
    
    /**
     * Executes the user's command and carries out the necessary changes to the other class objects.
     *
     * @param tasks The tasklist where the user's tasks are stored
     * @param ui The object responsible for system output and user input.
     * @param storage The object that handles the tex document where tasks are stored in.
     * @throws DukeException
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
    
    /**
     * Check if the user has exited the program.
     * @return The state of the attribute "isExit".
     */
    public boolean isExit() {
        return isExit;
    }
}
