package com.belatrixsf.loggingutil;

public class MessageLog {
	
     private String messageText;
     private String level;
     
	 MessageLog(String messageText, String level) {
		this.messageText=messageText;
		this.level=level;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
