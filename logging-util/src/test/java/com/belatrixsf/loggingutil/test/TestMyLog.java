package com.belatrixsf.loggingutil.test;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.h2.tools.RunScript;
import org.junit.Test;

import com.belatrixsf.loggingutil.MyLog;
import com.belatrixsf.loggingutil.MyLogConfig;
import com.belatrixsf.loggingutil.factory.LoggerFactory;

public class TestMyLog {

	@Test
	public void testLogToDatabase() {

		try {
			RunScript.execute("jdbc:h2:~/test", "sa", "sa", "src/test/resources/Init.sql", null, false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		MyLogConfig config = new MyLogConfig();
		config.setLogToDatabase(true);
		config.setLogError(true);
		Map<String, String> dbParams = new HashMap<String, String>();
		dbParams.put("userName", "sa");
		dbParams.put("password", "sa");
		dbParams.put("dbms", "h2");
		dbParams.put("serverName", "~/test");
		dbParams.put("portNumber", "");
		config.setDbParams(dbParams);
		MyLog logger = LoggerFactory.getLogger("MyLog", config);
		logger.notify(" - esto es una prueba", "error");
	}

	@Test
	public void testLogToFile() {
		MyLogConfig config = new MyLogConfig();
		config.setLogToFile(true);
		config.setLogError(true);
		Map<String, String> dbParams = new HashMap<String, String>();
		dbParams.put("logFileFolder", "D:/");
		config.setDbParams(dbParams);
		MyLog logger = LoggerFactory.getLogger("MyLog", config);
		logger.notify(" - esto es una prueba", "error");
		File file = new File("D:/logFile.txt");
		assertTrue(file.exists());
	}

	@Test
	public void testLogToConsole() {
		MyLogConfig config = new MyLogConfig();
		config.setLogToConsole(true);
		config.setLogError(true);
		MyLog logger = LoggerFactory.getLogger("MyLog", config);
		logger.notify(" - esto es una prueba", "error");
	}

}
