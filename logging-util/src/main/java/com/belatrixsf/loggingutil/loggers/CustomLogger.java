package com.belatrixsf.loggingutil.loggers;

import java.text.DateFormat;
import java.util.Date;

public abstract class CustomLogger {
	
	private String messageText;

	public String getMessageText() {
		return this.messageText;
	}

	private boolean printFlag;
	private int type = 0;
	
	public CustomLogger(boolean printFlag) {
		this.printFlag=printFlag;
	}
	
	public CustomLogger(boolean printFlag, String messageText) {
		// TODO Auto-generated constructor stub
		this.printFlag=printFlag;
		this.messageText = messageText;
	}
	
	public String getMessage(String message) {
		return  DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
	}

	public boolean isPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(boolean printFlag) {
		this.printFlag = printFlag;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setMessageText(String message) {
		// TODO Auto-generated method stub
		this.messageText = message;
	}
	
	public void setValores(String message) {
		if (isPrintFlag()) {
			setValoresCustom(message);
		}
	}

	public abstract void setValoresCustom(String message);
}
