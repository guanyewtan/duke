package Processes;

import java.io.*;
import java.util.ArrayList;

/**
 * Handle the local storage and modifies the text document that task data is stored in.
 */

public class Storage {
    String filepath;
    
    public Storage (String filepath)
    {
        this.filepath = filepath;
    }
    
    /**
     * Read the text from the text document that task information is stored, then returns it as a string.
     *
     * @return content A string containing the text from the text document.
     * @throws DukeException
     */
    public String load() throws DukeException {
        try {
            String content = "";
            File fileToBeModified = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
    
            String line = reader.readLine();
            while (line != null) {
                content = content + line + System.lineSeparator();
                line = reader.readLine();
            }
            //System.out.println(content);
            return content;
        }
        catch (FileNotFoundException e){
            throw new DukeException("FileNotFound");
        }
        catch (IOException e) {
            throw new DukeException("IOException");
        }
    }
    
    
    /**
     * Erase a task from the text document.
     *
     * @param taskNo The number (row number) of the task to be deleted.
     * @throws IOException
     */
    public void delete(int taskNo) throws IOException {
        String content = "";
        File fileToBeModified = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        
        int counter = 1;
        String line = reader.readLine();
        while (line != null) {
            if (counter == taskNo)
            {
                line = reader.readLine();
                counter += 1;
                continue;
            }
            content = content + line + System.lineSeparator();
            line = reader.readLine();
            counter += 1;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToBeModified));
        writer.write(content);
        
        reader.close();
        writer.close();
    }
    
    
    /**
     * Mark a task as done, by editing a variable in the text document.
     *
     * @param taskNo The number of the task to be marked as done.
     * @throws IOException
     */
    public void markAsDone (int taskNo) throws IOException {
        String content = "";
        File fileToBeModified = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        
        int counter = 1;
        String line = reader.readLine();
        while (line != null) {
            if (counter == taskNo)
            {
                line = line.replace("[✗]", "[✓]");
            }
            content = content + line + System.lineSeparator();
            line = reader.readLine();
            counter += 1;
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileToBeModified));
        writer.write(content);
        
        reader.close();
        writer.close();
    }
    
    
    /**
     * Add a new task to the text document.
     *
     * @param type The type of task to be added. Either a ToDo, Event, or Deadline.
     * @param description The description of the task to be added.
     * @param date The date associated with an Event or Deadline.
     * @throws IOException
     */
    public void addToFile (String type, String description, String date) throws IOException {
        BufferedWriter update = new BufferedWriter(new FileWriter(filepath, true));
        String fileContent = type + "|[✗]|" + description + "|" + date + "\n";
        update.append(fileContent);
        update.close();
    }
    
    /**
     * Search for all occurrences of word in the text document.
     * @param word The word to be searched for.
     * @return row An array that contains the indexes of the tasks which contain the word.
     * @throws IOException
     */
    public ArrayList<Integer> find(String word) throws IOException {
        ArrayList<Integer> row = new ArrayList<Integer>();
        String content = "";
        File fileToBeModified = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        
        int counter = 0;
        String line = reader.readLine();
        while (line != null) {
            if (line.contains(word))
            {
                row.add(counter);
            }
            line = reader.readLine();
            counter += 1;
        }
        
        return row;
    }
}
