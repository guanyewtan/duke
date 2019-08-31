import java.io.*;
import java.util.ArrayList;

public class Editor {
    protected String type;
    protected String description;
    protected String date = "";
    public String line = "____________________________________________________________\n";
    public String directory = "C:\\Users\\GY\\Downloads\\CS2113T\\duke\\data\\duke.txt";
    
    public Editor () {
    
    }
    
    public Editor(String type, String description) throws IOException {
        this.type = type;
        this.description = description;
    }
    
    public Editor(String type, String description, String date) throws IOException {
        this.type = type;
        this.description = description;
        this.date = date;
    }
    
    public void addToFile () throws IOException {
        BufferedWriter update = new BufferedWriter(new FileWriter(directory, true));
        String fileContent = type + "|false|" + description + "|" + date + "\n";
        update.append(fileContent);
        update.close();
    }
    
    public void markAsDone (int taskNo) throws IOException {
        String content = "";
        File fileToBeModified = new File(directory);
        BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
        
        int counter = 1;
        String line = reader.readLine();
        while (line != null) {
            if (counter == taskNo)
            {
                line = line.replace("false", "true");
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
    
    
    public void remove(int taskNo) throws IOException {
        String content = "";
        File fileToBeModified = new File(directory);
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
    
    public void clear() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(directory));
        writer.write("");
        writer.close();
    }
    

    
    public ArrayList<Integer> find(String word) throws IOException {
        ArrayList<Integer> row = new ArrayList<Integer>();
        String content = "";
        File fileToBeModified = new File(directory);
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