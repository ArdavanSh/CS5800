import java.util.List;

class BookShallowCopy extends Book {

    public BookShallowCopy(String title, String author, List<String> chapters) {
        super(title, author, chapters);
    }

    // Shallow copy
    @Override
    protected BookShallowCopy clone() throws CloneNotSupportedException {
        return (BookShallowCopy) super.clone();
    }
}


