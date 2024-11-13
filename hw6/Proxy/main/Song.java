// Song.java
public class Song {
    private Integer songID;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(Integer songID, String title, String artist, String album, int duration) {
        this.songID = songID;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    // Getters and setters
    public Integer getSongID() { return songID; }
    public void setSongID(Integer songID) { this.songID = songID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String toString() {
        return "Song [songID=" + songID + ", title=" + title + ", artist=" + artist +
                ", album=" + album + ", duration=" + duration + "]";
    }
}
