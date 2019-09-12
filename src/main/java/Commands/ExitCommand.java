package Commands;

import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return !super.isExit();
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.byeCommand();
    }
}
