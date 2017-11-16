/**
 * SongDAOImplTest.java
 */
package ra00528.music.catalogue.com1028.dao;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.List;

import org.hsqldb.jdbc.JDBCResultSet;
import org.junit.Test;

import ra00528.music.catalogue.com1028.Song;
/**
 * Tests Song DAO Implementation.
 * 
 * @author Rosabelle Armstead
 *
 */
public class SongDAOImplTest {

	/**
	 * Tests SongDAOImpl constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstructor() throws Exception {

		SongDAOImpl result = new SongDAOImpl();

		assertNotNull(result);
	}

	/**
	 * tests ConvertRowToObject method
	 *
	 * @throws Exception
	 *
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testConvertRowToObject() throws Exception {
		SongDAOImpl fixture = new SongDAOImpl();
		ResultSet results = JDBCResultSet.newEptyResultSet();

		Song result = fixture.convertRowToObject(results);

		assertNotNull(result);
	}

	/**
	 * Tests getSongs method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetSongs() throws Exception {
		SongDAOImpl fixture = new SongDAOImpl();

		List<Song> result = fixture.getSongs();

		assertNotNull(result);
	}

	/**
	 * tests searchCatalogue method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testSearchCatalogue() throws Exception {
		SongDAOImpl fixture = new SongDAOImpl();
		String title = "";
		String album = "";
		String artist = "";
		String genre = "";
		String format = "";

		List<Song> result = fixture.searchCatalogue(title, album, artist, genre, format);

		assertNotNull(result);
	}

}
