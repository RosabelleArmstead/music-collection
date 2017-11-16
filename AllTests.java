/**
 * AllTests.java
 */
package ra00528.music.catalogue.com1028;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ra00528.music.catalogue.com1028.dao.DAOFactoryTest;
import ra00528.music.catalogue.com1028.dao.SongDAOImplTest;
/**
 * Runs all tests.
 * 
 * @author Rosabelle Armstead
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AddSongUITest.class, catalogueTableModelTest.class,
		DAOFactoryTest.class, DeleteSongUITest.class, MediaPlayerUITest.class, 
		MP3PlayerTest.class, MusicCollectionCatalogueUITest.class, SearchUITest.class,
		SongTest.class, SongDAOImplTest.class, UpdateSongUITest.class })
public class AllTests {
}
