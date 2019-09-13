package Processes;

import Commands.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Process the input that is entered by the user.
 */

public class Parser {
    private static String instruction;
    private static String description = "";
    private static String byOrAt;
    private static Date date;
    private static String dateString;
    
    public Parser() {
    };
    
    /**
     * This method breaks down the user input into smaller parts and processes the instructions.
     * @param fullCommand The full command as entered by the user.
     * @return The command that will run depending on what the user enters.
     * @throws DukeException The exception that is thrown.
     */
    
    public static Command parse(String fullCommand) throws DukeException {
        try {
            int indexOfSpace = fullCommand.indexOf(" ");
            if (indexOfSpace != -1) {
                instruction = fullCommand.substring(0, indexOfSpace);
                int indexOfSlash = fullCommand.indexOf("/");
                if (indexOfSlash != -1) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HHmm");
                    dateFormat.setLenient(false);
                    description = fullCommand.substring(indexOfSpace + 1, indexOfSlash - 1);
                    byOrAt = fullCommand.substring(indexOfSlash, fullCommand.indexOf(" ", indexOfSlash));
                    dateString = fullCommand.substring(fullCommand.indexOf(" ", indexOfSlash));
                    date = dateFormat.parse(dateString); //This throws an exception if date is wrongly entered
                }
                else
                {
                    description = fullCommand.substring(indexOfSpace + 1);
                }
            }
            else {
                instruction = fullCommand;
            }
            
            if (instruction.equals("todo")) {
                if (description.equals("")) {
                    throw new DukeException("Empty description");
                }
                else {
                    return new AddCommand("T", description);
                }
                
            }
            
            else if (instruction.equals("event")) {
                if (description.equals("")) {
                    throw new DukeException("Empty description");
                }
                else if (!byOrAt.equals("/at")) {
                    throw new DukeException("Not /at");
                }
                else {
                    return new AddCommand("E", description, dateString);
                }
            }
    
            else if (instruction.equals("deadline")) {
                if (description.equals("")) {
                    throw new DukeException("Empty description");
                }
                else if (!byOrAt.equals("/by")) {
                    throw new DukeException("Not /by");
                }
                else {
                    return new AddCommand("D", description, dateString);
                }
            }
            
            else if (instruction.equals("done")) {
                int num = Integer.parseInt(description);
                return new DoneCommand(num);
            }
            
            else if (instruction.equals("bye")) {
                return new ExitCommand();
            }
            
            else if (instruction.equals("find")) {
                return new FindCommand(description);
            }
            
            else if (instruction.equals("delete")) {
                int num = Integer.parseInt(description);
                return new DeleteCommand(num);
            }
            
            else if (instruction.equals("list")) {
                return new ListCommand();
            }
            
            throw new DukeException("BadCommand");
        }
        
        catch (ParseException e) {
            throw new DukeException(e);
        }
        catch (NullPointerException e) {
            throw new DukeException("/by or /at");
        }
    
    }
    
}
