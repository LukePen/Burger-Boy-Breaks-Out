package main;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//This class controls the title screen, displaying the image
public class TitleScreen{
	JFrame frame;
	public TitleScreen() throws IOException{
	BufferedImage img = ImageIO.read(getClass().getResource("/images/mmmbunger.jpg"));

    ImageIcon icon=new ImageIcon(img);
    frame=new JFrame();
    frame.setLayout(new FlowLayout());
    frame.setSize(1000,800);
    JLabel lbl=new JLabel();
    lbl.setIcon(icon);
    frame.add(lbl);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//This method resets the JFrame
	public void reset() {
		frame.dispose();
	}
}
