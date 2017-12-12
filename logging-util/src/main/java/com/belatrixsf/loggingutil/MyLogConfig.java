package com.belatrixsf.loggingutil;

import java.util.Map;

public class MyLogConfig {
	@Override
	public String toString() {
		return "MyLogConfig [logToFile=" + logToFile + ", logToConsole=" + logToConsole + ", logMessage=" + logMessage
				+ ", logWarning=" + logWarning + ", logError=" + logError + ", logToDatabase=" + logToDatabase
				+ ", dbParams=" + dbParams + "]";
	}

	private boolean logToFile;
	private boolean logToConsole;
	private boolean logMessage;
	private boolean logWarning;
	private boolean logError;
	private boolean logToDatabase;
	private Map<String, String> dbParams;

	public MyLogConfig() {
	}

	public boolean isLogToFile() {
		return logToFile;
	}

	public void setLogToFile(boolean logToFile) {
		this.logToFile = logToFile;
	}

	public boolean isLogToConsole() {
		return logToConsole;
	}

	public void setLogToConsole(boolean logToConsole) {
		this.logToConsole = logToConsole;
	}

	public boolean isLogMessage() {
		return logMessage;
	}

	public void setLogMessage(boolean logMessage) {
		this.logMessage = logMessage;
	}

	public boolean isLogWarning() {
		return logWarning;
	}

	public void setLogWarning(boolean logWarning) {
		this.logWarning = logWarning;
	}

	public boolean isLogError() {
		return logError;
	}

	public void setLogError(boolean logError) {
		this.logError = logError;
	}

	public boolean isLogToDatabase() {
		return logToDatabase;
	}

	public void setLogToDatabase(boolean logToDatabase) {
		this.logToDatabase = logToDatabase;
	}

	public Map<String, String> getDbParams() {
		return dbParams;
	}

	public void setDbParams(Map<String, String> dbParams) {
		this.dbParams = dbParams;
	}
}