package fr.merger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MapperTest {

    @Test
    public void testMap() {
        Mapper mapper = new Mapper();
        String idsProperties = "First=1\nSecond=10";
        String targetJsonl = "{\"method\":0}\n{\"method\":1}\n{\"method\":10}";
        
        String expected = "{\"method\":0}\n{\"method\":\"First\"}\n{\"method\":\"Second\"}";
        String actual = mapper.map(idsProperties, targetJsonl);
        
        assertEquals(expected, actual);
    }

}
