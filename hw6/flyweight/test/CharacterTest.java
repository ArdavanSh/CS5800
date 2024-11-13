// CharacterTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void testCharacterInitialization() {
        char c = 'A';
        CharacterStyle style = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        Character character = new Character(c, style);

        assertEquals(c, character.getChar());
        assertSame(style, character.getStyle());
    }

    @Test
    public void testCharacterStyleSharing() {
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Calibri", 14, "Blue");
        Character character1 = new Character('B', style1);
        Character character2 = new Character('C', style1);

        assertSame(character1.getStyle(), character2.getStyle());
    }
}

