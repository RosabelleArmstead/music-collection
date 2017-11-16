/**
 * DAOFactory.java
 */
package ra00528.music.catalogue.com1028.dao;

/**
 * Defines the properties and behaviour of the DAO factory.
 * 
 * @author Rosabelle Armstead
 *
 */
public class DAOFactory {
	/** singleton instance of SongDAOImpl */
	private static final SongDAO songDAO = new SongDAOImpl();
	
	/**
	 * gets SongDAO
	 * 
	 * @return SongDAO
	 */
	public static SongDAO getSongDAO() {
		return DAOFactory.songDAO;
	}

}
