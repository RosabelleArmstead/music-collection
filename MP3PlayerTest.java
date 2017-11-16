/**
 * MP3PlayerTest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests MP3 Player.
 * 
 * @author Rosabelle Armstead
 *
 */
public class MP3PlayerTest {

	/**
	 * Tests MP3Player constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		MP3Player result = new MP3Player();

		assertNotNull(result);
	}

}
