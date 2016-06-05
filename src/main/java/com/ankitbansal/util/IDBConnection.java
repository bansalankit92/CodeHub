package com.ankitbansal.util;

import java.sql.Connection;

public interface IDBConnection {

	public Connection getConection();
	public void closeConnection();
}
