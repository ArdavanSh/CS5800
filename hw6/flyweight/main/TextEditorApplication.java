import java.io.IOException;

// TextEditorApplication.java
public class TextEditorApplication {
    public static void main(String[] args) {
        // Create a new document
        Document doc = new Document();

        // Create CharacterStyle instances via the factory
        CharacterStyle style1 = CharacterStyleFactory.getStyle("Arial", 12, "Red");
        CharacterStyle style2 = CharacterStyleFactory.getStyle("Calibri", 14, "Blue");
        CharacterStyle style3 = CharacterStyleFactory.getStyle("Verdana", 16, "Black");
        CharacterStyle style4 = CharacterStyleFactory.getStyle("Arial", 12, "Blue");

        String text = "HelloWorldCS5800";

        // Assign styles to characters to have at least 4 variations
        // H e l l o
        for (int i = 0; i < 5; i++) {
            doc.addCharacter(text.charAt(i), style1);
        }

        // W o r l d
        for (int i = 5; i < 10; i++) {
            doc.addCharacter(text.charAt(i), style2);
        }

        // C S
        for (int i = 10; i < 12; i++) {
            doc.addCharacter(text.charAt(i), style3);
        }

        // 5 8 0 0
        for (int i = 12; i < text.length(); i++) {
            doc.addCharacter(text.charAt(i), style4);
        }

        // Save the document
        try {
            doc.saveToFile("document.txt");
            System.out.println("Document saved to document.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load the document
        Document loadedDoc = new Document();
        try {
            loadedDoc.loadFromFile("document.txt");
            System.out.println("Document loaded from document.txt");

            // Display loaded characters and their styles
            for (Character character : loadedDoc.getCharacters()) {
                System.out.println("Character: " + character.getChar() +
                        ", Font: " + character.getStyle().getFont() +
                        ", Size: " + character.getStyle().getSize() +
                        ", Color: " + character.getStyle().getColor());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

