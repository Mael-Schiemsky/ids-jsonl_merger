package fr.merger;

import java.io.FileWriter;
import java.io.IOException;

public class Writter {

    public void writeFile(String content, String filePath) {
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(content);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
