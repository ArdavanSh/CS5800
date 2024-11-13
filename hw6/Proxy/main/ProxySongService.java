// ProxySongService.java
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ProxySongService implements SongService {
    private RealSongService realSongService;

    // Caches
    private Map<Integer, Song> songCacheById;
    private Map<String, List<Song>> songCacheByTitle;
    private Map<String, List<Song>> songCacheByAlbum;

    public ProxySongService() {
        realSongService = new RealSongService();
        songCacheById = new HashMap<>();
        songCacheByTitle = new HashMap<>();
        songCacheByAlbum = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (songCacheById.containsKey(songID)) {
            System.out.println("Fetching song by ID from cache...");
            return songCacheById.get(songID);
        } else {
            System.out.println("Fetching song by ID from server...");
            Song song = realSongService.searchById(songID);
            if (song != null) {
                songCacheById.put(songID, song);
            }
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title.toLowerCase();
        if (songCacheByTitle.containsKey(key)) {
            System.out.println("Fetching songs by title from cache...");
            return songCacheByTitle.get(key);
        } else {
            System.out.println("Fetching songs by title from server...");
            List<Song> songs = realSongService.searchByTitle(title);
            songCacheByTitle.put(key, songs);
            for (Song song : songs) {
                songCacheById.put(song.getSongID(), song);
            }
            return songs;
        }
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album.toLowerCase();
        if (songCacheByAlbum.containsKey(key)) {
            System.out.println("Fetching songs by album from cache...");
            return songCacheByAlbum.get(key);
        } else {
            System.out.println("Fetching songs by album from server...");
            List<Song> songs = realSongService.searchByAlbum(album);
            songCacheByAlbum.put(key, songs);
            for (Song song : songs) {
                songCacheById.put(song.getSongID(), song);
            }
            return songs;
        }
    }
}
