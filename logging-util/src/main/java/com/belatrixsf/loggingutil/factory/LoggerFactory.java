package com.belatrixsf.loggingutil.factory;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrixsf.loggingutil.MyLog;
import com.belatrixsf.loggingutil.MyLogConfig;
import com.belatrixsf.loggingutil.loggers.CustomLogger;
import com.belatrixsf.loggingutil.loggers.ErrorCustomLogger;
import com.belatrixsf.loggingutil.loggers.InfoCustomLogger;
import com.belatrixsf.loggingutil.loggers.WarningCustonLog;

public class LoggerFactory {
	private static MyLogConfig config;
	public static MyLog getLogger(String string, MyLogConfig config) {
		// TODO Auto-generated method stub
		return new MyLog(config);
	}

	public static MyLog getLogger(String string) {
		// TODO Auto-generated method stub
		return new MyLog(config);
	}
	
	
	public void setConfig(MyLogConfig config) {
		// TODO Auto-generated method stub
		this.config = config;
	}

	public static void log(String levelParam,String mensaje) {
		Level level = null;
		CustomLogger customLogger = null;
		if ("info".equals(levelParam)) {
			 customLogger = new InfoCustomLogger(true);
			 level = Level.INFO;
		} else if ("warning".equals(levelParam)) {
			 customLogger =  new WarningCustonLog(true);
			 level = Level.WARNING;
		} else if ("error".equals(levelParam)) {
			customLogger = new ErrorCustomLogger(true);
			level = Level.SEVERE;
		}
		
		customLogger.setValores(mensaje);
		if(config.isLogToConsole()) {
			Logger.getLogger("MyLog").addHandler(new ConsoleHandler());
			Logger.getLogger("MyLog").log(level, customLogger.getMessageText());
		}
	}

}
