/**
 * MusicCollectionCatalogueUITest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
/**
 * Tests Music Collection Catalogue UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class MusicCollectionCatalogueUITest {

	/**
	 * Tests MusicCollectionCatalogueUI constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstruction() throws Exception {

		MusicCollectionCatalogueUI result = new MusicCollectionCatalogueUI();

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

		MusicCollectionCatalogueUI fixture = new MusicCollectionCatalogueUI();

		JFrame result = fixture.getFrame();

		assertNotNull(result);
	}

}
