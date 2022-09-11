package me.Owen.OculusQuestWidescreen.Device;

public class Device {
	private String nameString;
	private boolean isQuest;
	
	public Device(String nameString) {
		this.nameString = nameString;
		this.checkForQuest();
	}
	
	private void checkForQuest() { 
		if (nameString.toLowerCase().contains("quest")) {
			isQuest = true;
		}
	}
	
	public boolean getIsQuest() { 
		return this.isQuest;
	}
	
	public String getName() {
		return this.nameString;
	}
}
