package com.belatrixsf.loggingutil.handlers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrixsf.loggingutil.MyLogConfig;
import com.belatrixsf.loggingutil.loggers.CustomLogger;

public class FileCustomHandler {
	private FileHandler fileHandler ;

	public FileCustomHandler(MyLogConfig config) {
		try {
			 fileHandler = new FileHandler(config.getDbParams().get("logFileFolder") + "/logFile.txt");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void log(Level level, CustomLogger customLogger) {
		Logger.getLogger("MyLog").addHandler(fileHandler);
		Logger.getLogger("MyLog").log(level, customLogger.getMessageText());
	}

}
