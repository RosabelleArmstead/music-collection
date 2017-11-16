/**
 * DAOFactoryTest.java
 */
package ra00528.music.catalogue.com1028.dao;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests DAO Factory.
 * 
 * @author Rosabelle Armstead
 *
 */
public class DAOFactoryTest {

	/**
	 * Tests DAOFactory constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstructor() throws Exception {
		DAOFactory result = new DAOFactory();
		assertNotNull(result);
	}

	/**
	 * tests getSongDAO method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetSongDAO() throws Exception {

		SongDAO result = DAOFactory.getSongDAO();

		assertNotNull(result);
	}

}
