// CharacterStyleFactory.java
import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private static Map<CharacterStyle, CharacterStyle> styles = new HashMap<>();

    public static CharacterStyle getStyle(String font, int size, String color) {
        CharacterStyle newStyle = new CharacterStyle(font, size, color);
        CharacterStyle existingStyle = styles.get(newStyle);

        if (existingStyle == null) {
            styles.put(newStyle, newStyle);
            return newStyle;
        } else {
            return existingStyle;
        }
    }
}
