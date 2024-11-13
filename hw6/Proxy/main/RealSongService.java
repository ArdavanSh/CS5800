// RealSongService.java
import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private List<Song> songDatabase;

    public RealSongService() {
        // Son Database
        songDatabase = new ArrayList<>();
        songDatabase.add(new Song(1, "Song A", "Artist 1", "Album X", 210));
        songDatabase.add(new Song(2, "Song B", "Artist 2", "Album Y", 180));
        songDatabase.add(new Song(3, "Song C", "Artist 1", "Album X", 200));
        songDatabase.add(new Song(4, "Song D", "Artist 3", "Album Z", 240));
        songDatabase.add(new Song(5, "Song E", "Artist 2", "Album Y", 230));
        songDatabase.add(new Song(6, "Song F", "Artist 4", "Album W", 220));
        songDatabase.add(new Song(7, "Song G", "Artist 5", "Album V", 190));
        songDatabase.add(new Song(8, "Song H", "Artist 1", "Album U", 205));
        songDatabase.add(new Song(9, "Song I", "Artist 3", "Album T", 215));
        songDatabase.add(new Song(10, "Song J", "Artist 6", "Album S", 225));
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkDelay();
        for (Song song : songDatabase) {
            if (song.getSongID().equals(songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                result.add(song);
            }
        }
        return result;
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // Handle exception
        }
    }
}
