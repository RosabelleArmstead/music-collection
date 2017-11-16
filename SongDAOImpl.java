/**
 * SongDAOImpl.java
 */
package ra00528.music.catalogue.com1028.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ra00528.music.catalogue.com1028.Song;

/**
 * Defines the properties and behaviour of the Song DAO implementation.
 * 
 * @author Rosabelle Armstead
 *
 */
public class SongDAOImpl implements SongDAO {

	/** connection to database */
	private Connection connect;
	/** SQL statement */
	private Statement statement;

	/**
	 * constructor for Song DAO implementation
	 */
	public SongDAOImpl() {
		super();
		this.connect = null;
		this.statement = null;
		this.openConnection();
	}

	@Override
	public void openConnection() {
		try {
			// recreate connection
			if (this.connect == null || this.connect.isClosed()) {
				// change database path
				this.connect = DriverManager.getConnection(
						"jdbc:hsqldb:ra00528_music_catalogue_com1028/ra00528_music_catalogue_com1028/db_data/myDBfilestore;ifexists=true;shutdown=true",
						"ra00528", "");
			}
			// recreate statement
			if (this.statement == null || this.statement.isClosed()) {
				this.statement = this.connect.createStatement();
			}

		} catch (SQLException e) {
			System.out.println("Connection to database failed");
			throw new RuntimeException(e);
		}
	}

	@Override
	public void closeConnection() {

		try {
			if (this.statement != null) {
				this.statement.close();
			}
			if (this.connect != null) {
				this.connect.close();
			}
			System.out.println("Database connection closed");
		} catch (Exception e) {
			System.out.print("Failed to close database connection");
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Song> getSongs() {
		ArrayList<Song> songs = new ArrayList<Song>();
		try {
			// prepared query selects everything from song table
			String query = "SELECT * FROM song";
			// execute query and store results
			ResultSet results = this.statement.executeQuery(query);
			// iterate through results and convert each row to song object and
			// add to list of songs
			while (results.next()) {
				songs.add(convertRowToObject(results));
			}

		} catch (SQLException e) {
			System.out.println("SQLException when retrieving records - abort");
			throw new RuntimeException(e);
		}
		// return results as list of song
		return songs;
	}

	@Override
	public void addSong(Song song) {
		try {
			// prepared statement to add variables to query
			PreparedStatement preparedStatement = this.connect.prepareStatement(
					"INSERT INTO song (title, album, artist, genre, format, filepath) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, song.getTitle());
			preparedStatement.setString(2, song.getAlbum());
			preparedStatement.setString(3, song.getArtist());
			preparedStatement.setString(4, song.getGenre());
			preparedStatement.setString(5, song.getFormat());
			preparedStatement.setString(6, song.getFilepath());
			// execute query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException while writing a song - abort");
			throw new RuntimeException(e);
		}

	}

	@Override
	public void updateSong(String title, Song song) {
		try {

			// prepared statement to add variables to query
			PreparedStatement preparedStatement = this.connect.prepareStatement(
					"UPDATE song SET title = ?, album = ?, artist = ?, genre = ?, format = ?, filepath = ? WHERE title = '"
							+ title + "'");
			preparedStatement.setString(1, song.getTitle());
			preparedStatement.setString(2, song.getAlbum());
			preparedStatement.setString(3, song.getArtist());
			preparedStatement.setString(4, song.getGenre());
			preparedStatement.setString(5, song.getFormat());
			preparedStatement.setString(6, song.getFilepath());
			// execute query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException while updating a song - abort");
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Song> searchCatalogue(String title, String album, String artist, String genre, String format) {

		ArrayList<Song> songs = new ArrayList<Song>();

		ResultSet results = null;

		try {
			// prepared statement to add variables to query
			PreparedStatement preparedStatement = this.connect.prepareStatement(
					"SELECT * FROM song WHERE title LIKE ? OR album LIKE ? OR artist LIKE ? OR genre LIKE ? OR format LIKE ?");

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, album);
			preparedStatement.setString(3, artist);
			preparedStatement.setString(4, genre);
			preparedStatement.setString(5, format);
			// execute query
			results = preparedStatement.executeQuery();

			// iterate through results and convert each row to song object and
			// add to list of songs
			while (results.next()) {
				songs.add(convertRowToObject(results));
			}

		} catch (SQLException e) {
			System.out.println("SQLException happened while searching - abort");
			throw new RuntimeException(e);
		}
		return songs;
	}

	@Override
	public List<Song> isExisting(String title, String album, String artist, String genre, String format) {

		ArrayList<Song> songs = new ArrayList<Song>();

		ResultSet results = null;

		try {
			// prepared statement to add variables to query
			PreparedStatement preparedStatement = this.connect.prepareStatement(
					"SELECT * FROM song WHERE title LIKE ? AND album LIKE ? AND artist LIKE ? AND genre LIKE ? AND format LIKE ?");

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, album);
			preparedStatement.setString(3, artist);
			preparedStatement.setString(4, genre);
			preparedStatement.setString(5, format);
			// execute query
			results = preparedStatement.executeQuery();

			// iterate through results and convert each row to song object and
			// add to list of songs
			while (results.next()) {
				songs.add(convertRowToObject(results));
			}

		} catch (SQLException e) {
			System.out.println("SQLException happened while searching for existing entries - abort");
			throw new RuntimeException(e);
		}
		return songs;
	}

	@Override
	public Song convertRowToObject(ResultSet results) {

		Song tempSong = null;
		try {
			String title = results.getString("title");
			String album = results.getString("album");
			String artist = results.getString("artist");
			String genre = results.getString("genre");
			String format = results.getString("format");
			String filepath = results.getString("filepath");
			// create song object from results row
			tempSong = new Song(title, album, artist, genre, format, filepath);

		} catch (SQLException e) {
			System.out.println("SQLException when retrieving records - abort");
			throw new RuntimeException(e);
		}

		return tempSong;
	}

	@Override
	public void deleteSong(String title, String album, String artist, String genre, String format) {

		try {
			// prepared statement to add variables to query
			PreparedStatement preparedStatement = this.connect.prepareStatement(
					"DELETE FROM song WHERE title = ? AND album = ? AND artist = ? AND genre = ? AND format = ?");

			preparedStatement.setString(1, title);
			preparedStatement.setString(2, album);
			preparedStatement.setString(3, artist);
			preparedStatement.setString(4, genre);
			preparedStatement.setString(5, format);
			// execute query
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQLException while deleting a song entry - abort");
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Song> orderCatalogue(String orderby) {

		ArrayList<Song> songs = new ArrayList<Song>();
		ResultSet results = null;

		try {
			if (orderby == "Title") {
				String query = "SELECT * FROM song ORDER BY title";
				results = this.statement.executeQuery(query);
			}
			if (orderby == "Album") {
				String query = "SELECT * FROM song ORDER BY album";
				results = this.statement.executeQuery(query);
			}
			if (orderby == "Artist") {
				String query = "SELECT * FROM song ORDER BY artist";
				results = this.statement.executeQuery(query);
			}
			if (orderby == "Genre") {
				String query = "SELECT * FROM song ORDER BY genre";
				results = this.statement.executeQuery(query);
			}
			if (orderby == "Format") {
				String query = "SELECT * FROM song ORDER BY format";
				results = this.statement.executeQuery(query);
			}

			// iterate through results and convert each row to song object and
			// add to list of songs
			while (results.next()) {
				songs.add(convertRowToObject(results));
			}
		} catch (SQLException e) {
			System.out.println("SQLException while ordering - abort");
			throw new RuntimeException(e);
		}
		return songs;
	}

}
