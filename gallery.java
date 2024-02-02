import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageGallery extends JFrame {
    private ImageIcon[] images = {
            new ImageIcon("Chrysanthemum.jpg"),
            new ImageIcon("Desert.jpg"),
            new ImageIcon("Jellyfish.jpg"),
            new ImageIcon("Penguins.jpg")
    };
    private int currentImageIndex = 0;
    private JLabel imageLabel;

    public ImageGallery() {
        super("Image Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
                imageLabel.setIcon(images[currentImageIndex]);
            }
        });
        buttonPanel.add(previousButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % images.length;
                imageLabel.setIcon(images[currentImageIndex]);
            }
        });
        buttonPanel.add(nextButton);

        imageLabel = new JLabel(images[currentImageIndex]);
        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ImageGallery();
    }
}
