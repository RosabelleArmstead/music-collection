/**
 * catalogueTableModel.java
 */
package ra00528.music.catalogue.com1028;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Defines the properties and behaviour of the Catalogue Table Model.
 * 
 * @author Rosabelle Armstead
 *
 */
public class catalogueTableModel extends AbstractTableModel {
	/** database columns */
	private static final int TITLE_COLUMN = 0;
	private static final int ALBUM_COLUMN = 1;
	private static final int ARTIST_COLUMN = 2;
	private static final int GENRE_COLUMN = 3;
	private static final int FORMAT_COLUMN = 4;
	
	private static final long serialVersionUID = 1L;
	/** column names for the table model */
	private String[] columnNames = { "Title", "Album", "Artist", "Genre", "Format"};
	/** data for the table model */
	private List<Song> songs = new ArrayList<Song>();
	
	/**
	 * Constructor for the table model
	 * 
	 * @param songs
	 */
	public catalogueTableModel(List<Song> songs) {
		this.songs = songs;
	}
	
	/**
	 * gets number of columns
	 * 
	 * @return number of columns
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	/**
	 * gets name of column at index col
	 * 
	 * @param col
	 * @return column name
	 */
	public String getColumnName(int col) {
	      return columnNames[col];
	    }

	/**
	 * gets number of rows
	 * 
	 * @return number of rows
	 */
	@Override
	public int getRowCount() {
		return songs.size();
	}
	
	/**
	 * gets value at given point in table
	 * 
	 * @param row
	 * @param col
	 * 
	 * @return song object value
	 */
	@Override
	public Object getValueAt(int row, int col) {
		
		Song tempSong = songs.get(row);
		
		switch(col) {
		case TITLE_COLUMN:
			return tempSong.getTitle();
		case ALBUM_COLUMN:
			return tempSong.getAlbum();
		case ARTIST_COLUMN:
			return tempSong.getArtist();
		case GENRE_COLUMN:
			return tempSong.getGenre();
		case FORMAT_COLUMN:
			return tempSong.getFormat();
		}
		return null;
	}
}
