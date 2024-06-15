package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
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

        // Table to display products
        productsTableModel = new DefaultTableModel();
        productsTableModel.addColumn("Produto");
        productsTableModel.addColumn("Preço");
        tableProducts = new JTable(productsTableModel);
        JScrollPane scrollPaneProducts = new JScrollPane(tableProducts);
        scrollPaneProducts.setBounds(400, 20, 360, 400);
        contentPane.add(scrollPaneProducts);

        // Button to view friends
        JButton buttonViewFriends = new JButton("Ver lista de amigos");
        buttonViewFriends.setBounds(20, 430, 150, 30);
        buttonViewFriends.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar código para exibir a lista de amigos
                try {
                    String query = "SELECT nome, email FROM amigos";
                    Statement stmt = Connect.getConnection().createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    // Limpar tabela de amigos antes de atualizar
                    friendsTableModel.setRowCount(0);

                    // Preencher dados na tabela de amigos
                    while (rs.next()) {
                        friendsTableModel.addRow(new Object[]{rs.getString("nome"), rs.getString("email")});
                    }

                    rs.close();
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao carregar lista de amigos.");
                }
            }
        });
        contentPane.add(buttonViewFriends);

        // Button to add product to list
        JButton buttonAddProduct = new JButton("Adicionar Produto");
        buttonAddProduct.setBounds(400, 430, 150, 30);
        buttonAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar código para adicionar produtos à lista
                String productName = JOptionPane.showInputDialog(null, "Digite o nome do produto:");
                String productPriceStr = JOptionPane.showInputDialog(null, "Digite o preço do produto:");
                if (productName != null && productPriceStr != null) {
                    double productPrice = Double.parseDouble(productPriceStr);
                    productsTableModel.addRow(new Object[]{productName, productPrice});
                }
            }
        });
        contentPane.add(buttonAddProduct);

        // Button to sell product
        JButton buttonSellProduct = new JButton("Vender Produto");
        buttonSellProduct.setBounds(620, 430, 140, 30);
        buttonSellProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar se um amigo está selecionado na tabela
                int selectedFriendRow = tableFriends.getSelectedRow();
                if (selectedFriendRow == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um amigo para vender o produto.");
                    return;
                }

                // Verificar se um produto está selecionado na tabela
                int selectedProductRow = tableProducts.getSelectedRow();
                if (selectedProductRow == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para vender.");
                    return;
                }

                // Obter dados do amigo selecionado
                String nomeAmigo = (String) tableFriends.getValueAt(selectedFriendRow, 0);
                String emailAmigo = (String) tableFriends.getValueAt(selectedFriendRow, 1);

                // Obter dados do produto selecionado
                String nomeProduto = (String) tableProducts.getValueAt(selectedProductRow, 0);
                double precoProduto = (double) tableProducts.getValueAt(selectedProductRow, 1);

                // Implementar lógica para iniciar o processo de venda com o amigo selecionado
                JOptionPane.showMessageDialog(null, "Iniciando processo de venda com " + nomeAmigo + " (" + emailAmigo + ")"
                        + "\nProduto vendido: " + nomeProduto + " por R$" + precoProduto);
                // Implementar a lógica de venda aqui...
            }
        });
        contentPane.add(buttonSellProduct);
    }
}

