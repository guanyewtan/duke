package Commands;

import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

import java.io.IOException;

public class DeleteCommand extends Command {
    private int number = -1;
    
    public DeleteCommand(int number) {
        this.number = number;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (number > tasks.size()) {
            throw new DukeException("deleteError");
        }
        
        else try {
            ui.deleteCommand(tasks, number);
            tasks.delete(number);
            storage.delete(number);
        }
        catch (IOException e) {
            throw new DukeException("deleteError");
        }
    }
}
