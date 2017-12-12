package com.belatrixsf.loggingutil.loggers;

public class ErrorCustomLogger extends CustomLogger {

	public ErrorCustomLogger(boolean printFlag) {
		super(printFlag);
	}
	
	@Override
	public void setValoresCustom(String message) {
		// TODO Auto-generated method stub
		String formatedMessage="error " +getMessage(message);
		setType(2);
		setMessageText(formatedMessage);
	}
	
}
