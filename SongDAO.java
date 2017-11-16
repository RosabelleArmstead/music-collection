/**
 * SongDAO.java
 */
package ra00528.music.catalogue.com1028.dao;

import java.sql.ResultSet;
import java.util.List;

import ra00528.music.catalogue.com1028.Song;

/**
 * Defines the properties and behaviour of the Song DAO.
 * 
 * @author Rosabelle Armstead
 *
 */
public interface SongDAO {

	/**
	 * gets songs from the database
	 * 
	 * @return list of songs
	 */
	public List<Song> getSongs();

	/**
	 * adds song to database
	 * 
	 * @param song
	 */
	public void addSong(Song song);

	/**
	 * updates song chosen by user with field information input by user
	 * 
	 * @param title
	 * @param song
	 */
	public void updateSong(String title, Song song);

	/**
	 * Searches catalogue for songs matching information input by user
	 * 
	 * @param title
	 * @param album
	 * @param artist
	 * @param genre
	 * @param format
	 * 
	 * @return list of songs
	 */
	public List<Song> searchCatalogue(String title, String album, String artist, String genre, String format);

	/**
	 * checks to see if database already contains exact song input by user
	 * 
	 * @param title
	 * @param album
	 * @param artist
	 * @param genre
	 * @param format
	 * 
	 * @return list of songs
	 */
	public List<Song> isExisting(String title, String album, String artist, String genre, String format);

	/**
	 * deletes chosen song from database
	 * 
	 * @param title
	 * @param album
	 * @param artist
	 * @param genre
	 * @param format
	 */
	public void deleteSong(String title, String album, String artist, String genre, String format);

	/**
	 * sorts catalogue by chosen field
	 * 
	 * @param orderby
	 * 
	 * @return ordered list of songs
	 */
	public List<Song> orderCatalogue(String orderby);
	
	/**
	 * converts row of table to a song object
	 * 
	 * @param results
	 * 
	 * @return song object
	 */
	public Song convertRowToObject(ResultSet results);
	
	/**
	 * opens connection to database
	 */
	public void openConnection();

	/**
	 * closes connection to database
	 */
	public void closeConnection();

}
