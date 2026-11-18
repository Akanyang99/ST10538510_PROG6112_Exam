/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package st10538510_question2;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductApp extends JFrame implements ActionListener {

    // Form Controls (Q.2.2)
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Menu Items (Q.2.4)
    private JMenuItem mnuExit;
    private JMenuItem mnuProcess;
    private JMenuItem mnuClear;

    public ProductApp() {
        // Window Title matching Sample Screenshot ("Product App")
        super("Product App");
        setSize(400, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. Build Menu Bar: File -> Exit | Tools -> Process, Clear (Q.2.4)
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        mnuExit = new JMenuItem("Exit");
        mnuExit.addActionListener(this);
        fileMenu.add(mnuExit);

        JMenu toolsMenu = new JMenu("Tools");
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");
        mnuProcess.addActionListener(this);
        mnuClear.addActionListener(this);
        toolsMenu.add(mnuProcess);
        toolsMenu.add(mnuClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // 2. Build Input Form Panel (Q.2.2)
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 12));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        formPanel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        formPanel.add(txtCustomerName);

        formPanel.add(new JLabel("Select Product:"));
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        formPanel.add(cmbProduct);

        formPanel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        add(formPanel, BorderLayout.CENTER);

        // 3. Build PROCESS Button Panel (Q.2.3)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 15, 20));
        btnProcess = new JButton("PROCESS");
        btnProcess.setPreferredSize(new Dimension(220, 30));
        btnProcess.addActionListener(this);
        buttonPanel.add(btnProcess);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Exit menu item closes the application (Q.2.4)
        if (source == mnuExit) {
            System.exit(0);
        }
        // PROCESS button and Process menu item share the exact same logic (Q.2.3 & Q.2.4)
        else if (source == btnProcess || source == mnuProcess) {
            processSale();
        }
        // Clear menu item resets text boxes and combo box to index 0 (Q.2.4)
        else if (source == mnuClear) {
            clearFields();
        }
    }

    // Captures inputs, calculates VAT/Commission/Total, displays popup, and saves to data.txt (Q.2.3)
    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String productName = cmbProduct.getSelectedItem().toString();
        String priceText = txtPrice.getText().trim();

        // Validation for empty fields or invalid numbers
        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Customer Name and Price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Perform calculations using ProductCalculationsTest class
            ProductCalculationsTest calc = new ProductCalculationsTest(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Format output matching Sample Screenshot
            String output = "Customer Name: " + customerName + "\n"
                          + "Product: " + productName + "\n"
                          + String.format("VAT: R %.1f%n", vat)
                          + String.format("COMMISSION: R %.1f%n", commission)
                          + String.format("TOTAL: R %.1f", total);

            // Display JOptionPane popup message
            JOptionPane.showMessageDialog(this, output, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            saveToFile(output);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Writes the DATA LOG to data.txt (Q.2.3)
    private void saveToFile(String formattedDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            writer.write("DATA LOG\n");
            writer.write("*******************************\n");
            writer.write(formattedDetails + "\n");
            writer.write("*******************************\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to data.txt: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clears text boxes and resets combo box index to 0 (Q.2.4)
    private void clearFields() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}
