/**
 * DeleteSongUI.java
 */
package ra00528.music.catalogue.com1028;

import java.awt.Component;
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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ra00528.music.catalogue.com1028.dao.DAOFactory;
import ra00528.music.catalogue.com1028.dao.SongDAO;

/**
 * Defines the properties and behaviour of the Delete Song UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class DeleteSongUI {
	/** The UI components */
	private JFrame frame;
	/** the song DAO */
	private SongDAO songDAO = null;
	/** the title of the song chosen to delete */
	private String songTitle = null;

	/**
	 * Launch application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSongUI window = new DeleteSongUI();
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
	public DeleteSongUI() {
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

		JLabel lblSong = new JLabel("Song:");
		lblSong.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSong.setBounds(478, 326, 114, 34);
		frame.getContentPane().add(lblSong);

		JLabel lblDeleteSong = new JLabel("Delete Song");
		lblDeleteSong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteSong.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDeleteSong.setBounds(673, 100, 249, 41);
		frame.getContentPane().add(lblDeleteSong);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			/**
			 * Connect to database and run delete song method using fields from
			 * song in the list that matches the song title given by the user to
			 * delete as parameters
			 */
			public void actionPerformed(ActionEvent e) {
				songDAO.openConnection();

				List<Song> songs = songDAO.getSongs();
				Song delete = null;

				String title = null;
				String album = null;
				String artist = null;
				String genre = null;
				String format = null;
				// iterate through list of songs and find song that matches song
				// title given by user
				for (Song song : songs) {
					if (songTitle.equals(song.getTitle())) {
						delete = song;
					}
				}

				title = delete.getTitle();
				album = delete.getAlbum();
				artist = delete.getArtist();
				genre = delete.getGenre();
				format = delete.getFormat();

				songDAO.deleteSong(title, album, artist, genre, format);
				// refresh the table in the Music Collection Catalogue UI with
				// the updated list of songs
				songs = songDAO.getSongs();
				MusicCollectionCatalogueUI.refreshTable(songs);
				songDAO.closeConnection();
				frame.dispose();
			}

		});
		btnConfirm.setBounds(919, 387, 193, 54);
		frame.getContentPane().add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			/**
			 * if cancel button clicked, close the Delete Song UI window
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(478, 387, 193, 54);
		frame.getContentPane().add(btnCancel);

		JComboBox<String> comboBoxSong = new JComboBox<String>();
		// populate combo box with titles of each song entry in database
		songDAO.openConnection();
		List<Song> temp = songDAO.getSongs();
		for (Song song : temp) {
			comboBoxSong.addItem(song.getTitle());
		}
		songDAO.closeConnection();
		comboBoxSong.addActionListener(new ActionListener() {
			/**
			 * reads text from combo box
			 */
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboSong = (JComboBox<String>) e.getSource();
				songTitle = (String) comboSong.getSelectedItem();
			}
		});

		comboBoxSong.setBounds(578, 326, 534, 34);
		frame.getContentPane().add(comboBoxSong);
	}

	/**
	 * gets frame so that Delete Song UI window can be opened from Music
	 * Collection Catalogue UI
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

}
