// CharacterStyleFactoryTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterStyleFactoryTest {

    @Test
    public void testCharacterStyleFactory() {
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        CharacterStyle style3 = CharacterStyleFactory.getStyle("Verdana", 16, "Black");

        assertSame(style1, style2, "Factory should return the same instance for identical styles");
        assertNotSame(style1, style3, "Factory should return different instances for different styles");
    }
}
