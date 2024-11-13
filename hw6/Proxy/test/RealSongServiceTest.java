// RealSongServiceTest.java
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class RealSongServiceTest {

    private RealSongService realSongService;

    @Before
    public void setUp() {
        realSongService = new RealSongService();
    }

    @Test
    public void testSearchById_ExistingSong() {
        Song song = realSongService.searchById(1);
        assertNotNull("Song should not be null", song);
        assertEquals("Song ID should be 1", Integer.valueOf(1), song.getSongID());
    }

    @Test
    public void testSearchById_NonExistingSong() {
        Song song = realSongService.searchById(999);
        assertNull("Song should be null for non-existing ID", song);
    }

    @Test
    public void testSearchByTitle_ExistingTitle() {
        List<Song> songs = realSongService.searchByTitle("Song A");
        assertNotNull("Songs list should not be null", songs);
        assertFalse("Songs list should not be empty", songs.isEmpty());
        assertEquals("Title should be 'Song A'", "Song A", songs.get(0).getTitle());
    }

    @Test
    public void testSearchByTitle_NonExistingTitle() {
        List<Song> songs = realSongService.searchByTitle("Nonexistent Title");
        assertNotNull("Songs list should not be null", songs);
        assertTrue("Songs list should be empty for nonexistent title", songs.isEmpty());
    }

    @Test
    public void testSearchByAlbum_ExistingAlbum() {
        List<Song> songs = realSongService.searchByAlbum("Album X");
        assertNotNull("Songs list should not be null", songs);
        assertFalse("Songs list should not be empty", songs.isEmpty());
        assertEquals("Album should be 'Album X'", "Album X", songs.get(0).getAlbum());
    }

    @Test
    public void testSearchByAlbum_NonExistingAlbum() {
        List<Song> songs = realSongService.searchByAlbum("Nonexistent Album");
        assertNotNull("Songs list should not be null", songs);
        assertTrue("Songs list should be empty for nonexistent album", songs.isEmpty());
    }
}
