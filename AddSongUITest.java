/**
 * AddSongUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
/**
 * Tests Add Song UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class AddSongUITest {

	/**
	 * Tests AddSongUI constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		AddSongUI result = new AddSongUI();

		assertNotNull(result);

	}

	/**
	 * Tests getFrame method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetFrame() throws Exception {

		AddSongUI fixture = new AddSongUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
