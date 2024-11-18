/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.myinputform;

/**
 *
 * @author MSI
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyInputForm extends JFrame {
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 200;
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel cLabel;
    private JLabel dLabel;
    private JTextField aField;
    private JTextField bField;
    private JButton multiplyButton;
    private JButton sumButton;
    private JPanel panel;

    public MyInputForm() {
        createTextField();
        createButton();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        aLabel = new JLabel("Nilai A: ");
        bLabel = new JLabel("Nilai B: ");
        cLabel = new JLabel("Hasil Perkalian: ");
        dLabel = new JLabel("Hasil Penjumlahan: ");

        final int FIELD_WIDTH = 10;
        aField = new JTextField(FIELD_WIDTH);
        aField.setText("0");
        bField = new JTextField(FIELD_WIDTH);
        bField.setText("0");
    }

    private void createButton() {
        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int a = Integer.parseInt(aField.getText()); 
                int b = Integer.parseInt(bField.getText());
                int c = a * b; 
                cLabel.setText("Multiply result: " + c);
            }
        });

        sumButton = new JButton("Sum");
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int a = Integer.parseInt(aField.getText()); 
                int b = Integer.parseInt(bField.getText());
                int d = a + b; 
                dLabel.setText("Sum result: " + d); 
            }
        });
    }

    private void createPanel() {
        panel = new JPanel();
        panel.add(aLabel);
        panel.add(aField);
        panel.add(bLabel);
        panel.add(bField);
        panel.add(multiplyButton); 
        panel.add(sumButton); 
        panel.add(cLabel);
        panel.add(dLabel);
        add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new MyInputForm();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
