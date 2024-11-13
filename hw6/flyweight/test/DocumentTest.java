// DocumentTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

public class DocumentTest {

    @Test
    public void testAddCharacter() {
        Document doc = new Document();
        CharacterStyle style = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        doc.addCharacter('A', style);

        List<Character> characters = doc.getCharacters();
        assertEquals(1, characters.size(), "Document should have one character");
        assertEquals('A', characters.get(0).getChar(), "Character should be 'A'");
        assertSame(style, characters.get(0).getStyle(), "Character should have the correct style");
    }

    @Test
    public void testSaveAndLoad() throws IOException {
        Document doc = new Document();
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Verdana", 16, "Black");

        doc.addCharacter('H', style1);
        doc.addCharacter('i', style2);

        String filename = "test_document.txt";
        doc.saveToFile(filename);

        Document loadedDoc = new Document();
        loadedDoc.loadFromFile(filename);

        List<Character> originalChars = doc.getCharacters();
        List<Character> loadedChars = loadedDoc.getCharacters();

        assertEquals(originalChars.size(), loadedChars.size(), "Loaded document should have the same number of characters");

        for (int i = 0; i < originalChars.size(); i++) {
            Character originalChar = originalChars.get(i);
            Character loadedChar = loadedChars.get(i);

            assertEquals(originalChar.getChar(), loadedChar.getChar(), "Characters should match");
            assertEquals(originalChar.getStyle(), loadedChar.getStyle(), "Styles should be equal");
        }
    }
}
