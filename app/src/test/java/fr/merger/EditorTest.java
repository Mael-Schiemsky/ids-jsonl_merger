package fr.merger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EditorTest {

    @Test
    public void testAddIDonEXIT() {
        Editor editor = new Editor();
        String targetJsonl = "{\"e\":\"enter\",\"method\":0}\n" +
                            "{\"e\":\"enter\",\"method\":1}\n" +
                            "{\"e\":\"exit\"}\n" +
                            "{\"e\":\"enter\",\"method\":2}\n" +
                            "{\"e\":\"exit\"}\n" +
                            "{\"e\":\"exit\"}\n";

        String expected = "{\"e\":\"enter\",\"method\":0}\n" +
                            "{\"e\":\"enter\",\"method\":1}\n" +
                            "{\"e\":\"exit\",\"method\":1}\n" +
                            "{\"e\":\"enter\",\"method\":2}\n" +
                            "{\"e\":\"exit\",\"method\":2}\n" +
                            "{\"e\":\"exit\",\"method\":0}\n";

        String actual = editor.addIdOnExit(targetJsonl);
        
        assertEquals(expected, actual);
    }
}