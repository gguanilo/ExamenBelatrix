package com.belatrixsf.loggingutil.loggers;


public class InfoCustomLogger extends CustomLogger {

	public InfoCustomLogger(boolean printFlag) {
		super(printFlag);

	}

	public InfoCustomLogger(boolean printFlag, String messageText) {
		// TODO Auto-generated constructor stub
		super(printFlag,messageText);
	}

	public void setValoresCustom(String message) {
		// TODO Auto-generated method stub
		String formatedMessage="message " +getMessage(message);
		setType(1);
		setMessageText(formatedMessage);
	}
}
