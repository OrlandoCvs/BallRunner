import  javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("ComponentDisplayer");

        JPanel p = new JPanel(new BorderLayout());
        Board boarD = new Board();
        p.add(boarD, BorderLayout.CENTER);
        f.addKeyListener(boarD);
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}