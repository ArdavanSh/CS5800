import java.util.ArrayList;
import java.util.List;

class BookDeepCopy extends Book {

    public BookDeepCopy(String title, String author, List<String> chapters) {
        super(title, author, chapters);
    }

    // Deep copy
    @Override
    protected BookDeepCopy clone() throws CloneNotSupportedException {
        BookDeepCopy clonedBook = (BookDeepCopy) super.clone();
        List<String> clonedChapters = new ArrayList<>(getChapters());
        clonedBook.setChapters(clonedChapters);
        return clonedBook;
    }
}

