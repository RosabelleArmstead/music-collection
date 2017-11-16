/**
 * SearchUI.java
 */
package ra00528.music.catalogue.com1028;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ra00528.music.catalogue.com1028.dao.DAOFactory;
import ra00528.music.catalogue.com1028.dao.SongDAO;

/**
 * Defines the properties and behaviour of the SearchUI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class SearchUI {
	/** The UI components */
	private JFrame frame;
	private JTextField txtBoxTitle;
	private JTextField txtBoxAlbum;
	private JTextField txtBoxArtist;
	/** the song DAO */
	private SongDAO songDAO = null;

	/**
	 * Launch application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchUI window = new SearchUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Connect to database and initialise contents of frame
	 */
	public SearchUI() {
		try {
			songDAO = DAOFactory.getSongDAO();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (songDAO != null) {
				songDAO.closeConnection();
			}
		}
		initialize();
	}

	/**
	 * Initialise contents of frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(1, 1, 1600, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMusicCollectionCatalogue = new JLabel("Music Collection Catalogue");
		lblMusicCollectionCatalogue.setBounds(0, 30, 1578, 54);
		lblMusicCollectionCatalogue.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMusicCollectionCatalogue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicCollectionCatalogue.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(lblMusicCollectionCatalogue);

		JLabel lblSongTitle = new JLabel("Title:");
		lblSongTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSongTitle.setBounds(478, 176, 114, 34);
		frame.getContentPane().add(lblSongTitle);

		JLabel lblAlbum = new JLabel("Album:");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAlbum.setBounds(478, 226, 114, 34);
		frame.getContentPane().add(lblAlbum);

		JLabel lblArtist = new JLabel("Artist:");
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblArtist.setBounds(478, 276, 114, 34);
		frame.getContentPane().add(lblArtist);

		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGenre.setBounds(478, 326, 114, 34);
		frame.getContentPane().add(lblGenre);

		JLabel lblFormat = new JLabel("Format:");
		lblFormat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFormat.setBounds(478, 376, 114, 34);
		frame.getContentPane().add(lblFormat);

		txtBoxTitle = new JTextField();
		txtBoxTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtBoxTitle.setBounds(578, 177, 534, 33);
		frame.getContentPane().add(txtBoxTitle);
		txtBoxTitle.setColumns(10);

		txtBoxAlbum = new JTextField();
		txtBoxAlbum.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtBoxAlbum.setColumns(10);
		txtBoxAlbum.setBounds(578, 227, 534, 33);
		frame.getContentPane().add(txtBoxAlbum);

		txtBoxArtist = new JTextField();
		txtBoxArtist.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtBoxArtist.setColumns(10);
		txtBoxArtist.setBounds(578, 277, 534, 33);
		frame.getContentPane().add(txtBoxArtist);

		JLabel lblSearchCatalogue = new JLabel("Search Catalogue");
		lblSearchCatalogue.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSearchCatalogue.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSearchCatalogue.setBounds(478, 100, 444, 41);
		frame.getContentPane().add(lblSearchCatalogue);

		JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(new DefaultComboBoxModel(new String[] { "Alternative", "Blues", "Country", "Electronic",
				"Folk", "Hip Hop", "Indie", "Jazz", "Latin", "Pop", "R&B", "Rock", "Other" }));
		comboBoxGenre.setBounds(578, 329, 534, 34);
		frame.getContentPane().add(comboBoxGenre);

		JComboBox comboBoxFormat = new JComboBox();
		comboBoxFormat.setModel(new DefaultComboBoxModel(new String[] { "Cassette", "CD", "Digital", "Vinyl" }));
		comboBoxFormat.setBounds(578, 379, 534, 34);
		frame.getContentPane().add(comboBoxFormat);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			/**
			 * Connect to database and run search catalogue method using text in
			 * input fields and combo boxes as parameters
			 */
			public void actionPerformed(ActionEvent arg0) {
				songDAO.openConnection();

				String title = null;
				String album = null;
				String artist = null;
				String genre = null;
				String format = null;

				List<Song> songs = null;

				title = txtBoxTitle.getText();
				album = txtBoxAlbum.getText();
				artist = txtBoxArtist.getText();
				genre = (String) comboBoxGenre.getSelectedItem();
				format = (String) comboBoxFormat.getSelectedItem();
				// refresh the table in Music Collection Catalogue UI with the
				// results of the search
				songs = songDAO.searchCatalogue(title, album, artist, genre, format);

				MusicCollectionCatalogueUI.refreshTable(songs);
				songDAO.closeConnection();

				frame.dispose();
			}
		});
		btnSearch.setBounds(918, 429, 193, 54);
		frame.getContentPane().add(btnSearch);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			/**
			 * if cancel button clicked, close the Add Song UI window
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(478, 429, 193, 54);
		frame.getContentPane().add(btnCancel);
	}
	
	/**
	 * gets frame so that Search UI window can be opened from 
	 * Music Collection Catalogue UI
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

}
