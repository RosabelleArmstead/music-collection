/**
 * MusicCollectionCatalogueUI.java
 */
package ra00528.music.catalogue.com1028;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ra00528.music.catalogue.com1028.dao.DAOFactory;
import ra00528.music.catalogue.com1028.dao.SongDAO;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Defines the properties and behaviour of the Music Collection Catalogue UI.
 * 
 * @author Rosabelle Armstead
 *
 */
public class MusicCollectionCatalogueUI {
	/** The UI components */
	private JFrame frame;
	private static JTable tableCatalogue;
	/** the song DAO */
	private SongDAO songDAO = null;
	/** the list of songs in the database */
	private List<Song> songs = new ArrayList<Song>();

	/**
	 * Launch application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicCollectionCatalogueUI window = new MusicCollectionCatalogueUI();
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
	public MusicCollectionCatalogueUI() {
		try {
			songDAO = DAOFactory.getSongDAO();
			songs = songDAO.getSongs();
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
	 * Initialise contents of the frame
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

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			/**
			 * if the add button is clicked, open the Add Song UI window
			 */
			public void actionPerformed(ActionEvent e) {
				AddSongUI addSong = new AddSongUI();
				addSong.getFrame().setVisible(true);
			}
		});
		btnAdd.setBounds(15, 874, 193, 54);
		frame.getContentPane().add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			/**
			 * if the delete button is clicked and there are songs in the
			 * database, open the Delete Song UI window, otherwise notify the
			 * user there are no songs
			 */
			public void actionPerformed(ActionEvent e) {
				songDAO.openConnection();
				songs = songDAO.getSongs();
				songDAO.closeConnection();
				if (songs.size() == 0) {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "No songs in database! Try again.");
				} else {
					DeleteSongUI deleteSong = new DeleteSongUI();
					deleteSong.getFrame().setVisible(true);
				}
			}
		});
		btnDelete.setBounds(223, 874, 193, 54);
		frame.getContentPane().add(btnDelete);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			/**
			 * if the search button is clicked, open the Search UI window
			 */
			public void actionPerformed(ActionEvent e) {
				SearchUI searchUI = new SearchUI();
				searchUI.getFrame().setVisible(true);
			}
		});
		btnSearch.setBounds(431, 874, 193, 54);
		frame.getContentPane().add(btnSearch);

		JComboBox comboBoxOrder = new JComboBox();
		comboBoxOrder.addActionListener(new ActionListener() {
			/**
			 * if the user selects a field from the combo box, connect to the
			 * database and run order catalogue method
			 */
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboOrder = (JComboBox<String>) e.getSource();
				String order = (String) comboOrder.getSelectedItem();
				List<Song> songs = new ArrayList<Song>();

				songDAO.openConnection();
				// refresh the table to show the ordered songs
				songs = songDAO.orderCatalogue(order);

				refreshTable(songs);

				songDAO.closeConnection();

			}
		});
		comboBoxOrder
				.setModel(new DefaultComboBoxModel(new String[] { "Title", "Album", "Artist", "Genre", "Format" }));
		comboBoxOrder.setBounds(1370, 874, 193, 54);
		frame.getContentPane().add(comboBoxOrder);

		JLabel lblOrderBy = new JLabel("Order By:");
		lblOrderBy.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOrderBy.setBounds(1210, 874, 154, 54);
		frame.getContentPane().add(lblOrderBy);

		JScrollPane scrollPane = new JScrollPane(tableCatalogue);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(15, 88, 1548, 770);
		frame.getContentPane().add(scrollPane);
		// set the table model using the list of songs
		catalogueTableModel model = new catalogueTableModel(songs);

		tableCatalogue = new JTable();
		tableCatalogue.setBounds(46, 849, 1492, -745);
		// populate the table with the songs using the catalogue table model
		tableCatalogue.setModel(model);
		tableCatalogue.setBackground(SystemColor.window);
		scrollPane.setViewportView(tableCatalogue);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			/**
			 * if the update button is clicked, open the Update Song UI window
			 */
			public void actionPerformed(ActionEvent e) {
				UpdateSongUI updateSong = new UpdateSongUI();
				updateSong.getFrame().setVisible(true);
			}
		});
		btnUpdate.setBounds(639, 874, 193, 54);
		frame.getContentPane().add(btnUpdate);

		JButton btnPlaySong = new JButton("Play Song");
		btnPlaySong.addActionListener(new ActionListener() {
			/**
			 * if the play button is clicked, open the Media Player UI window
			 */
			public void actionPerformed(ActionEvent e) {
				MediaPlayerUI mediaPlayer = new MediaPlayerUI();
				mediaPlayer.getFrame().setVisible(true);
			}
		});
		btnPlaySong.setBounds(847, 874, 193, 54);
		frame.getContentPane().add(btnPlaySong);

		JButton btnRefreshTable = new JButton("Refresh Table");
		btnRefreshTable.addActionListener(new ActionListener() {
			/**
			 * if the refresh button is clicked, refresh the table
			 */
			public void actionPerformed(ActionEvent e) {
				songDAO.openConnection();
				List<Song> songs = null;
				songs = songDAO.getSongs();
				refreshTable(songs);
				songDAO.closeConnection();
			}
		});
		btnRefreshTable.setBounds(1055, 874, 193, 54);
		frame.getContentPane().add(btnRefreshTable);

	}

	/**
	 * redisplays the JTable using a list of songs
	 * 
	 * @param songs
	 */
	public static void refreshTable(List<Song> songs) {

		catalogueTableModel model = new catalogueTableModel(songs);
		tableCatalogue.setModel(model);

	}

	/**
	 * gets frame
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
