// SongTest.java
import static org.junit.Assert.*;
import org.junit.Test;

public class SongTest {

    @Test
    public void testSongCreation() {
        Song song = new Song(1, "Test Title", "Test Artist", "Test Album", 300);
        assertNotNull("Song object should not be null", song);
    }

    @Test
    public void testGetters() {
        Song song = new Song(1, "Test Title", "Test Artist", "Test Album", 300);
        assertEquals("Song ID should be 1", Integer.valueOf(1), song.getSongID());
        assertEquals("Title should be 'Test Title'", "Test Title", song.getTitle());
        assertEquals("Artist should be 'Test Artist'", "Test Artist", song.getArtist());
        assertEquals("Album should be 'Test Album'", "Test Album", song.getAlbum());
        assertEquals("Duration should be 300", 300, song.getDuration());
    }

    @Test
    public void testSetters() {
        Song song = new Song(1, "Title", "Artist", "Album", 200);
        song.setSongID(2);
        song.setTitle("New Title");
        song.setArtist("New Artist");
        song.setAlbum("New Album");
        song.setDuration(250);

        assertEquals("Song ID should be 2", Integer.valueOf(2), song.getSongID());
        assertEquals("Title should be 'New Title'", "New Title", song.getTitle());
        assertEquals("Artist should be 'New Artist'", "New Artist", song.getArtist());
        assertEquals("Album should be 'New Album'", "New Album", song.getAlbum());
        assertEquals("Duration should be 250", 250, song.getDuration());
    }

    @Test
    public void testToString() {
        Song song = new Song(1, "Test Title", "Test Artist", "Test Album", 300);
        String expected = "Song [songID=1, title=Test Title, artist=Test Artist, album=Test Album, duration=300]";
        assertEquals("toString should return the correct format", expected, song.toString());
    }
}
