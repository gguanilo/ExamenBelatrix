package com.belatrixsf.loggingutil;

import java.util.logging.Level;

import com.belatrixsf.loggingutil.handlers.ConsoleCustomHandler;
import com.belatrixsf.loggingutil.handlers.DatabaseHandler;
import com.belatrixsf.loggingutil.handlers.FileCustomHandler;
import com.belatrixsf.loggingutil.loggers.CustomLogger;
import com.belatrixsf.loggingutil.loggers.ErrorCustomLogger;
import com.belatrixsf.loggingutil.loggers.InfoCustomLogger;
import com.belatrixsf.loggingutil.loggers.WarningCustonLog;

public class MyLog {

	private MyLogConfig config;

	public MyLog(MyLogConfig config) {
		this.config = config;
	}

	public void notify(String messageText, String level) throws RuntimeException {
		notify(new MessageLog(messageText, level));
	}

	private void notify(MessageLog message) {

		if (message.getMessageText() == null || message.getMessageText().isEmpty()) {
			throw new RuntimeException("Message is Null");
		}
		if (!config.isLogToConsole() && !config.isLogToFile() && !config.isLogToDatabase()) {
			throw new RuntimeException("Invalid configuration");
		}
		if ((!config.isLogError() && !config.isLogMessage() && !config.isLogWarning())) {
			throw new RuntimeException("Error or Warning or Message must be specified");
		}

		Level level = null;
		CustomLogger customLogger = null;
		if ("info".equals(message.getLevel())) {
			customLogger = new InfoCustomLogger(true);
			level = Level.INFO;
		} else if ("warning".equals(message.getLevel())) {
			customLogger = new WarningCustonLog(true);
			level = Level.WARNING;
		} else if ("error".equals(message.getLevel())) {
			customLogger = new ErrorCustomLogger(true);
			level = Level.SEVERE;
		}

		customLogger.setValores(message.getMessageText());

		if (config.isLogToConsole()) {
			new ConsoleCustomHandler(config).log(level, customLogger);
		}
		
		if(config.isLogToFile()) {
			new FileCustomHandler(config).log(level, customLogger);
		}
		
		if(config.isLogToDatabase()) {
			new DatabaseHandler(config).log(level, customLogger);
		}


	}

}
