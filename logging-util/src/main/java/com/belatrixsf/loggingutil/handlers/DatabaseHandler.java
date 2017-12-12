package com.belatrixsf.loggingutil.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.belatrixsf.loggingutil.MyLogConfig;
import com.belatrixsf.loggingutil.loggers.CustomLogger;

public class DatabaseHandler extends Handler {

	private Connection connection;

	public DatabaseHandler(MyLogConfig config) {
		// TODO Auto-generated constructor stub
		try {
			this.connection = getConnection(config);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DatabaseHandler() {
		// TODO Auto-generated constructor stub
	}

	public void log(Level level, CustomLogger customLogger) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = this.connection.prepareStatement("insert into LOG_VALUES(type,message) values(?,?)");
			preparedStatement.setInt(1, customLogger.getType());
			preparedStatement.setString(2, customLogger.getMessageText());
			preparedStatement.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Logger.getLogger("MyLog").addHandler(new DatabaseHandler());
		Logger.getLogger("MyLog").log(level, customLogger.getMessageText());
	}

	private Connection getConnection(MyLogConfig config) throws SQLException {
		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", config.getDbParams().get("userName"));
		connectionProps.put("password", config.getDbParams().get("password"));

		StringBuffer connectionString = new StringBuffer("jdbc:").append(config.getDbParams().get("dbms")).append(":")
				.append(config.getDbParams().get("serverName"));

		connection = DriverManager.getConnection(connectionString.toString(), connectionProps);
		return connection;
	}

	@Override
	public void publish(LogRecord record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() throws SecurityException {
		// TODO Auto-generated method stub

	}

}
