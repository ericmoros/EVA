package com.hotmail.steven.bconomy.storage;

import java.sql.ResultSet;
import java.sql.Statement;

public interface Database {

	/**
	 * Open a connection to the database
	 */
	public void openDataConnection();
	
	/**
	 * Close the database connection
	 */
	public void closeDataConnection();
	
	/**
	 * Get the connection statement
	 * @return
	 */
	public Statement getDataStatement();
	
	/**
	 * Execute a select query
	 * @param query
	 * @return
	 */
	public ResultSet select(String query);
	
	/**
	 * Update the database
	 * @param query
	 */
	public void update(String query);
	
	/**
	 * Execute a query e.g delete
	 * @param query
	 */
	public void execute(String query);
	
	/**
	 * Check if a table exists
	 * @param tableName
	 * @return
	 */
	public boolean hasTable(String tableName);
	
}
