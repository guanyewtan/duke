package Commands;

import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

import java.io.IOException;

public class DoneCommand extends Command {
    private int number;
    
    public DoneCommand(int number) throws DukeException {
        this.number = number;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (number > tasks.size())
        {
            throw new DukeException("doneError");
        }
        else try {
            tasks.done(number);
            ui.doneCommand(tasks, number);
            storage.markAsDone(number);
        }
        catch (IOException e) {
            throw new DukeException("deleteError");
        }
    }
}
