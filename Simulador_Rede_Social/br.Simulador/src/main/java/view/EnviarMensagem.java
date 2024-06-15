package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.Simulador.Connect;

public class ProductSalesUI extends JFrame {

    private JPanel contentPane;
    private JTable tableFriends;
    private JTable tableProducts;
    private DefaultTableModel friendsTableModel;
    private DefaultTableModel productsTableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductSalesUI frame = new ProductSalesUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProductSalesUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Table to display friends
        friendsTableModel = new DefaultTableModel();
        friendsTableModel.addColumn("Nome");
        friendsTableModel.addColumn("Email");
        tableFriends = new JTable(friendsTableModel);
        JScrollPane scrollPaneFriends = new JScrollPane(tableFriends);
        scrollPaneFriends.setBounds(20, 20, 360, 400);
        contentPane.add(scrollPaneFriends);

        // Table to display products with images
        productsTableModel = new DefaultTableModel() {
            // Override the getColumnClass method to specify the class of each column,
            // including the Image class for the column containing images.
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // Column index where the image will be displayed
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        productsTableModel.addColumn("Produto");
        productsTableModel.addColumn("Preço");
        productsTableModel.addColumn("Imagem"); // New column for images
        tableProducts = new JTable(productsTableModel);
        tableProducts.getColumnModel().getColumn(2).setPreferredWidth(100); // Adjust column width for images
        tableProducts.setRowHeight(100); // Set row height to fit images
        JScrollPane scrollPaneProducts = new JScrollPane(tableProducts);
        scrollPaneProducts.setBounds(400, 20, 360, 400);
        contentPane.add(scrollPaneProducts);

        // Button to view friends
        JButton buttonViewFriends = new JButton("Ver lista de amigos");
        buttonViewFriends.setBounds(20, 430, 150, 150);
        buttonViewFriends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) inser own
