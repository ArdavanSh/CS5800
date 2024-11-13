// Character.java
public class Character {
    private char c;
    private CharacterStyle style;

    public Character(char c, CharacterStyle style) {
        this.c = c;
        this.style = style;
    }

    // Getters
    public char getChar() { return c; }
    public CharacterStyle getStyle() { return style; }
}
