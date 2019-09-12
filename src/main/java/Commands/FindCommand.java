package Commands;

import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command {
    private String query = "";
    
    public FindCommand(String query) {
        this.query = query;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            ArrayList<Integer> found = storage.find(query);
            ui.find(tasks, storage, found);
        } catch (IOException e) {
            throw new DukeException("findError");
        }
    }
}
