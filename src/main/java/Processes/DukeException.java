package Processes;

/**
 * This class extends the Exception class, and is thrown when an exception or Duke-specific error occurs.
 *
 */

public class DukeException extends Exception {
    public DukeException (String error) {
        System.out.println(error);
        if (error.equals("BadCommand"))
        {
            System.out.println("Please enter a valid command!");
        }
    }
    public DukeException (Exception e) {
        //print out exception message
        System.out.println("shit there's an error");
    }
}
