// CharacterStyle.java
public class CharacterStyle {
    private String font;
    private int size;
    private String color;

    public CharacterStyle(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    // Getters
    public String getFont() { return font; }
    public int getSize() { return size; }
    public String getColor() { return color; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterStyle that = (CharacterStyle) o;

        if (size != that.size) return false;
        if (!font.equals(that.font)) return false;
        return color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = font.hashCode();
        result = 31 * result + size;
        result = 31 * result + color.hashCode();
        return result;
    }
}
