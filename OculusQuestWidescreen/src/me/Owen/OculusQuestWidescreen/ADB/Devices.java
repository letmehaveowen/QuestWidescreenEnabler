package me.Owen.OculusQuestWidescreen.ADB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import me.Owen.OculusQuestWidescreen.Device.Device;
import me.Owen.OculusQuestWidescreen.JFrame.MessageBox;

public class Devices {
	public static Device[] getDevices() throws IOException {
		Process process = Runtime.getRuntime().exec("adb devices -l");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		ArrayList<String> messagesArrayList = new ArrayList<>();
		String temp = null;
		while((temp = reader.readLine()) != null) {
			if (!temp.isEmpty())
				messagesArrayList.add(temp);
		}
		
		String[] messagesArray = new String[messagesArrayList.size()];
		messagesArrayList.remove(0);
		messagesArrayList.toArray(messagesArray);
		
		ArrayList<Device> deviceList = new ArrayList<>();
		for (String device : messagesArrayList) {
			deviceList.add(new Device(device));
		}
		
		Device[] tempArray = new Device[deviceList.size()];
		return deviceList.toArray(tempArray);
	}
	
	public static boolean sendCommandToDevice(String key, String value) {
		Device[] devices = null;
		
		try {
			devices = getDevices();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		if (!devices[0].getIsQuest()) {
			new MessageBox("There is no longer an Oculus Quest connected.", "Problem", false).setVisible(true);
			System.out.println("No Quest Connected.");
			return false;
		}
		
		try {
			Runtime.getRuntime().exec("adb shell setprop debug.oculus.capture." + key + " " + value);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
