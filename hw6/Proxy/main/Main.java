// Main.java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongService songService = new ProxySongService();

        System.out.println("First search by ID (should fetch from server with delay):");
        long startTime = System.currentTimeMillis();
        Song song = songService.searchById(1);
        System.out.println(song);
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");

        System.out.println("Second search by ID (should fetch from cache):");
        startTime = System.currentTimeMillis();
        song = songService.searchById(1);
        System.out.println(song);
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");

        System.out.println("Search by Title 'Song A' (should fetch from server with delay):");
        startTime = System.currentTimeMillis();
        List<Song> songs = songService.searchByTitle("Song A");
        for (Song s : songs) {
            System.out.println(s);
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");

        System.out.println("Search by Title 'Song A' again (should fetch from cache):");
        startTime = System.currentTimeMillis();
        songs = songService.searchByTitle("Song A");
        for (Song s : songs) {
            System.out.println(s);
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");

        System.out.println("Search by Album 'Album X' (should fetch from server with delay):");
        startTime = System.currentTimeMillis();
        songs = songService.searchByAlbum("Album X");
        for (Song s : songs) {
            System.out.println(s);
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");

        System.out.println("Search by Album 'Album X' again (should fetch from cache):");
        startTime = System.currentTimeMillis();
        songs = songService.searchByAlbum("Album X");
        for (Song s : songs) {
            System.out.println(s);
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + " ms\n");
    }
}

