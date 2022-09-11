package me.Owen.OculusQuestWidescreen.JFrame;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MessageBox extends JFrame {
	private static final long serialVersionUID = 3107449584636808295L;
	private JPanel contentPane;
		
	public MessageBox(String message, String title, boolean close) {
		Image image = null;
		try {
			image = ImageIO.read(MessageBox.class.getResourceAsStream("/resources/quest.png"));
			this.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 160);
		this.setTitle(title);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Null");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 26));
		titleLabel.setBounds(6, 6, 120, 32);
		contentPane.add(titleLabel);
		
		JLabel messageLabel = new JLabel("Null");
		messageLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		messageLabel.setVerticalAlignment(SwingConstants.TOP);
		messageLabel.setBounds(6, 50, 318, 40);
		contentPane.add(messageLabel);
		
		JButton btnAlright = new JButton("Alright");
		btnAlright.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlright.setBounds(217, 92, 117, 29);
		btnAlright.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (close)
					System.exit(0);
				else
					dispose();
			}
			
		});
		contentPane.add(btnAlright);
		
		titleLabel.setText(title);
		
		messageLabel.setText(message);
	}
}