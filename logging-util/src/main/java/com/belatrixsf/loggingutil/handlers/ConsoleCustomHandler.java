package com.belatrixsf.loggingutil.handlers;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrixsf.loggingutil.MyLogConfig;
import com.belatrixsf.loggingutil.loggers.CustomLogger;

public class ConsoleCustomHandler {

	
	public ConsoleCustomHandler(MyLogConfig config) {
		// TODO Auto-generated constructor stub
	}

	public void log(Level level, CustomLogger customLogger) {
		Logger.getLogger("MyLog").addHandler(new ConsoleHandler());
		Logger.getLogger("MyLog").log(level, customLogger.getMessageText());
	}

}
