package Processes;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    String filepath;
    
    public Storage (String filepath)
    {
        this.filepath = filepath;
    }
    
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
            
            return content;
        }
        catch (FileNotFoundException e){
            throw new DukeException("FileNotFound");
        }
        catch (IOException e) {
            throw new DukeException("IOException");
        }
    }
    
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
    
    public void addToFile (String type, String description, String date) throws IOException {
        BufferedWriter update = new BufferedWriter(new FileWriter(filepath, true));
        String fileContent = type + "|[✗]|" + description + "|" + date + "\n";
        update.append(fileContent);
        update.close();
    }
    
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
