package me.Owen.OculusQuestWidescreen.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import me.Owen.OculusQuestWidescreen.ADB.CommandHandler;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = -8173773571516369128L;

	private JPanel panel;
	public JTextField width;
	public JTextField height;
	public JTextField bitrate;
	public JProgressBar progressBar;

	public MainWindow() {
		Image image = null;
		try {
			image = ImageIO.read(MainWindow.class.getResourceAsStream("/resources/quest.png"));
			this.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Oculus Quest Widescreen Enabler");
		setBounds(100, 100, 450, 200);
		setResizable(false);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JLabel titleLabel = new JLabel("Oculus Quest Widescreen Enabler by Owen Mason");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 11, 434, 35);
		panel.add(titleLabel);

		width = new JTextField();
		width.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		width.setFont(new Font("Arial", Font.PLAIN, 11));
		width.setHorizontalAlignment(SwingConstants.CENTER);
		width.setText("1280");
		width.setBounds(10, 78, 86, 20);
		panel.add(width);
		width.setColumns(10);

		height = new JTextField();
		height.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		height.setFont(new Font("Arial", Font.PLAIN, 11));
		height.setHorizontalAlignment(SwingConstants.CENTER);
		height.setText("720");
		height.setBounds(338, 78, 86, 20);
		panel.add(height);
		height.setColumns(10);

		JLabel widthLabel = new JLabel("Width");
		widthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		widthLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		widthLabel.setBounds(10, 57, 86, 20);
		panel.add(widthLabel);

		JLabel heightLabel = new JLabel("Height");
		heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heightLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		heightLabel.setBounds(338, 57, 86, 20);
		panel.add(heightLabel);

		JLabel bitrateLabel = new JLabel("Bitrate");
		bitrateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bitrateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		bitrateLabel.setBounds(106, 57, 222, 20);
		panel.add(bitrateLabel);

		bitrate = new JTextField();
		bitrate.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		bitrate.setFont(new Font("Arial", Font.PLAIN, 11));
		bitrate.setHorizontalAlignment(SwingConstants.CENTER);
		bitrate.setText("100000");
		bitrate.setBounds(175, 78, 86, 20);
		panel.add(bitrate);
		bitrate.setColumns(10);

		JButton startButton = new JButton("Go");
		startButton.setFont(new Font("Arial", Font.PLAIN, 11));
		startButton.setBounds(10, 109, 424, 23);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed();
			}
		});
		panel.add(startButton);

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 141, 424, 20);
		panel.add(progressBar);
	}

	public void buttonPressed() {
		CommandHandler.pushCommandsToQuest();
	}
}
