/**
 * catalogueTableModelTest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * Tests Catalogue Table Model.
 * 
 * @author Rosabelle Armstead
 *
 */
public class catalogueTableModelTest {

	/**
	 * Tests CatalogueTableModel constructor
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testConstructor() throws Exception {
		List<Song> song = new ArrayList<Song>();

		catalogueTableModel result = new catalogueTableModel(song);

		assertNotNull(result);
		assertEquals(0, result.getRowCount());
		assertEquals(5, result.getColumnCount());
	}

	/**
	 * Tests getColumnCount method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetColumnCount() throws Exception {
		catalogueTableModel fixture = new catalogueTableModel(new ArrayList<Song>());

		int result = fixture.getColumnCount();

		assertEquals(5, result);
	}

	/**
	 * Tests getColumnName method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetColumnName() throws Exception {
		catalogueTableModel fixture = new catalogueTableModel(new ArrayList<Song>());
		int column = 1;

		String result = fixture.getColumnName(column);

		assertEquals("Album", result);
	}

	/**
	 * Tests getRowCount method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetRowCount() throws Exception {
		catalogueTableModel fixture = new catalogueTableModel(new ArrayList<Song>());

		int result = fixture.getRowCount();

		assertEquals(0, result);
	}

}
