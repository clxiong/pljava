/*
 * This file contains software that has been made available under
 * The Mozilla Public License 1.1. Use and distribution hereof are
 * subject to the restrictions set forth therein.
 *
 * Copyright (c) 2003 TADA AB - Taby Sweden
 * All Rights Reserved
 */
package org.postgresql.pljava;

import org.postgresql.pljava.internal.AclId;

/**
 * Provides access to some useful routines in the PostgreSQL server.
 * @author Thomas Hallgren
 */
public class Server
{
	/**
	 * Debugging messages, in categories of
	 * decreasing detail.
	 */
	public static final int LOG_DEBUG5	= 10;
	public static final int LOG_DEBUG4	= 11;
	public static final int LOG_DEBUG3	= 12;
	public static final int LOG_DEBUG2	= 13;
	public static final int LOG_DEBUG1	= 14;

	/**
	 * Server operational messages; sent only
	 * to server log by default.
	 */
	public static final int LOG_LOG		= 15;

	/**
	 * Informative messages that are always
	 * sent to client;	is not affected by
	 * client_min_messages
	 */
	public static final int LOG_INFO	= 17;
	/**
	 * Helpful messages to users about query
	 * operation;  sent to client and server
	 * log by default.
	 */
	public static final int LOG_NOTICE	= 18;
	
	/**
	 * Warnings
	 */
	public static final int LOG_WARNING	= 19;

	/**
	 * Log a message using {@link #LOG_LOG] level.
	 * @param str
	 */
	public static void log(String str)
	{
		log(LOG_LOG, str);
	}

	/**
	 * Log a message using {@link #LOG_INFO] level.
	 * @param str
	 */
	public static void info(String str)
	{
		log(LOG_INFO, str);
	}

	/**
	 * Log a message using {@link #LOG_WARNING] level.
	 * @param str
	 */
	public static void warn(String str)
	{
		log(LOG_INFO, str);
	}

	/**
	 * Log a message using {@link #LOG_DEBUG1] level.
	 * @param str
	 */
	public static void debug(String str)
	{
		log(LOG_DEBUG1, str);
	}

	/**
	 * Return the current user.
	 */
	public static String getUserName()
	{
		return AclId.getUser().getName();
	}

	/**
	 * Return the session user.
	 */
	public static String getSessionUserName()
	{
		return AclId.getSessionUser().getName();
	}

	/**
	 * Log a message using the internal elog command.
	 * @param logLevel The log level.
	 * @param str The message
	 */
	public native static void log(int logLevel, String str);
}
