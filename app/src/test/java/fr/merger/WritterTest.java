package fr.merger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class WritterTest {

    @Test
    public void testWriteFile() throws IOException {
        Writter writter = new Writter();
        Reader reader = new Reader();
        String content = "Hello world\n\nhello\nworld";
        String filePath = "src/test/resources/writeResult.jsonl";

        writter.writeFile(content, filePath);
        String fileContent = reader.readFile(filePath);

        assertEquals(content, fileContent);
    }
}
