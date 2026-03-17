package fr.merger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class Reader {
    
    public String readFile(String filePath) {
        Path fileName = Path.of(filePath);
        String content = "";

        try{
            content = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
