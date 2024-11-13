// Document.java
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, CharacterStyle style) {
        characters.add(new Character(c, style));
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for (Character character : characters) {
            char c = character.getChar();
            CharacterStyle style = character.getStyle();
            // Save as c,font,size,color
            writer.write(c + "," + style.getFont() + "," + style.getSize() + "," + style.getColor());
            writer.newLine();
        }

        writer.close();
    }

    public void loadFromFile(String filename) throws IOException {
        characters.clear();

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            // Each line is c,font,size,color
            String[] parts = line.split(",");
            if (parts.length != 4) continue;

            char c = parts[0].charAt(0);
            String font = parts[1];
            int size = Integer.parseInt(parts[2]);
            String color = parts[3];

            CharacterStyle style = CharacterStyleFactory.getStyle(font, size, color);
            addCharacter(c, style);
        }

        reader.close();
    }
}

