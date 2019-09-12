package Commands;

import Processes.*;

public class ListCommand extends Command {
    
    public ListCommand() {
    
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.list(tasks);
    }
}
