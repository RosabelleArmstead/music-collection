/**
 * SongTest.java
 */
package ra00528.music.catalogue.com1028;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests song object.
 * 
 * @author Rosabelle Armstead
 *
 */
public class SongTest {

	/**
	 * Tests Song constructor
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testConstructor() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song result = new Song(title, album, artist, genre, format,
				filepath);

		assertNotNull(result);
		assertEquals("title", result.getTitle());
		assertEquals("album", result.getAlbum());
		assertEquals("artist", result.getArtist());
		assertEquals("genre", result.getGenre());
		assertEquals("format", result.getFormat());
		assertEquals("filepath", result.getFilepath());
	}
	
	/**
	 * Tests getTitle method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetTitle() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getTitle();

		assertEquals("title", result);
	}

	/**
	 * Tests getAlbum method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetAlbum() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getAlbum();

		assertEquals("album", result);
	}

	/**
	 * Tests getArtist method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetArtist() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getArtist();

		assertEquals("artist", result);
	}
	
	/**
	 * Tests getGenre method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetGenre() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getGenre();

		assertEquals("genre", result);
	}

	/**
	 * Tests getMedia method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetFormat() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getFormat();

		assertEquals("format", result);
	}
	
	/**
	 * Tests getFilepath method
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetFilepath() throws Exception {
		String title = "title";
		String album = "album";
		String artist = "artist";
		String genre = "genre";
		String format = "format";
		String filepath = "filepath";

		Song song = new Song(title, album, artist, genre, format,
				filepath);

		String result = song.getFilepath();

		assertEquals("filepath", result);
	}


}
