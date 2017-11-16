/**
 * MediaPlayerUI.java
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
import javax.swing.SwingConstants;

import ra00528.music.catalogue.com1028.dao.DAOFactory;
import ra00528.music.catalogue.com1028.dao.SongDAO;

/**
 * Defines the properties and behaviour of the Media Player UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class MediaPlayerUI {
	/** The UI components */
	private JFrame frame;
	/** the song DAO */
	private SongDAO songDAO = null;
	/** the title of the song chosen to delete */
	private String songTitle = null;
	/** the mp3 player */
	MP3Player mp3Player = new MP3Player();

	/**
	 * Launch application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MediaPlayerUI window = new MediaPlayerUI();
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
	public MediaPlayerUI() {
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

		JLabel lblPlaySong = new JLabel("Play Song");
		lblPlaySong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaySong.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPlaySong.setBounds(673, 100, 249, 41);
		frame.getContentPane().add(lblPlaySong);

		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			/**
			 * When play button pressed, find song that matches song title
			 * chosen by user, set filepath in the mp3Player class and play the
			 * .mp3 file
			 */
			public void actionPerformed(ActionEvent e) {
				songDAO.openConnection();
				List<Song> songs = songDAO.getSongs();
				Song play = null;
				String filepath = null;

				for (Song song : songs) {
					if (songTitle.equals(song.getTitle())) {
						play = song;
						filepath = play.getFilepath();
						// set filepath so that it is readable by .mp3 player
						filepath = filepath.replace('\\', '/');
					}
				}

				mp3Player.setPath(filepath);
				mp3Player.play(-1);
				songDAO.closeConnection();
			}
		});
		btnPlay.setBounds(969, 387, 193, 54);
		frame.getContentPane().add(btnPlay);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			/**
			 * if cancel button clicked, stop playing the file and close the
			 * Media Player UI window
			 */
			public void actionPerformed(ActionEvent e) {
				mp3Player.stop();
				frame.dispose();
			}
		});
		btnCancel.setBounds(521, 387, 193, 54);
		frame.getContentPane().add(btnCancel);

		JComboBox<String> comboBoxSong = new JComboBox<String>();
		// populate combo box with titles of each song entry in database
		songDAO.openConnection();
		List<Song> temp = songDAO.getSongs();
		for (Song song : temp) {
			if (song.getFilepath() != null) {
				comboBoxSong.addItem(song.getTitle());
			}
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

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			/**
			 * if stop button is clicked, stop playing .mp3 file
			 */
			public void actionPerformed(ActionEvent arg0) {
				mp3Player.stop();
			}
		});
		btnStop.setBounds(749, 387, 193, 54);
		frame.getContentPane().add(btnStop);
	}

	/**
	 * gets frame so that Media Player UI window can be opened from Music
	 * Collection Catalogue UI
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
