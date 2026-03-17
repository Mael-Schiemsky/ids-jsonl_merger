package fr.merger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class ReaderTest{

    @Test
    public void testReadFile() throws IOException {
        Reader reader = new Reader();
        String content = reader.readFile("src/test/resources/ids.properties");
        
        assertEquals("ITestTheMapper=0", content);
    }
}
