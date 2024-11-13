// CharacterStyleTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterStyleTest {

    @Test
    public void testCharacterStyleEquality() {
        CharacterStyle style1 = new CharacterStyle("Arial", 12, "Red");
        CharacterStyle style2 = new CharacterStyle("Arial", 12, "Red");

        assertEquals(style1, style2, "CharacterStyles with same properties should be equal");
        assertEquals(style1.hashCode(), style2.hashCode(), "Hash codes should be equal for equal CharacterStyles");
    }
}
