package Commands;


import Processes.DukeException;
import Processes.Storage;
import Processes.TaskList;
import Processes.Ui;

import javax.imageio.IIOException;
import java.io.IOException;

public class AddCommand extends Command {
    private String type;
    private String description;
    private String date = "";
    
    
    public AddCommand (String type, String description) {
        this.type = type;
        this.description = description;
    }
    
    public AddCommand (String type, String description, String date) {
        this.type = type;
        this.description = description;
        this.date = date;
    }
    
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            storage.addToFile(type, description, date);
            tasks.add(type, description, date);
            ui.addCommand(tasks);
        }
        catch (IOException e) {
            throw new DukeException("IOException");
        }
    }
}
