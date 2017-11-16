/**
 * MediaPlayerUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
/**
 * Tests Media Player UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class MediaPlayerUITest {

	/**
	 * Tests MediaPlayerUI constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		MediaPlayerUI result = new MediaPlayerUI();

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

		MediaPlayerUI fixture = new MediaPlayerUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
