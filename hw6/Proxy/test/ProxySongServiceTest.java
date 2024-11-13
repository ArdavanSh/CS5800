// ProxySongServiceTest.java
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ProxySongServiceTest {

    private SongService proxySongService;

    @Before
    public void setUp() {
        proxySongService = new ProxySongService();
    }

    @Test
    public void testSearchById_Caching() {
        // First call - should fetch from server and take longer
        long startTime = System.currentTimeMillis();
        Song song1 = proxySongService.searchById(1);
        long duration1 = System.currentTimeMillis() - startTime;

        assertNotNull("Song should not be null on first fetch", song1);
        assertEquals("Song ID should be 1", Integer.valueOf(1), song1.getSongID());
        assertTrue("First fetch should take at least 1000 ms due to delay", duration1 >= 1000);

        // Second call - should fetch from cache and be faster
        startTime = System.currentTimeMillis();
        Song song2 = proxySongService.searchById(1);
        long duration2 = System.currentTimeMillis() - startTime;

        assertNotNull("Song should not be null on second fetch", song2);
        assertEquals("Song ID should be 1", Integer.valueOf(1), song2.getSongID());
        assertTrue("Second fetch should be faster than first fetch", duration2 < duration1);
        assertTrue("Second fetch should be significantly faster (e.g., less than 100 ms)", duration2 < 100);
    }

    @Test
    public void testSearchByTitle_Caching() {
        // First call - should fetch from server and take longer
        long startTime = System.currentTimeMillis();
        List<Song> songs1 = proxySongService.searchByTitle("Song A");
        long duration1 = System.currentTimeMillis() - startTime;

        assertNotNull("Songs list should not be null on first fetch", songs1);
        assertFalse("Songs list should not be empty on first fetch", songs1.isEmpty());
        assertTrue("First fetch should take at least 1000 ms due to delay", duration1 >= 1000);

        // Second call - should fetch from cache and be faster
        startTime = System.currentTimeMillis();
        List<Song> songs2 = proxySongService.searchByTitle("Song A");
        long duration2 = System.currentTimeMillis() - startTime;

        assertNotNull("Songs list should not be null on second fetch", songs2);
        assertFalse("Songs list should not be empty on second fetch", songs2.isEmpty());
        assertTrue("Second fetch should be faster than first fetch", duration2 < duration1);
        assertTrue("Second fetch should be significantly faster (e.g., less than 100 ms)", duration2 < 100);
    }

    @Test
    public void testSearchByAlbum_Caching() {
        // First call - should fetch from server and take longer
        long startTime = System.currentTimeMillis();
        List<Song> songs1 = proxySongService.searchByAlbum("Album X");
        long duration1 = System.currentTimeMillis() - startTime;

        assertNotNull("Songs list should not be null on first fetch", songs1);
        assertFalse("Songs list should not be empty on first fetch", songs1.isEmpty());
        assertTrue("First fetch should take at least 1000 ms due to delay", duration1 >= 1000);

        // Second call - should fetch from cache and be faster
        startTime = System.currentTimeMillis();
        List<Song> songs2 = proxySongService.searchByAlbum("Album X");
        long duration2 = System.currentTimeMillis() - startTime;

        assertNotNull("Songs list should not be null on second fetch", songs2);
        assertFalse("Songs list should not be empty on second fetch", songs2.isEmpty());
        assertTrue("Second fetch should be faster than first fetch", duration2 < duration1);
        assertTrue("Second fetch should be significantly faster (e.g., less than 100 ms)", duration2 < 100);
    }

    @Test
    public void testCaseInsensitiveSearch() {
        // First call with mixed case
        Song song1 = proxySongService.searchById(1);
        assertNotNull("Song should not be null", song1);

        // Search by title with different case
        List<Song> songs = proxySongService.searchByTitle("sOnG a");
        assertNotNull("Songs list should not be null", songs);
        assertFalse("Songs list should not be empty", songs.isEmpty());
        assertEquals("Title should be 'Song A'", "Song A", songs.get(0).getTitle());
    }

    @Test
    public void testCacheConsistency() {
        // Fetch by title
        List<Song> songsByTitle = proxySongService.searchByTitle("Song B");
        assertNotNull("Songs list should not be null", songsByTitle);
        assertFalse("Songs list should not be empty", songsByTitle.isEmpty());

        // Fetch by ID
        Song songById = proxySongService.searchById(songsByTitle.get(0).getSongID());
        assertNotNull("Song should not be null", songById);

        // Ensure that both songs are the same
        assertEquals("Song IDs should match", songsByTitle.get(0).getSongID(), songById.getSongID());
        assertEquals("Titles should match", songsByTitle.get(0).getTitle(), songById.getTitle());
    }
}

