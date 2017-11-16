/**
 * SearchUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Test;

import ra00528.music.catalogue.com1028.SearchUI;
import ra00528.music.catalogue.com1028.Song;
import ra00528.music.catalogue.com1028.dao.DAOFactory;
import ra00528.music.catalogue.com1028.dao.SongDAO;

/**
 * Tests Search UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class SearchUITest {

	private SongDAO songDAO = null;

	private List<Song> songs = new ArrayList<Song>();

	/**
	 * Test search matches title
	 */
	@Test
	public void testSearchUI1() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Rumour Has It", "21", "Adele", "Jazz", "Vinyl");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getTitle().equals("Rumour Has It")) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search matches album
	 */
	@Test
	public void testSearchUI2() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Rumour Has It", "21", "Adele", "Jazz", "Vinyl");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getAlbum().equals("21")) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search matches artist
	 */
	@Test
	public void testSearchUI3() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Heart Starts Beating", "Heart Starts Beating - Single", "Coasts", "Alternative", "Digital");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getArtist().equals("Coasts")) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search matches genre
	 */
	@Test
	public void testSearchUI4() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Rock the Casbah", "Combat Rock", "The Clash", "Rock", "Vinyl");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getGenre().equals("Rock")) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search matches format
	 */
	@Test
	public void testSearchUI5() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Rock the Casbah", "Combat Rock", "The Clash", "Rock", "CD");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getFormat().equals("CD")) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search file exists
	 */
	@Test
	public void testSearchUI7() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Heart Starts Beating", "Heart Starts Beating - Single", "Coasts",
				"Alternative", "Digital");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getFilepath() != null) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Test search file doesn't exist
	 */
	@Test
	public void testSearchUI8() {

		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}

		songDAO.openConnection();

		songs = songDAO.searchCatalogue("Rumour Has It", "21", "Adele", "Jazz", "Vinyl");

		songDAO.closeConnection();

		Boolean searchSuccess = false;

		for (Song s : songs) {
			if (s.getFilepath() == null) {
				searchSuccess = true;
			}
		}

		assertTrue(searchSuccess);

	}

	/**
	 * Tests getFrame method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetFrame() throws Exception {

		SearchUI fixture = new SearchUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
