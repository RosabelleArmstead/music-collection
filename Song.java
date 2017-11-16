/**
 * Song.java
 */
package ra00528.music.catalogue.com1028;
/**
 * Defines the properties and behaviour of a song.
 * 
 * @author Rosabelle Armstead
 *
 */
public class Song {
	/** title of the song */
	private String title;
	/** album of the song */
	private String album;
	/** artist of the song */
	private String artist;
	/** genre of the song */
	private String genre;
	/** format of the song */
	private String format;
	/** filepath of the song */
	private String filepath;
	
	/**
	 * Constructor for a song
	 * 
	 * @param title
	 * @param album
	 * @param artist
	 * @param genre
	 * @param format
	 * @param filepath
	 */
	public Song(String title, String album, String artist, String genre, String format, String filepath) {
		super();
		this.title = title;
		this.album = album;
		this.artist = artist;
		this.genre = genre;
		this.format = format;
		this.filepath = filepath;
	}
	
	/**
	 * gets song title
	 * 
	 * @return song title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * gets song album
	 * 
	 * @return album
	 */
	public String getAlbum() {
		return album;
	}
	
	/**
	 * gets song artist
	 * 
	 * @return artist
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * gets song genre
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
	
	/**
	 * gets song format
	 * 
	 * @return format
	 */
	public String getFormat() {
		return format;
	}
	
	/**
	 * gets song filepath
	 * 
	 * @return filepath
	 */
	public String getFilepath() {
		return filepath;
	}

}
