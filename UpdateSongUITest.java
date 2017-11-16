/**
 * UpdateSongUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
/**
 * Tests Update Song UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class UpdateSongUITest {

	/**
	 * Tests UpdateSongUI constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		UpdateSongUI result = new UpdateSongUI();
		
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

		UpdateSongUI fixture = new UpdateSongUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
