package learn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageProducer;
import java.io.IOException;

public class FirstFrame {
    public static void main(String args[]) {
        Frame frame = new Frame("First frame");
        frame.setSize(200,200);
        frame.setLocation(400,200);
        ImageIcon imageIcon = new ImageIcon("/home/hadoop/IdeaProjects/awtLearn/images/keji.jpg");
        Image image = imageIcon.getImage();
        frame.setIconImage(image);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
    }
}
