/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import nf.ImageProcessing;

/**
 *
 * @author Julie
 */
public class ImageRadio extends JPanel {
    private ImageIcon radioImage;

    public ImageRadio() {
            ImageProcessing img = new ImageProcessing("C:\\Users\\Julie\\Downloads\\pgm\\pgm\\abdomen\\cor494-i43.pgm");
            img.greyLevels();
            radioImage = new ImageIcon(img.getImg());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            int x = (getWidth() - radioImage.getIconWidth()) / 2;
            int y = (getHeight() - radioImage.getIconHeight()) / 2;
            g.drawImage(radioImage.getImage(), x, y, radioImage.getIconWidth(), radioImage.getIconHeight(), this);
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame(ImageRadio.class.getSimpleName());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final ImageRadio IR = new ImageRadio();
                frame.add(IR);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
