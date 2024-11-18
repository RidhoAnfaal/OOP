package Jobsheet11;

import javax.swing.JFrame;

public class SimpleWindow extends JFrame {
    public SimpleWindow() {
        super();
        setBounds(250, 225, 300, 150);
    }

    public static void main(String[] args) {
        SimpleWindow sw = new SimpleWindow();
        sw.setVisible(true);
    }
}
