package me.Owen.OculusQuestWidescreen;

import javax.swing.UIManager;

import me.Owen.OculusQuestWidescreen.JFrame.MainWindow;
import me.Owen.OculusQuestWidescreen.JFrame.MessageBox;
import me.Owen.OculusQuestWidescreen.Utils.QuestUtils;

public class MainClass {	
	private static MainClass instance;
	public static MainClass getInstance() {
		return instance;
	}
	
	public MainWindow frame;
	
	public static void main(String[] args) {
		new MainClass().ditchStatic();
	}
	
	public void ditchStatic() { 
		instance = this;
		initQuestUtils();
		initWindow();
	}
	
	private void initQuestUtils() { 
		QuestUtils questUtils = new QuestUtils();
		questUtils.checkForQuest();
		makeSureQuestConnected();
	}
	
	private void initWindow() { 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame = new MainWindow();
		frame.setVisible(true);
	}
	
	private void makeSureQuestConnected() {
		if (QuestUtils.multipleQuest) {
			new MessageBox("Please ensure only one Oculus Quest is connected.", "Problem", true).setVisible(true);
		} else if (QuestUtils.questCount == 0) {
			new MessageBox("Please ensure your Oculus Quest is connected.", "Problem", true).setVisible(true);
		}
	}
}
