import java.util.ArrayList;
import java.util.List;

public class PrototypeDemo {
    public static void main(String[] args) {
        // Part 2: Shallow Copy
        List<String> chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        chapters.add("Chapter 2");

        BookShallowCopy originalShallow = new BookShallowCopy("Original Title", "Author A", chapters);
        try {
            BookShallowCopy cloneShallow = originalShallow.clone();

            // Modify the chapters
            originalShallow.getChapters().add("Chapter 3");

            System.out.println("Shallow Copy Test:");
            System.out.println("Original Shallow Book: " + originalShallow);
            System.out.println("Cloned Shallow Book: " + cloneShallow);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Part 3: Deep Copy
        List<String> deepChapters = new ArrayList<>();
        deepChapters.add("Chapter A");
        deepChapters.add("Chapter B");

        BookDeepCopy originalDeep = new BookDeepCopy("Original Deep Title", "Author B", deepChapters);
        try {
            BookDeepCopy cloneDeep = originalDeep.clone();

            // Modify the chapters
            originalDeep.getChapters().add("Chapter C");

            System.out.println("\nDeep Copy Test:");
            System.out.println("Original Deep Book: " + originalDeep);
            System.out.println("Cloned Deep Book: " + cloneDeep);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

