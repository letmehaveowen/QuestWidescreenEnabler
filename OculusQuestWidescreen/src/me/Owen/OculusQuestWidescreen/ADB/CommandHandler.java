package me.Owen.OculusQuestWidescreen.ADB;

import javax.swing.JProgressBar;

import me.Owen.OculusQuestWidescreen.MainClass;
import me.Owen.OculusQuestWidescreen.JFrame.MessageBox;

public class CommandHandler {
	public static void pushCommandsToQuest() {
		JProgressBar progressBar = MainClass.getInstance().frame.progressBar;
		int commands = 4;
		int percentageIncrease = 100/commands;
		
		String width = MainClass.getInstance().frame.width.getText();
		String height = MainClass.getInstance().frame.height.getText();
		String bitrate = MainClass.getInstance().frame.bitrate.getText();
		
		if (Devices.sendCommandToDevice("width", width)) {
			progressBar.setValue(progressBar.getValue() + percentageIncrease);
		} else {
			error();
			return;
		}
		if (Devices.sendCommandToDevice("height", height)) {
			progressBar.setValue(progressBar.getValue() + percentageIncrease);
		} else {
			error();
			return;
		}
		if (Devices.sendCommandToDevice("bitrate", bitrate)) {
			progressBar.setValue(progressBar.getValue() + percentageIncrease);
		} else {
			error();
			return;
		}
		if (Devices.sendCommandToDevice("fps", "60")) {
			progressBar.setValue(progressBar.getValue() + percentageIncrease);
		} else {
			error();
			return;
		}
		
		success();
	}
	
	private static void success() { 
		new MessageBox("Pushed commands to your Oculus Quest successfully!", "Success!", false).setVisible(true);
	}
	
	private static void error() { 
		new MessageBox("There was an error pushing a command to your Oculus Quest!", "Problem", false).setVisible(true);
	}
}
