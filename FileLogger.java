package FinalProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger { 

    private String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            out.println("Log: " + message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    
}
