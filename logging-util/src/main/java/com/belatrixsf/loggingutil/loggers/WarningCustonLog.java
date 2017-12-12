package com.belatrixsf.loggingutil.loggers;

public class WarningCustonLog extends CustomLogger {

	public WarningCustonLog(boolean printFlag) {
		super(printFlag);
		//setPrintFlag(_printFlag);
	}


	@Override
	public void setValoresCustom(String message) {
		// TODO Auto-generated method stub
		String formatedMessage="warning " +getMessage(message);
		setType(3);
		setMessageText(formatedMessage);
	}
	
}
