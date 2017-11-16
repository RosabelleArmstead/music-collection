/**
 * DeleteSongUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
/**
 * Tests Delete Song UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class DeleteSongUITest {

	/**
	 * Tests DeleteSongUI constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		DeleteSongUI result = new DeleteSongUI();

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

		DeleteSongUI fixture = new DeleteSongUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
